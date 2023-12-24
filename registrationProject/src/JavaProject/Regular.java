package JavaProject;

class Regular extends Student {
    private int year;

    public Regular(String name, int id, String department, int year, String gender, int age, double gpa, int uid) {
        super(name, id, department, age, gender, gpa, uid);
        this.year = year;
    }

    @Override
    public void displayInfo() {
        System.out.println("Regular Student");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Department: " + department);
        System.out.println("Year: " + year);
    }
}