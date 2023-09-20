package sets_and_maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P6FixEmails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        Map<String, String> emails = new LinkedHashMap<>();

        while (!"stop".equals(name)) {
            String email = scanner.nextLine();
            // "us", "uk," or "com"
            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                emails.put(name, email);
            }

            name = scanner.nextLine();
        }

        emails.forEach((key, value) -> System.out.printf("%s -> %s\n", key, value));
    }
}
