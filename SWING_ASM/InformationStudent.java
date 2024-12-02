//package SWING_ASM;
//
//import javax.swing.*;
//import javax.swing.border.Border;
//import javax.swing.border.TitledBorder;
//import java.awt.*;
//import java.util.List;
//
//
//public class InformationStudent extends JFrame {
//    public InformationStudent(String title) throws HeadlessException{
//        super(title);
//        initUI();
//    }
//    private void initUI(){
//        this.setSize(600,350);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//        JPanel pnBorder = new JPanel(new BorderLayout());
//
//        //begin north
//        JPanel pnNorth = new JPanel();
//        Font fTitle = new Font("Tahoma", Font.BOLD,18);
//        JLabel lblTitle = new JLabel("Information Student");
//        lblTitle.setFont(fTitle);
//        lblTitle.setForeground(Color.red);
//        pnNorth.add(lblTitle);
//        pnBorder.add(pnNorth, BorderLayout.NORTH);
//        //end
//
//        //begin south
//        JPanel pnSouth = new JPanel();
//        JButton btnAdd = new JButton("Add");
//        pnSouth.add(btnAdd);
//
//        JButton btnRemove = new JButton("Remove");
//        pnSouth.add(btnRemove);
//
//        JButton btnUpdate = new JButton("Update");
//        pnSouth.add(btnUpdate);
//
//        JButton btnClear = new JButton("Clear");
//        pnSouth.add(btnClear);
//
//        pnBorder.add(pnSouth, BorderLayout.SOUTH);
//        //end south
//
//        //begin west
//        JPanel pnWest = new JPanel();
//        Border boderWest = BorderFactory.createLineBorder(Color.red);
//        TitledBorder titledBorder = new TitledBorder(boderWest, "List Student");
//        pnWest.setBorder(titledBorder);
//        DefaultListModel model = new DefaultListModel();
//
//        model.addElement("Nguyen A");
//        model.addElement("Nguyen B");
//        model.addElement("Nguyen C");
//        JList lstSinhVien = new JList();
//        lstSinhVien.setModel(model);
//        lstSinhVien.setPreferredSize(new Dimension(150,200));
//
//        pnWest.add(lstSinhVien);
//        pnBorder.add(pnWest, BorderLayout.WEST);
//        //end west
//
//        // Begin Center
//        JPanel pnCenter = new JPanel();
//        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS)); // Vertical layout for clarity
//
//// ID Panel
//        JPanel pnMaSV = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        JLabel lblMaSV = new JLabel("ID: ");
//        JTextField txtMaSV = new JTextField(20);
//        pnMaSV.add(lblMaSV);
//        pnMaSV.add(txtMaSV);
//
//// Name Panel
//        JPanel pnHoTen = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        JLabel lblHoTen = new JLabel("Name: ");
//        JTextField txtHoTen = new JTextField(20);
//        pnHoTen.add(lblHoTen);
//        pnHoTen.add(txtHoTen);
//
//// Mark Panel
//        JPanel pnDiem = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        JLabel lblDiem = new JLabel("Mark: ");
//        JTextField txtDiem = new JTextField(20);
//        pnDiem.add(lblDiem);
//        pnDiem.add(txtDiem);
//
//// Add sub-panels to center panel
//        pnCenter.add(pnMaSV);
//        pnCenter.add(pnHoTen);
//        pnCenter.add(pnDiem);
//
//// Add center panel to the main panel with BorderLayout
//        pnBorder.add(pnCenter, BorderLayout.CENTER);
//// End Center
//
//
//
//        this.add(pnBorder);
//    }
//
//    public static void main(String[] args) {
//        new InformationStudent("Information Student").setVisible(true);
//    }
//
//}
package SWING_ASM;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class InformationStudent extends JFrame {
    private JTextField txtMaSV, txtHoTen, txtDiem, txtSearch;
    private JLabel lblRank;
    private JList<String> lstSinhVien,lstSearchResults;
    private DefaultListModel<String> listModel, searchListModel;
    private LinkedListModel linkedListModel;

    public InformationStudent(String title) {
        super(title);
        linkedListModel = new LinkedListModel();
        listModel = new DefaultListModel<>();
        initUI();
        addSampleData();
    }
    private void addSampleData() {
        Student student1 = new Student(1, "Alice Johnson", 8.5);
        Student student2 = new Student(2, "Bob Smith", 6.7);
        Student student3 = new Student(3, "Charlie Brown", 9.1);

        // Thêm dữ liệu vào linked list
        linkedListModel.addStudent(student1);
        linkedListModel.addStudent(student2);
        linkedListModel.addStudent(student3);

        // Thêm tên vào listModel để hiển thị
        listModel.addElement(student1.name);
        listModel.addElement(student2.name);
        listModel.addElement(student3.name);
        updateListDisplay();
    }

    private void initUI() {
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel pnBorder = new JPanel(new BorderLayout());

        // Begin North
        JPanel pnNorth = new JPanel();
        Font fTitle = new Font("Tahoma", Font.BOLD, 18);
        JLabel lblTitle = new JLabel("Information Student");
        lblTitle.setFont(fTitle);
        lblTitle.setForeground(Color.RED);
        pnNorth.add(lblTitle);
        pnBorder.add(pnNorth, BorderLayout.NORTH);

        // Begin West
        JPanel pnWest = new JPanel();
        Border boderWest = BorderFactory.createLineBorder(Color.RED);
        TitledBorder titledBorder = new TitledBorder(boderWest, "List Student");
        pnWest.setBorder(titledBorder);
        listModel = new DefaultListModel<>();
        lstSinhVien = new JList<>(listModel);
        lstSinhVien.setPreferredSize(new Dimension(150, 200));
        lstSinhVien.addListSelectionListener(e -> displayStudentDetails(lstSinhVien.getSelectedIndex()));
        pnWest.add(lstSinhVien);
        pnBorder.add(pnWest, BorderLayout.WEST);

        // Begin Center
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

        JPanel pnMaSV = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblMaSV = new JLabel("ID: ");
        txtMaSV = new JTextField(20);
        pnMaSV.add(lblMaSV);
        pnMaSV.add(txtMaSV);

        JPanel pnHoTen = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblHoTen = new JLabel("Name: ");
        txtHoTen = new JTextField(20);
        pnHoTen.add(lblHoTen);
        pnHoTen.add(txtHoTen);

        JPanel pnDiem = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblDiem = new JLabel("Mark: ");
        txtDiem = new JTextField(20);
        pnDiem.add(lblDiem);
        pnDiem.add(txtDiem);

        JPanel pnRank = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblRank = new JLabel("Rank: ");
        pnRank.add(lblRank);

        JPanel pnSearch = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblSearch = new JLabel("Search by Name: ");
        txtSearch = new JTextField(20);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(e -> searchStudentByName(txtSearch.getText()));
        pnSearch.add(lblSearch);
        pnSearch.add(txtSearch);
        pnSearch.add(btnSearch);



        pnCenter.add(pnSearch);
        pnCenter.add(pnMaSV);
        pnCenter.add(pnHoTen);
        pnCenter.add(pnDiem);
        pnCenter.add(pnRank);


        searchListModel = new DefaultListModel<>();
        lstSearchResults = new JList<>(searchListModel);
        lstSearchResults.setPreferredSize(new Dimension(150, 100));
        lstSearchResults.addListSelectionListener(e -> displayStudentDetailsFromSearch(lstSearchResults.getSelectedIndex()));
        JPanel pnSearchResults = new JPanel();
        pnSearchResults.setBorder(BorderFactory.createTitledBorder("Search Results"));
        pnSearchResults.add(lstSearchResults);
        pnCenter.add(pnSearchResults);

        pnBorder.add(pnCenter, BorderLayout.CENTER);

        // Begin South
        JPanel pnSouth = new JPanel();
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> addStudent());
        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(e -> removeStudent());
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(e -> updateStudent());
        JButton btnSortByMarks = new JButton("Sort by Marks");
        btnSortByMarks.addActionListener(e -> sortByMarks());

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(e -> System.exit(0));
        pnSouth.add(btnExit);


        pnSouth.add(btnAdd);
        pnSouth.add(btnRemove);
        pnSouth.add(btnUpdate);
        pnSouth.add(btnSortByMarks);

        pnBorder.add(pnSouth, BorderLayout.SOUTH);

        this.add(pnBorder);
    }

    private void addStudent() {
        try {
            int id = Integer.parseInt(txtMaSV.getText());
            String name = txtHoTen.getText();
            double marks = Double.parseDouble(txtDiem.getText());
            if (!name.matches("[a-zA-Z\\s]+")) {
                throw new IllegalArgumentException("Invalid name.");
            }
            Student student = new Student(id, name, marks);
            linkedListModel.addStudent(student);
            listModel.addElement(student.name);
            JOptionPane.showMessageDialog(this, "Student added successfully.");
            txtMaSV.setText("");
            txtHoTen.setText("");
            txtDiem.setText("");
            lblRank.setText("Rank: ");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please check ID and Marks.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void removeStudent() {
        try {
            int selectedIndex = lstSinhVien.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
                linkedListModel.deleteStudentById(selectedIndex + 1);
                JOptionPane.showMessageDialog(this, "Deleted successful.");
            } else {
                throw new IllegalStateException("No student selected.");
            }

            // Reset fields
            txtMaSV.setText("");
            txtHoTen.setText("");
            txtDiem.setText("");
            lblRank.setText("Rank: ");
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void updateStudent() {
        try {
            int selectedIndex = lstSinhVien.getSelectedIndex();
            if (selectedIndex != -1) {
                int id = Integer.parseInt(txtMaSV.getText());
                String name = txtHoTen.getText();
                double marks = Double.parseDouble(txtDiem.getText());
                if (!name.matches("[a-zA-Z\\s]+")) {
                    throw new IllegalArgumentException("Invalid name.");
                }
                linkedListModel.editStudentById(id, name, marks);
                listModel.set(selectedIndex, new Student(id, name, marks).name);
                JOptionPane.showMessageDialog(this, "Student updated successfully.");
                txtMaSV.setText("");
                txtHoTen.setText("");
                txtDiem.setText("");
                lblRank.setText("Rank: ");
            } else { throw new IllegalStateException("No student selected.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please check ID and Marks.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void sortByMarks() {
        try {
            if (linkedListModel.getSize() <= 1) {
                throw new IllegalStateException("Not enough students to sort.");
            }
            boolean swapped;
            do {
                swapped = false;
                Node current = linkedListModel.getHead();
                while (current != null && current.next != null) {
                    if (current.student.marks < current.next.student.marks) {
                        Student temp = current.student;
                        current.student = current.next.student;
                        current.next.student = temp;
                        swapped = true;
                    }
                    current = current.next;
                }
            } while (swapped);
            updateListDisplay();
            JOptionPane.showMessageDialog(this, "Sorted by Marks (Descending).");
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void searchStudentByName(String name) {
        try {
            String searchText = txtSearch.getText().trim();
            if (searchText.isEmpty()) {
                throw new IllegalArgumentException("Please enter a keyword to search.");
            }
            searchListModel.clear();
            Node temp = linkedListModel.getHead();
            boolean found = false;
            while (temp != null) {
                if (temp.student.name.toLowerCase().contains(name.toLowerCase())) {
                    searchListModel.addElement(temp.student.name);
                    found = true;
                }
                temp = temp.next;
            }
            if (!found) {
                throw new IllegalStateException("No student found with the name: " + name);
            }
        } catch (IllegalArgumentException | IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            txtMaSV.setText("");
            txtHoTen.setText("");
            txtDiem.setText("");
            lblRank.setText("Rank: ");
        }
    }

//    private void addStudent() {
//        try {
//            int id = Integer.parseInt(txtMaSV.getText());
//            String name = txtHoTen.getText();
//            double marks = Double.parseDouble(txtDiem.getText());
//
//            if (!name.matches("[a-zA-Z\\s]+")) {
//                JOptionPane.showMessageDialog(this, "Invalid name.");
//                return;
//            }
//            Student student = new Student(id, name, marks);
//            linkedListModel.addStudent(student);
//            listModel.addElement(student.name);
//            JOptionPane.showMessageDialog(this, "Student added successfully.");
//
//            txtMaSV.setText("");
//            txtHoTen.setText("");
//            txtDiem.setText("");
//            lblRank.setText("Rank: ");
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(this, "Invalid input. Please check ID and Marks.");
//        }
//    }
//
//    private void removeStudent() {
//        int selectedIndex = lstSinhVien.getSelectedIndex();
//        if (selectedIndex != -1) {
//            listModel.remove(selectedIndex);
//            linkedListModel.deleteStudentById(selectedIndex + 1);
//            JOptionPane.showMessageDialog(this, "Selected successful.");
//        } else {
//            JOptionPane.showMessageDialog(this, "No student selected.");
//        }
//        txtMaSV.setText("");
//        txtHoTen.setText("");
//        txtDiem.setText("");
//        lblRank.setText("Rank: ");
//    }
//
//    private void updateStudent() {
//        int selectedIndex = lstSinhVien.getSelectedIndex();
//        if (selectedIndex != -1) {
//            try {
//                int id = Integer.parseInt(txtMaSV.getText());
//                String name = txtHoTen.getText();
//                double marks = Double.parseDouble(txtDiem.getText());
//                if (!name.matches("[a-zA-Z\\s]+")) {
//                    JOptionPane.showMessageDialog(this, "Invalid name.");
//                    return;
//                }
//                linkedListModel.editStudentById(id, name, marks);
//                listModel.set(selectedIndex, new Student(id, name, marks).name);
//                JOptionPane.showMessageDialog(this, "Student updated successfully.");
//                txtMaSV.setText("");
//                txtHoTen.setText("");
//                txtDiem.setText("");
//                lblRank.setText("Rank: ");
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(this, "Invalid input. Please check ID and Marks.");
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "No student selected.");
//        }
//    }
//
    private void displayStudentDetails(int selectedIndex) {
        if (selectedIndex != -1) {
            Student student = linkedListModel.getStudentByIndex(selectedIndex);
            if (student != null) {
                txtMaSV.setText(String.valueOf(student.id));
                txtHoTen.setText(student.name);
                txtDiem.setText(String.valueOf(student.marks));
                lblRank.setText("Rank: " + student.getRank());
            }
        }
    }
//
//    private void sortByMarks() {
//        if (linkedListModel.getSize() <= 1) {
//            JOptionPane.showMessageDialog(this, "Not enough students to sort.");
//            return;
//        }
//        boolean swapped;
//        do {
//            swapped = false;
//            Node current = linkedListModel.getHead();
//            while (current != null && current.next != null) {
//                if (current.student.marks < current.next.student.marks) {
//                    Student temp = current.student;
//                    current.student = current.next.student;
//                    current.next.student = temp;
//                    swapped = true;
//                }
//                current = current.next;
//            }
//        } while (swapped);
//        updateListDisplay();
//        JOptionPane.showMessageDialog(this, "Sorted by Marks (Descending).");
//    }

    private void updateListDisplay() {
        listModel.clear();
        Node temp = linkedListModel.getHead();
        while (temp != null) {
            listModel.addElement(temp.student.name);
            temp = temp.next;
        }
    }

//    private void searchStudentByName(String name) {
//        String searchText = txtSearch.getText().trim();
//        if (searchText.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please enter a keyword to search.");
//            return;
//        }
//        searchListModel.clear();
//        Node temp = linkedListModel.getHead();
//        boolean found = false;
//        while (temp != null) {
//            if (temp.student.name.toLowerCase().contains(name.toLowerCase())) {
//                searchListModel.addElement(temp.student.name);
//                found = true;
//            }
//            temp = temp.next;
//        }
//        if (!found) {
//            JOptionPane.showMessageDialog(this, "No student found with the name: " + name);
//            txtMaSV.setText("");
//            txtHoTen.setText("");
//            txtDiem.setText("");
//            lblRank.setText("Rank: ");
//        }
//    }

    private void displayStudentDetailsFromSearch(int selectedIndex) {
        if (selectedIndex != -1) {
            Node temp = linkedListModel.getHead();
            int currentIndex = 0;
            while (temp != null) {
                if (currentIndex == selectedIndex) {
                    Student student = temp.student;
                    txtMaSV.setText(String.valueOf(student.id));
                    txtHoTen.setText(student.name);
                    txtDiem.setText(String.valueOf(student.marks));
                    lblRank.setText("Rank: " + student.getRank());
                    break;
                }
                temp = temp.next;
                currentIndex++;
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InformationStudent("Information Student").setVisible(true));
    }
}