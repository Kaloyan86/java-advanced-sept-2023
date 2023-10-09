package generics;

public class Sorter {

    private Sorter() {
    }

    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        // 2 1 3 5 4

        for (int i = 0; i < customList.getSize(); i++) {
            T currentElement = customList.get(i);
            for (int j = i + 1; j < customList.getSize(); j++) {
                if (currentElement.compareTo(customList.get(j)) > 0) {
                    customList.swap(i, j);
                }
            }
        }
    }


}
