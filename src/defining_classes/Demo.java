package defining_classes;

public class Demo {

    public static void main(String[] args) {

        Student student = new Student("Kaloyan", "kaloyan.kostadinov@mail.bg");
        Student student2 = new Student(25, "Peter", "peter.kostadinov@mail.bg", 5.00);
        Student student3 = new Student();

        System.out.println(student.getEmail());

    }
}
















