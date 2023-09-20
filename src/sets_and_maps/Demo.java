package sets_and_maps;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        Sets keep unique elements
        HashSet<E> -> Does not guarantee the constant order of elements over time
        TreeSet<E> -> The elements are ordered incrementally
        LinkedHashSet<E> -> The order of appearance is preserved

        Maps hold a set of <key, value> pairs,
        Keys are unique
        HashMap<K, V> -> Does not guarantee the constant order of elements over time
        TreeMap<K, V> -> The elements are ordered incrementally by the key
        LinkedHashMap<K, V> -> The order of appearance is preserved

        Collisions in HashMap and HashSet
        Equals and HashCode contract
        */

        String a = "Siblings";
        String b = "Teheran";

        //        System.out.println(a.hashCode());
        //        System.out.println(b.hashCode());


        //        Set<Integer> set = new LinkedHashSet<>();
        //
        //        Arrays.stream(scanner.nextLine().split("\\s+"))
        //              .map(Integer::parseInt)
        //              .forEach(set::add);
        //
        //        Set<Integer> set = Arrays.stream(scanner.nextLine().split("\\s+"))
        //                                 .map(Integer::parseInt)
        //                                 .collect(Collectors.toSet());


        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Kaloyan");
        map.put(2, "Peter");
        map.put(3, "Ivan");

//        map.entrySet().stream()
//           .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
//
//        map.keySet().forEach(System.out::println);
//
//        map.values().forEach(System.out::println);

        City sofia = new City(1,"Sofia", 1500000);
        City plovdiv = new City(1,"Plovdiv", 500000);
        City varna = new City(3,"Varna", 400000);

        Map<City, Long> cityMap = new HashMap<>();

        cityMap.put(sofia, 11111L);
        cityMap.put(plovdiv, 22222L);
        cityMap.put(varna, 33333L);

        System.out.println(cityMap.get(sofia));
    }
}




















