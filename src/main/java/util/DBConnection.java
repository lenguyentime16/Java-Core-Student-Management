/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection; // đại diện cho một kết nối giữa java và database
import java.sql.DriverManager; // tạo kết nối đến database
import java.sql.SQLException; // exception liên quan đến database

/**
 *
 * @author OS
 */
public class DBConnection { 
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/recruitment"; // jdbc + sử dụng mySQL + máy chủ localhost + port mySQL + tên database
    
    private static final String USER = "root"; // username đăng nhập MySQL
    
    private static final String PASSWORD = "123456"; // password đăng nhập MySQL
    
    public static Connection getConnection() throws SQLException { //kiểu dữ liệu trả về là object Connection + xử lý lỗi liên quan đến database
        
        return DriverManager.getConnection(URL, USER, PASSWORD); // sau khi kết nối thành công => trả về connection => trả connection đó về nơi gọi hàm
        
    }
}
