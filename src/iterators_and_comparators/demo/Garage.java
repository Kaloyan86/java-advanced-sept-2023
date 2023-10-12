package iterators_and_comparators.demo;

import java.util.Iterator;

public class Garage implements Iterable<Car> {

    private Car[] cars;

    public Garage(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public Iterator<Car> iterator() {
        return new CustomCarIterator();
    }

    private class CustomCarIterator implements Iterator<Car> {

        int index = cars.length - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Car next() {
            return cars[index--];
        }
    }
}
