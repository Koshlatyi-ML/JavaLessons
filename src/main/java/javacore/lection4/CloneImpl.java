package main.java.module1.lection4;

public class CloneImpl {
    //Only one method is overriden in arrays : #clone()
    //Cloning: shallow and deep

    // Cloning has two ways:
    //      copying constructor;
    //      overriding clone()
    //          +  interface Cloneable (deprecated after annotations);
}

class CopyConstr {
    CopyConstr(CopyConstr cc) {
        //...
    }
}

//if hasn't been implemented -> exception
class CloneableImpl implements Cloneable {
    int a;
    int[] arr;

    @Override
    public CloneableImpl clone() throws CloneNotSupportedException {
        //shallow cloning (references copying)
/*        CloneableImpl copy = new CloneableImpl();
        copy.a = this.a;
        copy.arr = this.arr;
        return copy;*/

        //deep cloning
        CloneableImpl copy = new CloneableImpl();
        copy.a = this.a;
        copy.arr = this.arr.clone(); //#clone() (in arrays has already overridden) !!!!!!
        return copy;

//        for cases when #clone() is restricted
//        throw new CloneNotSupportedException();
    }
}
