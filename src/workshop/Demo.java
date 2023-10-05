package workshop;


import java.util.ArrayList;

public class Demo {

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();


        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        list.addLast(33);
        list.addLast(45);
        list.addLast(12);
        list.addLast(17);

        int[] ints = list.toArray();


        list.forEach(System.out::println);
    }
}
