/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author OS
 */
public class NormalStudent extends Student {
    private double englishScore;
    private double entryTestScore;
    
    public NormalStudent(){}
    
    public NormalStudent(String fullName, 
                       String doB, 
                       String sex, 
                       String phoneNumber, 
                       String universityName, 
                       String gradeLevel,
                       double englishScore,
                       double entryTestScore){
     super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);   
      this.englishScore = englishScore;
      this.entryTestScore = entryTestScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
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
            englishScore + " | " +
            entryTestScore
         );
    }
      
}
