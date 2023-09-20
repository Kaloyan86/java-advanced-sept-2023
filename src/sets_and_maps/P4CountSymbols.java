package sets_and_maps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P4CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> dictionary = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (!dictionary.containsKey(currentChar)) {
                dictionary.put(currentChar, 1);
            } else {
                int currentValue = dictionary.get(currentChar);
                dictionary.put(currentChar, currentValue + 1);
            }
        }

        dictionary.forEach((key, value) -> System.out.printf("%c: %d time/s\n",
                                                             key,
                                                             value));
    }
}
