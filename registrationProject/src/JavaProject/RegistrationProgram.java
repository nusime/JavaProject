package JavaProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistrationProgram {

    public static class InvalidUIDException extends Exception {
        public InvalidUIDException(String message) {
            super(message);
        }
    }

    public static class InvalidIDException extends Exception {
        public InvalidIDException(String message) {
            super(message);
        }
    }

    public static class InvalidDepartmentException extends Throwable {
        public InvalidDepartmentException(String s) {
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to Haramaya University Software Registration Program :)");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        FileHandler.readStudentInfo();



        while (true) {
            System.out.println("Choose 1 to register");
            System.out.println("Choose 2 to display all student information");
            System.out.println("Choose 3 to exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter your name");
                    String name = scanner.next();

                    int id = getValidID(scanner);
                    System.out.println("Choose 1 if you are a regular student and 2 if you are a distance student");
                    int type = scanner.nextInt();

                    if (type == 1) {
                        System.out.println("Is it ur first semester, second or third since u join software engineering");
                        int year = scanner.nextInt();
                        String department = getValidDepartment(scanner).toUpperCase();
                        System.out.println("Enter your gender(M/F)");
                        String gender = scanner.next();
                        System.out.println("Enter your age");
                        int age = scanner.nextInt();
                        System.out.println("Enter your GPA");
                        double gpa = scanner.nextDouble();
                        int uid = getValidUID(scanner);

                        Regular regular = new Regular(name, id, department, year, gender, age, gpa, uid);
                        regular.displayInfo();

                        Course course = new Course(gpa);
                        course.chooseCourse();
                        saveStudentInfo();

                    } else if (type == 2) {
                        System.out.println("Is it ur first semester, second or third since u join software engineering");
                        int year = scanner.nextInt();
                        String department = getValidDepartment(scanner).toUpperCase();
                        System.out.println("Enter your telephone");
                        int telephone = scanner.nextInt();
                        System.out.println("Enter your email address");
                        String emailAddress = scanner.next();
                        System.out.println("Enter your gender(M/F)");
                        String gender = scanner.next();
                        System.out.println("Enter your age");
                        int age = scanner.nextInt();
                        System.out.println("Enter your GPA");
                        double gpa = scanner.nextDouble();
                        int uid = getValidUID(scanner);
                        System.out.print("Enter the semester you are going to start now: ");
                        int semester = scanner.nextInt();


                        Distance distance = new Distance(name, id, department, year, telephone, emailAddress, age, gender, gpa, uid);
                        distance.displayInfo();

                        Course course = new Course(gpa);
                        course.chooseCourse();

                        saveStudentInfo(distance);

                    } else {
                        System.out.println("Invalid Student Type");
                    }
                    break;
                case 2:
                    FileHandler.readStudentInfo();
                    saveStudentInfo();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;




            }

        }

    }

    private static void saveStudentInfo(Student student) {
    }

    private static void saveStudentInfo() {
    }


    private static int getValidID(Scanner scanner) {
        // Helper method to validate ID

        int id;
        while (true) {
            try {
                System.out.print("Enter student ID (4 digits): ");
                id = scanner.nextInt();
                if (id < 1000 || id > 9999) {
                    throw new InvalidIDException("Invalid ID. ID must be a 4-digit number.");
                }
                break;
            } catch (InvalidIDException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid 4-digit number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        return id;
    }

    private static int getValidUID(Scanner scanner) {
        // Helper method to validate UID
        int uid;
        while (true) {
            try {
                System.out.print("Enter student UID (6 digits): ");
                uid = scanner.nextInt();
                if (uid < 100000 || uid > 999999) {
                    throw new InvalidUIDException("Invalid UID. UID must be a 6-digit number.");
                }
                break;
            } catch (InvalidUIDException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid 6-digit number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        return uid;
    }

    private static String getValidDepartment(Scanner scanner) {
        String department;
        while (true) {
            try {
                System.out.print("Enter your department (SWE or Software Engineering): ");
                department = scanner.next();
                if (!department.equalsIgnoreCase("SWE") && !department.equalsIgnoreCase("SOFTWARE ENGINEERING")) {
                    throw new InvalidDepartmentException("Invalid department. Department must be SWE or Software Engineering.");
                }
                break;
            } catch (InvalidDepartmentException e) {
                System.out.println(e.getMessage());
            }
        }
        return department;
    }
}
