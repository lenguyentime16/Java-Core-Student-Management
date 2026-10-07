/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import models.GoodStudent;
import models.NormalStudent;
import models.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author OS
 */
public class RecruitmentService {
    public List<Student> selectCandidates(
           List<Student> students,
           int numberOfStudents
       ) {
          if (numberOfStudents < 11 || numberOfStudents > 15){
              throw new IllegalArgumentException("Number of students must be from 11 to 15!");
          }
        List<GoodStudent> goodStudents = new ArrayList<>();
        List<NormalStudent> normalStudents = new ArrayList<>(); // tạo 2 mảng sắp xếp ứng viên để chọn goodStudent và normalStudent
        
        for (Student student : students) {
             if (student instanceof GoodStudent) {
                   goodStudents.add((GoodStudent) student);
             } 
             else if (student instanceof NormalStudent) {
                   normalStudents.add((NormalStudent) student);
             }
        }
        
        // sort GoodStudent
        
        Comparator<GoodStudent> goodComparator = Comparator
                                                    .comparingDouble(GoodStudent::getGpa)
                                                    .reversed()
                                                    .thenComparing(GoodStudent::getFullName); // xây dựng quy luật sắp xếp
        
        Collections.sort(goodStudents,goodComparator); // thực hiện việc sắp xếp theo luật đó
        
        // danh sách ứng viên được chọn
        List<Student> selectedStudents = new ArrayList<>();
        
        
        // ưu tiên good student
        
        if(goodStudents.size() >= numberOfStudents) {
            for (int i=0; i < numberOfStudents; i++) {
                selectedStudents.add(goodStudents.get(i));
            }
            return selectedStudents; 
        }
        
        // nếu số lượng chưa đủ => nhận hết GoodStudent
        
        selectedStudents.addAll(goodStudents);
        
        // tính số lượng còn thiếu
        
        int remaining = numberOfStudents - selectedStudents.size();
        
        
        // sort normal student, entryTestScore giảm dần, englishScore giảm dần, fullName tăng dần
        
        Comparator<NormalStudent> normalComparator = Comparator
                                                     .comparingDouble(NormalStudent::getEntryTestScore)
                                                     .reversed()
                                                     .thenComparingDouble(NormalStudent::getEnglishScore)
                                                     .reversed()
                                                     .thenComparing(NormalStudent::getFullName);
        
        Collections.sort(normalStudents, normalComparator);
        
        // lấy normal student còn thiếu
        int numbertoTake = Math.min(remaining, normalStudents.size());
        
        for (int i=0; i < numbertoTake; i++) {
            selectedStudents.add(normalStudents.get(i));
        }
        
        return selectedStudents;
    }
    public void displayStudentsSorted(List<Student> students) {
      List<Student> sortedStudents =   new ArrayList<>(students);
        
      Comparator<Student> comparator = Comparator
                                          .comparing(Student::getFullName)
                                          .reversed()
                                          .thenComparing(Student::getPhoneNumber);
      
      Collections.sort(sortedStudents, comparator);
        
      for (Student student : sortedStudents) {
          System.out.println(student.getFullName() + " - " + student.getPhoneNumber());
      }
    }
}
