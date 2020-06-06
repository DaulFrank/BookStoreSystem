import org.omg.CORBA.Object;

import java.util.Arrays;

public class Ttest01 {

    public static void main(String[] args) {

        MySet1 set = new MySet1();

        set.add("a");
        set.add("123");

        System.out.println(set.get());


    }
}


class MySet1<E>{
    private E value;
    public void add(E value) {
        this.value = value;
    }
    public E get() {
        return value;
    }
}
