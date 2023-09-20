package sets_and_maps;

import java.util.Objects;

public class City {

    private int id;
    private String name;
    private long population;

    public City(int id,String name, long population) {
        this.name = name;
        this.population = population;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Calling equals() for key: " + o);
        if (this == o) {
            System.out.println("This is the object " + o);
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city = (City) o;
        return population == city.population && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        System.out.println("Calling hashCode()");
        return Objects.hash(id);
    }
}
