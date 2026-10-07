package util;
import exception.InvalidFullNameException;
import exception.InvalidPhoneNumberException;
import exception.InvalidDOBException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author OS
 */

public class Validator {
    public static void validateFullName(String fullName) // xử lý validate fullName
        throws InvalidFullNameException {
            if(fullName == null
                    || fullName.length() < 10 
                || fullName.length() > 50) {
            throw new InvalidFullNameException("Full name must be between 10 and 50 characters");
            }
    }
    
    public static void validatePhoneNumber (String phone) throws InvalidPhoneNumberException { // xử lý validate phone number
                String regex = "^(090|098|091|031|035|038)[0-9]{7}$"; // các số đầu 090,098,091,031,035,038 được chấp nhận và 7 số sau là các số từ 0-9
                if (phone == null || !phone.matches(regex)) { // xét điều kiện nếu phone number = null và không khớp với biểu thức chính quy
                    throw new InvalidPhoneNumberException("invalid phone number!"); // ném lỗi ra console
            }
            }
    public static void validateDOB (String doB) throws InvalidDOBException { // xử lý validate ngày tháng năm sinh
            
        try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        LocalDate.parse(doB, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDOBException("Invalid date of birth");
        }
    }
    
}
