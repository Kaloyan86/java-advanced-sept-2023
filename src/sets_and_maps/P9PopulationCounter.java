package sets_and_maps;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P9PopulationCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Long>> counties = new LinkedHashMap<>();
        Map<String, Long> countriesTotalCount = new LinkedHashMap<>();

        while (!"report".equals(input)) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            counties.putIfAbsent(country, new LinkedHashMap<>());
            countriesTotalCount.putIfAbsent(country, 0L);

            counties.get(country).put(city, population);

            long populationToAdd = countriesTotalCount.get(country) + population;
            countriesTotalCount.put(country, populationToAdd);

            input = scanner.nextLine();
        }

        countriesTotalCount.entrySet()
                           .stream()
                           .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                           .forEach(entry -> {
                               System.out.printf("%s (total population: %d)\n", entry.getKey(), entry.getValue());

                               Map<String, Long> cities = counties.get(entry.getKey());

                               cities.entrySet()
                                     .stream()
                                     .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                                     .forEach(innerMapEntry -> System.out.printf("=>%s: %d\n",
                                                                                 innerMapEntry.getKey(),
                                                                                 innerMapEntry.getValue()));
                           });
    }
}
