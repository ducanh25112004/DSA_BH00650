import java.util.*;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getRanking() {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Ranking: " + getRanking();
    }
}

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    // Adding a student
    public void addStudent(int id, String name, double marks) {
        if (marks < 0 || marks > 10) {
            System.out.println("Error: Marks must be between 0 and 10.");
            return;
        }
        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    // Editing a student
    public void editStudent(int id, String newName, double newMarks) {
        if (newMarks < 0 || newMarks > 10) {
            System.out.println("Error: Marks must be between 0 and 10.");
            return;
        }
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                students.add(new Student(id, newName, newMarks));
                System.out.println("Student edited successfully.");
                return;
            }
        }
        System.out.println("Error: Student with ID " + id + " not found.");
    }

    // Deleting a student
    public void deleteStudent(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);
        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    // Searching a student (using Linear Search)
    public Student searchStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    // Sorting students by Marks (Bubble Sort)
    public void sortByMarks() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    // Swap
                    Collections.swap(students, j, j + 1);
                }
            }
        }
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Main menu
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student marks: ");
                        double marks = scanner.nextDouble();
                        addStudent(id, name, marks);
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Invalid input. Please enter correct data types.");
                        scanner.nextLine(); // Clear invalid input
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter student ID to edit: ");
                        int editId = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new marks: ");
                        double newMarks = scanner.nextDouble();
                        editStudent(editId, newName, newMarks);
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Invalid input. Please enter correct data types.");
                        scanner.nextLine(); // Clear invalid input
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter student ID to delete: ");
                        int deleteId = scanner.nextInt();
                        deleteStudent(deleteId);
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Invalid input. Please enter a valid integer ID.");
                        scanner.nextLine(); // Clear invalid input
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Enter student ID to search: ");
                        int searchId = scanner.nextInt();
                        Student foundStudent = searchStudent(searchId);
                        if (foundStudent != null) {
                            System.out.println("Student found: " + foundStudent);
                        } else {
                            System.out.println("Error: Student not found.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Invalid input. Please enter a valid integer ID.");
                        scanner.nextLine(); // Clear invalid input
                    }
                    break;
                case 5:
                    sortByMarks();
                    System.out.println("Students sorted by marks.");
                    break;
                case 6:
                    displayStudents();
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Error: Invalid option. Please choose a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.menu();
    }
}
