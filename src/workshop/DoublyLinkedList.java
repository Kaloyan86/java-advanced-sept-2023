package workshop;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class DoublyLinkedList {

    class Node {

        int element;
        Node next;
        Node prev;

        public Node(int element) {
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    //void addFirst(int element) – adds an element at the beginning of the collection
    public void addFirst(int element) {
        Node newNode = new Node(element);

        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            // закачаме на новия Node next-a към старата глава
            newNode.next = this.head;
            // закачаме на старата глава prevNode към newNode
            this.head.prev = newNode;
            // поставяме новата глава
            this.head = newNode;
        }
        this.size++;
    }

    // void addLast(int element) – adds an element at the end of the collection
    public void addLast(int element) {
        Node newNode = new Node(element);

        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    // int get(int index) - Returns the element at the specified position in this list
    public int get(int index) {
        checkIndex(index);
        Node currentNode;
        if (index <= this.size / 2) {
            currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }

        return currentNode.element;
    }

    // int removeFirst() – removes the element at the beginning of the collection
    public int removeFirst() {
        checkEmpty();
        int element = this.head.element;
        this.head = this.head.next;

        if (this.head == null) {
            // single element
            this.tail = null;
        } else {
            // multiple elements
            this.head.prev = null;
        }

        this.size--;
        return element;
    }

    // int removeLast() – removes the element at the end of the collection
    public int removeLast() {
        checkEmpty();
        int element = this.tail.element;
        this.tail = this.tail.prev;

        if (this.tail == null) {
            // single element
            this.head = null;
        } else {
            // multiple elements
            this.tail.next = null;
        }

        this.size--;
        return element;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // void forEach() – goes through the collection and executes a given action
    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    // int[] toArray() – returns the collection as an array
    public int[] toArray() {
        int[] array = new int[this.size];
        AtomicInteger index = new AtomicInteger();
        forEach(e -> array[index.getAndIncrement()] = e);

//        Node currentNode = this.head;
//        while (currentNode != null) {
//            array[index.getAndIncrement()] = currentNode.element;
//            currentNode = currentNode.next;
//        }

        return array;
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(
            String.format("Index %d is out of bounds for size %d", index, this.size));
        }
    }
}
