package iterators_and_comparators.demo;

import java.util.Comparator;

public class CarComparator {

    static Comparator<Car> carComparator = ((car1, car2) -> {
        if (car1.getModel().equals(car2.getModel())) {
            if (car1.getHorsePower() == car2.getHorsePower()) {
                return 0;
            }
        }
        return Integer.compare(car1.getHorsePower(), car2.getHorsePower());
    });
}
