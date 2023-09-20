package sets_and_maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P5Phonebook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, String> phonebook = new HashMap<>();

        while (!"search".equals(line)) {
            String[] tokens = line.split("-");
            phonebook.put(tokens[0], tokens[1]);
            line = scanner.nextLine();
        }

        line = scanner.nextLine();

        while (!"stop".equals(line)) {
            String name = line;

            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s\n", name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.\n", name);
            }

            line = scanner.nextLine();
        }
    }
}
