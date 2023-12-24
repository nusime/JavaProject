package JavaProject;

class Distance extends Student {
    private int year;
    private int telephone;
    private String emailAddress;

    public Distance(String name, int id, String department, int year, int telephone, String emailAddress, int age, String gender, double gpa, int uid) {
        super(name, id, department, age, gender, gpa, uid);
        this.year = year;
        this.telephone = telephone;
        this.emailAddress = emailAddress;
    }

    public void displayInfo() {
        System.out.println("Distance Student");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Department: " + department);
        System.out.println("Telephone: " + telephone);
        System.out.println("Email Address: " + emailAddress);
        System.out.println("Year: " + year);
    }
}


