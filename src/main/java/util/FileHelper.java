/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import exception.InvalidFullNameException;
import exception.InvalidDOBException;
import exception.InvalidPhoneNumberException;
import java.io.BufferedReader; // thư viện giúp đọc dữ liệu thuận tiện, đọc từng dòng
import java.io.FileReader; // thư viện đọc dữ liệu
import java.io.IOException; // thư viện liên quan đến đọc / ghi file
import java.util.List;
import models.GoodStudent;
import models.NormalStudent;
import models.Student;

/**
 *
 * @author OS
 */
public class FileHelper {
    
    public static void readGoodStudent(String fileName, List<Student> students) 
            throws IOException, InvalidFullNameException, InvalidDOBException, InvalidPhoneNumberException {
        try (BufferedReader br = 
                new BufferedReader(
                        new FileReader(fileName))){ // mở file sau đó đọc file
        
        String line; // lưu dòng hiện tại đang đọc
        while ((line = br.readLine()) != null) { // mỗi lần gọi br.readLine() java sẽ đọc một dòng -> lưu vào line, nếu dòng đó khác null -> tiếp tục đọc
            String[] data = line.split(",");
            
            Validator.validateFullName(data[0]);
            Validator.validateDOB(data[1]);
            Validator.validatePhoneNumber(data[3]);
            
            GoodStudent student = new GoodStudent(
                    data[0],
                    data[1],
                    data[2],
                    data[3],
                    data[4],
                    data[5],
                    Double.parseDouble(data[6]),
                    data[7]
            );
            
            students.add(student);
        }
        }
       
    }
    
    public static void readNormalStudent(String fileName, List<Student> students) 
            throws IOException, InvalidFullNameException, InvalidDOBException, InvalidPhoneNumberException {
          try (BufferedReader br = 
                  new BufferedReader(
                          new FileReader(fileName))) {
          
          String line;
          
          while((line = br.readLine()) != null) {
              String[] data = line.split(",");
              
              Validator.validateFullName(data[0]);
              Validator.validateDOB(data[1]);
              Validator.validatePhoneNumber(data[3]);
              
              NormalStudent student = new NormalStudent(
                      data[0],
                      data[1],
                      data[2],
                      data[3],
                      data[4],
                      data[5],
                      Double.parseDouble(data[6]),
                      Double.parseDouble(data[7])
              );
              
              students.add(student);
          }
          }
          
    }
}
