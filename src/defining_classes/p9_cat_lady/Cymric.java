package defining_classes.p9_cat_lady;

public class Cymric extends Cat {

    private double furLength;

    public Cymric(String name, String type, double furLength) {
        super(name, type);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f",
                             super.toString(),
                             this.furLength);
    }
}
