package generics;

public class Student implements Comparable<Student> {

    private Integer id;

    public Student(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }
}
