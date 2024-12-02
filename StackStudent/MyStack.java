package StackStudent;

public class MyStack {
    Student[] students;
    int top, max;

    public MyStack(int max) {
        this.max = max;
        students = new Student[max];
        top = -1;
    }

    public boolean IsEmpty() {
        return top == -1;
    }

    public boolean IsFull() {
        return top == max - 1;
    }

    public void push(Student student) {
        if (IsFull()) {
            System.out.println("Stack is full");
        } else {
            students[++top] = student;
        }
    }

    public Student pop() {
        if (IsEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return students[top--];
        }
    }

    public Student top() {
        if (IsEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return students[top];
        }
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            students[i].printStudent();
        }
    }

    public void sortByMarks() {
        for (int i = 0; i < top - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < top; j++) {
                if (students[j].marks > students[minIndex].marks) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Student temp = students[i];
                students[i] = students[minIndex];
                students[minIndex] = temp;
            }
        }
    }


    // Phương thức sắp xếp sinh viên theo tên


    public void sortByName() {
        for (int i = 0; i < top; i++) {
            for (int j = i + 1; j <= top; j++) {
                if (students[i].name.compareToIgnoreCase(students[j].name) > 0) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }


//    public void searchByName(String name) {
//        boolean found = false;
//        for (int i = 0; i <= top; i++) {
//            if (students[i].name.toLowerCase().contains(name.toLowerCase())) {
//                students[i].printStudent();
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("Student not found.");
//        }
//    }

    public int searchByName(String name) {
        sortByName();
        int left = 0;
        int right = top - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compare = students[mid].name.toLowerCase().compareTo(name.toLowerCase());
            if (compare == 0) {
                students[mid].printStudent();
                return mid;
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Student not found.");
        return -1;  // Không tìm thấy sinh viên
    }




    public void deleteStudentById(int id) {
        boolean found = false;
        int index = -1;
        for (int i = 0; i <= top; i++) {
            if (students[i].id == id) {
                index = i;
                found = true;
                break;
            }
        }

        if (found) {
            // Shift elements to "delete" the student
            for (int i = index; i < top; i++) {
                students[i] = students[i + 1];
            }
            students[top] = null;  // Clear the last position
            top--;  // Reduce the stack size
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void editStudentById(int id, String newName, double newMarks) {
        boolean found = false;
        for (int i = 0; i <= top; i++) {
            if (students[i].id == id) {
                students[i].name = newName;
                students[i].marks = newMarks;
                System.out.println("Student information updated.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

}
