package JavaProject;

public abstract class Student {
    protected String name;
    protected int id;
    protected String department;
    protected int age;
    protected String gender;
    protected double gpa;
    protected int uid;

    public Student(String name, int id, String department, int age, String gender, double gpa, int uid) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.age = age;
        this.gender = gender;
        this.gpa = gpa;
        this.uid = uid;
    }

    public abstract void displayInfo();
}