package iterators_and_comparators.comparing_objects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person person) {
        // first you should compare their names,
        if (this.name.equals(person.name)) {
            // after that - their age
            if (this.age == person.age) {
                // and last but not least - compare their town.
                if (this.town.equals(person.town)) {
                    return 0;
                }
            }

        }

        return 1;
    }
}
