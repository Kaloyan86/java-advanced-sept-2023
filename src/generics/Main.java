package generics;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box<Student> studentBox = new Box<Student>(new Student(1));

        //        List<Box<String>> boxList = new ArrayList<>();
        //        int n = Integer.parseInt(scanner.nextLine());
        //
        //        for (int i = 0; i < n; i++) {
        //            Box<String> box = new Box<>(scanner.nextLine());
        //            boxList.add(box);
        //        }
        //        Box<String> stringBox = new Box<>(scanner.nextLine());
        //
        //        System.out.println(countGreaterElements(boxList, stringBox));

        CustomList<String> customList = new CustomList<>();

        String line = scanner.nextLine();
        while (!"END".equals(line)) {

            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {

                case "Add":
                    customList.add(tokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(tokens[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    for (String element : customList) {
                        System.out.println(element);
                    }
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }


            line = scanner.nextLine();
        }

    }

    static <T extends Comparable<T>> int countGreaterElements(List<T> data, T element) {
        int count = 0;

        for (T e : data) {
            int res = e.compareTo(element);
            if (res > 0) {
                count++;
            }
        }

        return count;
    }

    static <T> void swap(List<T> data, int firstIndex, int secondIndex) {

        T firstElement = data.get(firstIndex);
        T secondElement = data.get(secondIndex);

        data.set(firstIndex, secondElement);
        data.set(secondIndex, firstElement);
    }
}
