import ra.Student;

import java.util.Scanner;

public class Main {
    private static Student[] listStudents = new Student[200];
    private static int size = 3;

    public static void main(String[] args) {
        listStudents[0] = new Student("001", "Hồ Xuân Hùng 1", 23, true, "0987654321", "Hà Nội", 9, 8, 7);
        listStudents[1] = new Student("002", "Hồ Xuân Hùng 2", 24, true, "0987654323", "Hà Nội", 10, 9, 8);
        listStudents[2] = new Student("003", "Hồ Xuân Hùng 3", 25, false, "0987654322", "Hà Nội", 9, 4, 6);
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n****************HACKATHON-JAVA-ADVANCE-1-MENU***************\n" +
                    "1. Nhập số sinh viên và nhập thông tin cho các sinh viên \n" +
                    "2. In thông tin các sinh viên đang quản lý \n" +
                    "3. Sắp xếp các sinh viên theo điểm trung bình tăng dần \n" +
                    "4. Nhập vào tên sinh viên và tìm kiếm sinh viên theo tên \n" +
                    "5. Thống kê số sinh viên nam, nữ đang quản lý \n" +
                    "6. In ra thông tin các sinh viên xếp loại giỏi và trung bình \n" +
                    "7. Thoát");
            System.out.println("Mời bạn nhập lựa chọn :");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    inputListStudent(input);
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    sortData();
                    break;
                case 4:
                    searchStudent(input);
                    break;
                case 5:
                    countQuantity();
                    break;
                case 6:
                    rank();
                    break;
                case 7:
                    System.out.println("thoát chương trình");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập không chính xác");
                    break;
            }

        }

    }

    private static void rank() {
        System.out.println("những học sinh xếp hạng giỏi là :");
        for (int i = 0; i < size; i++) {
            if (listStudents[i].getAvgMark() >= 8 && listStudents[i].getAvgMark() < 9) {
                listStudents[i].displayData();
            }
        }
        System.out.println("những học sinh xếp hạng TB là :");
        for (int i = 0; i < size; i++) {
            if (listStudents[i].getAvgMark() >= 5 && listStudents[i].getAvgMark() < 7) {
                listStudents[i].displayData();
            }
        }
    }

    private static void countQuantity() {
        int countNam = 0;
        for (int i = 0; i < size; i++) {
            if (listStudents[i].isSex() == true) {
                countNam++;
            }
        }
        System.out.println("số lượng sinh viên nam là : " + countNam);
        System.out.println("số lượng sinh viên nữ là : " + (size - countNam));
    }

    private static void searchStudent(Scanner sc) {
        int dem = 0;
        System.out.println("mời bạn nhập tên sv cần tìm");
        String searchName = sc.nextLine();
        for (int i = 0; i < size; i++) {
            if (listStudents[i].getStudentName().contains(searchName)) {
                listStudents[i].displayData();
                dem++;
            }
        }
        if (dem == 0) {
            System.err.println("Tên bạn nhập vào không khớp với học sinh nào cả");
        }
    }

    public static void inputListStudent(Scanner sc) {
        int n = 0;
        while (true) {
            System.out.println("Nhập số lượng sinh viên");
            n = Integer.parseInt(sc.nextLine());
            if (n > 0 && n < 200) {
                size = n;
                break;
            } else {
                System.err.println("lỗi ko đúng size");
            }
        }
        for (int i = 0; i < n; i++) {
            Student st = new Student();
            st.inputData(sc);
            st.calAvgMark();
            listStudents[i] = st;
        }

    }

    public static void displayData() {
        for (int i = 0; i < size; i++) {
            listStudents[i].displayData();
        }
    }

    public static void sortData() {

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (listStudents[i].getAvgMark() > listStudents[j].getAvgMark()) {
                    Student temp = listStudents[i];
                    listStudents[i] = listStudents[j];
                    listStudents[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp thành công");
    }
}