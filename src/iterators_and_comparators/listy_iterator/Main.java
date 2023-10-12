package iterators_and_comparators.listy_iterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        ListyIterator<String> listyIterator = new ListyIterator<>();

        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    String[] el = Arrays.stream(tokens).skip(1).toArray(String[]::new);
                    String[] elements = new String[tokens.length - 1];
                    //System.arraycopy(tokens, 1, elements, 0, tokens.length - 1);
                    listyIterator = new ListyIterator<>(el);
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }

            line = scanner.nextLine();
        }


    }
}
