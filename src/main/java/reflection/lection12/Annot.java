package reflection.lection12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE) //ElementType.CLASS handy when use your own classloaders
@interface MyAnnotation {
    String value();
}

@MyAnnotation("lalalala")
class AnnotA {
    @MyAnnotation("METHOOD")
    public void f() {
        Class c = this.getClass();
        Method method = null;

        try {
            method = c.getDeclaredMethod("f");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        MyAnnotation m = method.getAnnotation(MyAnnotation.class);
        System.out.println(m.value());
    }
}

public class Annot {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class c = Class.forName("reflection.lection12.AnnotA");
        MyAnnotation annotation = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.value());

        new AnnotA().f();
    }
}
