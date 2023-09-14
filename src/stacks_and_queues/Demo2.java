package stacks_and_queues;

public class Demo2 {

    public static void main(String[] args) {
        A(0);
    }

    private static void A(int count) {
        System.out.println("Invoke Method A!");
        count++;
        if (count == 5){
            return;
        }
        A(count);
    }
}
