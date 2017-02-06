package main.java.module1.lection4;

import java.lang.ref.*;

class Ref_A{

}

public class GarbCollect {
//    Heap : (eden -> young -> old generation)
//    GC support multithreading
//    We can't invoke GC immediately! (System.gc() is just a recommendation)

//    finalize invoking before GC (isn't recommended - use finally blocks instead)

//    Refs:
//    Strong, Soft, Weak, Phantom

    public static void main(String[] args) throws InterruptedException {
//        pa - strong reference (object would NOT be deleted before it has strong ref)
        Ref_A pa = new Ref_A();

        /*----------------------------------------------------------------------------*/
        /*--------------------------------SOFT-REFERENCE------------------------------*/
        /*----------------------------------------------------------------------------*/

//        rs -> soft reference
//        if any object has an soft ref GC must decide, is available memory is necessary
//              and then delete or leave
        Reference<Ref_A> rs = new SoftReference<>(pa);
        pa = null;
        System.gc(); //after that there no guarantees that object exists

//        Extract object by soft reference
        Ref_A pa1 = rs.get();
        if (pa1 == null) {
            pa1 = new Ref_A();
        }

        /*----------------------------------------------------------------------------*/
        /*--------------------------------WEAK-REFERENCE------------------------------*/
        /*----------------------------------------------------------------------------*/

//         If object has weak reference, object would be deleted
        Reference<Ref_A> rw = new WeakReference<Ref_A>(pa1);
        pa1 = null;
        System.gc();

        Ref_A pa2 = rs.get();
        if (pa2 == null) {
            pa2 = new Ref_A();
        }

        /*----------------------------------------------------------------------------*/
        /*--------------------------------PHANTOM-REFERENCE---------------------------*/
        /*----------------------------------------------------------------------------*/

//        If gc find phantom ref, gc will behave like with weak ref
//        Before this object would be deleted, reference on it would be putted to Queue
//        This ref is used for controlling the number of objects in system
        Ref_A pa3 = new Ref_A();
        ReferenceQueue rq = new ReferenceQueue(); // with weak would be putted AFTER
        Reference<Ref_A> rp = new PhantomReference<>(pa3, rq);
        rp.get(); //Always null!!!

        pa3 = null;
        System.out.println(rq.poll());
        System.gc();
        Thread.sleep(3000);
        System.gc();
        System.out.println(rq.poll()); //shows deleted objects
    }
}

