package defining_classes.p9_cat_lady;

public class Cat {

    private String name;
    private String type;

    public Cat(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.type, this.name);
    }
}
