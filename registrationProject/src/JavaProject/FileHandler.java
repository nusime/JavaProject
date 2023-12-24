package JavaProject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class FileHandler {
    private static final String FILE_PATH = "students.txt";

    public static void readStudentInfo() {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                String name = data[0];
                int id = Integer.parseInt(data[1]);
                String department = data[2];
                int age = Integer.parseInt(data[3]);
                String gender = data[4];
                double gpa = Double.parseDouble(data[5]);
                int uid = Integer.parseInt(data[6]);
                System.out.println("Name: " + name);
                System.out.println("ID: " + id);
                System.out.println("Department: " + department);
                System.out.println("Age: " + age);
                System.out.println("Gender: " + gender);
                System.out.println("GPA: " + gpa);
                System.out.println("UID: " + uid);
                System.out.println();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No student information is saved.");
        }
    }
}