import dao.StudentDAO;
import models.GoodStudent;
import models.NormalStudent;
import models.Student;
import util.FileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import service.RecruitmentService;

// workflow: CSV GoodStudent, CSV NormalStudent -> đọc dữ liệu -> tạo các object Student
// -> đưa tất cả vào List<Student> -> Hiển thị thông tin -> Phân biệt GoodStudent/NormalStudent -> Insert vào SQL
public class main {

    public static void main(String[] args) {

        List<Student> students =
                new ArrayList<>(); // tạo danh sách tên students để chứa các Student
        
       
        try {

            // =================================
            // 1. Đọc dữ liệu từ GoodStudent.csv
            // =================================

            FileHelper.readGoodStudent(
                    "E:\\Java\\JavaCoreFinalPractice1\\src\\main\\java\\data\\goodStudent.csv",
                    students
            );

            // =================================
            // 2. Đọc dữ liệu từ NormalStudent.csv
            // =================================

            FileHelper.readNormalStudent(
                    "E:\\Java\\JavaCoreFinalPractice1\\src\\main\\java\\data\\normalStudent.csv",
                    students
            );

            // =================================
            // 3. Hiển thị thông tin
            // =================================

            for (Student student: students){
                
                student.showMyInfor();
            }
            
            // =================================
            // 4. Lưu dữ liệu vào Database
            // =================================

            StudentDAO dao =
                    new StudentDAO();

            for (Student student : students) { 

                if (student instanceof GoodStudent) { // Object này có phải là một GoodStudent hay không ?

                    dao.insertGoodStudent(
                            (GoodStudent) student // ép kiểu Student thành GoodStudent => insert vào database
                    );

                } else if (
                        student instanceof NormalStudent) { 

                    dao.insertNormalStudent(
                            (NormalStudent) student
                    );
                }
            }

            System.out.println(
                    "Insert data successfully!"
            );
            
             // Nhập số lượng cần tuyển
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students to recruit (11-15)");
        
        int numberOfStudents = scanner.nextInt();
        
        // Tuyển dụng
        RecruitmentService recruitmentService = new RecruitmentService(); // sử dụng các chức năng tuyển dụng trong class
        
        List<Student> selectedStudents = recruitmentService.selectCandidates(students, numberOfStudents); 
        
        // Hiển thị ứng viên trúng tuyển
        System.out.println("\n============== SELECTED CANDIDATES===============");
        
        for (Student student : selectedStudents) {
            student.showMyInfor();
        }
        
        // sắp xếp students theo fullName và phoneNumber
        System.out.println(
        "\n===== ALL STUDENTS SORTED ====="
);

        recruitmentService.displayStudentsSorted(students);

        } catch (Exception e) {

            System.out.println(
                    "Input files have unknown errors !!!"
            );

            e.printStackTrace();
        }
        
       
        
    }
}