package defining_classes;

public class Student {

    private Long id;
    private String name;
    private String email;
    private Double avgScore;

    public Student() {
        this(0, "Your name", "Your email", 0.0);
    }

    public Student(String name, String email) {
        this(0, name, email, 0.0);
    }

    public Student(long id, String name, String email, double avgScore) {

        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setAvgScore(avgScore);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        if (email.isEmpty() || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty or blank!");
        }
        this.email = email;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }
}
