package StackStudent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo stack với kích thước 20
        MyStack stack = new MyStack(20);

        // Thêm sẵn 5 sinh viên vào stack
        stack.push(new Student(1, "Nguyen Van A", 7.5));
        stack.push(new Student(2, "Le Thi B", 9.0));
        stack.push(new Student(3, "Tran Van C", 5.5));
        stack.push(new Student(4, "Pham Thi D", 6.8));
        stack.push(new Student(5, "Hoang Van E", 4.2));
        System.out.println("Initial student list:");
        stack.print();
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Print Student List");
            System.out.println("3. Edit Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Search Student by Name");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter the number of additional students to add: ");
                        int numStudents = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        for (int i = 0; i < numStudents; i++) {
                            try {
                                System.out.print("Enter Student ID: ");
                                int id = scanner.nextInt();
                                scanner.nextLine();  // Consume newline
                                System.out.print("Enter Student Name: ");
                                String name = scanner.nextLine();
                                System.out.print("Enter Student Marks: ");
                                double marks = scanner.nextDouble();
                                stack.push(new Student(id, name, marks));
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please enter valid data.");
                                scanner.nextLine();  // Clear buffer
                            }
                        }
                        break;

                    case 2:
                        System.out.println("Student List:");
                        stack.print();
                        break;

                    case 3:
                        System.out.print("Enter the ID of the student to edit: ");
                        int editId = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new marks: ");
                        double newMarks = scanner.nextDouble();
                        stack.editStudentById(editId, newName, newMarks);
                        break;

                    case 4:
                        System.out.print("Enter the ID of the student to delete: ");
                        int deleteId = scanner.nextInt();
                        stack.deleteStudentById(deleteId);
                        break;

                    case 5:
                        System.out.println("Sorting students by marks...");
                        stack.sortByMarks();
                        System.out.println("Students list after sorting:");
                        stack.print();
                        break;

                    case 6:
                        System.out.print("Enter name of student to search: ");
                        String searchName = scanner.nextLine();
                        stack.searchByName(searchName);
                        break;

                    case 0:
                        running = false;
                        System.out.println("Exiting the program.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid choice.");
                scanner.nextLine();  // Clear buffer
            }
        }

        scanner.close();
    }
}
