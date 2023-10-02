package defining_classes.p9_cat_lady;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        // Map<CatName, Cat>
        Map<String, Cat> cats = new HashMap<>();
        while (!"End".equals(line)) {
            String[] tokens = line.split("\\s+");
            String catType = tokens[0];
            String catName = tokens[1];
            double catParameter = Double.parseDouble(tokens[2]);
            Cat cat = null;
            switch (catType) {
                case "Siamese":
                    cat = new Siamese(catName, catType, catParameter);
                    break;
                case "Cymric":
                    cat = new Cymric(catName, catType, catParameter);
                    break;
                case "StreetExtraordinaire":
                    cat = new Extraordinaire(catName, catType, catParameter);
                    break;
            }
            cats.put(catName, cat);

            line = scanner.nextLine();
        }
        System.out.println(cats.get(scanner.nextLine()));
    }
}
