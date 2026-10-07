/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//class chuyên chịu trách nhiệm giao tiếp với Database để lưu / lấy dữ liệu Student
// workflow: Viết SQL -> Mở connection -> Tạo PreparedStatement -> set dữ liệu vào ? -> executeUpdate()
package dao;
import models.GoodStudent;
import models.Student;
import util.DBConnection;
import models.NormalStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author OS
 */
public class StudentDAO {
    public void insertGoodStudent(GoodStudent student) {
        // khai báo câu lệnh SQL insert dưới dạng chuỗi string, biến sql dùng để lưu câu lệnh sql
        String sql = """
                     INSERT INTO student (
                     full_name,
                     dob,
                     sex,
                     phone_number,
                     university_name,
                     grade_level,
                     student_type,
                     gpa,
                     best_reward_name
                     )
                     VALUES (?,?,?,?,?,?,?,?,?) 
                     """; // ? : parameter placeholders - vị trí chờ dữ liệu
       
        //Connection 
        try (
            Connection conn = DBConnection.getConnection(); // kết nối java với MySQL
            PreparedStatement ps = conn.prepareStatement(sql); // tạo một PreparedStatement từ câu SQL đã viết
                ) {
            
            //set dữ liệu tương ứng
            ps.setString(1, student.getFullName());
            ps.setString(2, student.getDoB());
            ps.setString(3, student.getSex());
            ps.setString(4, student.getPhoneNumber());
            ps.setString(5, student.getUniversityName());
            ps.setString(6, student.getGradeLevel());
            ps.setString(7, "GOOD");
            ps.setDouble(8, student.getGpa());
            ps.setString(9, student.getBestRewardName());
            
        //executedUpdate
        ps.executeUpdate();
            
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }   
        public void insertNormalStudent (NormalStudent student){
           String sql = """
                        INSERT INTO student (
                        full_name,
                        dob,
                        sex,
                        phone_number,
                        university_name,
                        grade_level,
                        student_type,
                        english_score,
                        entry_test_score
                        ) VALUES (?,?,?,?,?,?,?,?,?)"""; 
            
            try (
                    Connection conn = DBConnection.getConnection();
                    PreparedStatement ps = conn.prepareStatement(sql);
                    )
            {
                
            ps.setString(1, student.getFullName());
            ps.setString(2, student.getDoB());
            ps.setString(3, student.getSex());
            ps.setString(4, student.getPhoneNumber());
            ps.setString(5, student.getUniversityName());
            ps.setString(6, student.getGradeLevel());
            ps.setString(7, "NORMAL");
            ps.setDouble(8, student.getEnglishScore());
            ps.setDouble(9, student.getEntryTestScore());
                
            ps.executeUpdate();
            } catch (SQLException e) {
             e.printStackTrace();
                
            }}
        
    }


// My SQL -> PreparedStatement -> Java -> Connection -> MySQL