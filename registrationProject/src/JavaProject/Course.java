package JavaProject;

import java.util.ArrayList;
import java.util.List;

class Course {
    private double gpa;

    //
    public Course(double gpa) {
        this.gpa = gpa;
    }

    public void chooseCourse() {

        System.out.println("Courses registered for this semester:");
        if (gpa >= 3.4) {
            System.out.println("You can choose Software Engineering.");
            System.out.println("Available courses:");
            displayAvailableCourses();
        } else {
            System.out.println("You cannot choose Software Engineering.");
            System.out.println("Please choose another course.");
        }
    }

    private void displayAvailableCourses() {
        int semester = getSemester(); // Assuming the semester is obtained from somewhere else
        List<String> courses = getAvailableCourses(semester);
        if (!courses.isEmpty()) {
            for (String course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No available semester.");
        }
    }

    private List<String> getAvailableCourses(int semester) {
        List<String> courses = new ArrayList<>();
        switch (semester) {
            case 1:
                courses.add("Applied Mathematics");
                courses.add("C++");
                courses.add("Anthropology");
                courses.add("Civic");
                courses.add("Entrepreneurship");
                courses.add("English");
                courses.add("Emerging Technology");
                break;
            case 2:
                courses.add("Python");
                courses.add("Discrete Mathematics");
                courses.add("Database");
                courses.add("Inclusive");
                courses.add("Economics");
                courses.add("Fundamentals of Software");
                break;
            case 3:
                courses.add("OOP");
                courses.add("Data Structure");
                courses.add("Operating System");
                courses.add("Fundamentals of Networking");
                courses.add("COA");
                courses.add("Statistics");
                break;
        }
        return courses;
    }

    private int getSemester() {
        // Implement the logic to get the current semester
        // This can be obtained from a database or any other source
        return 1; // Placeholder value, replace with actual implementation
    }
}