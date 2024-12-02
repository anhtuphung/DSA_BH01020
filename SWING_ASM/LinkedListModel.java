package SWING_ASM;

public class LinkedListModel {
    private Node head;
    public LinkedListModel() {
        this.head = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public Node getHead() {
        return head;
    }

    public void addStudent(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void deleteStudentById(int id) {
        if (head == null) return;
        if (head.student.id == id) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.student.id != id) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void editStudentById(int id, String newName, double newMarks) {
        Node temp = head;
        while (temp != null) {
            if (temp.student.id == id) {
                temp.student.name = newName;
                temp.student.marks = newMarks;
                return;
            }
            temp = temp.next;
        }
    }

//    public String[] getRanks() {
//        Node temp = head;
//        int size = getSize();
//        String[] ranks = new String[size];
//        int index = 0;
//
//        while (temp != null) {
//            ranks[index] = temp.student.getRank();
//            temp = temp.next;
//            index++;
//        }
//        return ranks;
//    }

    public Student getStudentByIndex(int index) {
        int currentIndex = 0;
        Node temp = head;

        while (temp != null) {
            if (currentIndex == index) {
                return temp.student;
            }
            temp = temp.next;
            currentIndex++;
        }
        return null;
    }

    public int getSize() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }


}
