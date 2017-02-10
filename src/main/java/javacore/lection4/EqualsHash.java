package main.java.module1.lection4;

import java.util.Objects;

public class EqualsHash {
    //Integer pool {-128;127}

/*    Object:

    equals
    hashcode

    getClass
    finalize
    notify
    notifyAll
    wait
    wait(timeout)
    toString
    clone
*/

    // equals & hashcode are overrides together
    // equals == true => hashcode == true
    // equals == false => hashcode ?= true
}

class A {
    int value;

    public int getValue() {
        return value;
    }

    public A setValue(int value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        //Should be #getClass()
        if (!(obj instanceof A)) {
            return false;
        }

        return this.value == ((A)obj).value;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(getValue());
//    }

    @Override
    public int hashCode() {
        //return 0
        return value;
    }
}
