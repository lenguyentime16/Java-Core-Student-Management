/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author OS
 */
public class GoodStudent extends Student {

    public static void add(GoodStudent goodStudent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private double gpa;
    private String bestRewardName;

    public GoodStudent(){}
    
    public GoodStudent(String fullName, 
                       String doB, 
                       String sex, 
                       String phoneNumber, 
                       String universityName, 
                       String gradeLevel,
                       double gpa,
                       String bestRewardName){
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
        
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }
    
    @Override
    public void showMyInfor() {
         System.out.println(
            getFullName() + " | " +
            getDoB() + " | " +
            getSex() + " | " +
            getPhoneNumber() + " | " +
            getUniversityName() + " | " +
            getGradeLevel() + " | " +
            gpa + " | " +
            bestRewardName
         );
    }
}
