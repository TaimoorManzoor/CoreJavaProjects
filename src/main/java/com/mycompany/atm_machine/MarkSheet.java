package com.mycompany.atm_machine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Taimoor Manzoor
 */
public class MarkSheet {

    String[] coursename = new String[6];
    float[] StudentMark = new float[6];
    char [] SubjectGrade = new char[6];
    float[] StudentPercentage = new float[6];
    String studentname;
    String student_rollno;
    String student_email;
    LocalDate student_dob;
    char grade;
    float percentage;
    int total_mark = 600;
    Scanner inputs = new Scanner(System.in);

    public void courseName() {

        System.out.println("Courses Name");

        for (int i = 0; i < coursename.length; i++) {
            System.out.print("Course Number " + (i + 1) + ": ");
            coursename[i] = inputs.next();
        }
        System.out.println("");
    }

    public void StudentMarks() {

        System.out.println("Courses Marks");

        for (int i = 0; i < coursename.length; i++) {
            float temp;
            System.out.print("Enter the Marks of " + coursename[i] + " : ");
            temp = inputs.nextFloat();
            if (temp >= 0 && temp <= 100) {
                StudentMark[i] = temp;
            } else {
                System.out.println("Please Upload correct marks of " + coursename[i]);
                i--;
            }

        }
        System.out.println("");

    }

    public void StudentDetail() {

        System.out.println("Student Detail");

        System.out.print("Student Name: ");
        studentname = inputs.next();

        for (int i = 0; i < 10; i++) {
            String temp_email;
            System.out.print("Student Email: ");
            temp_email = inputs.next();
            if (temp_email.contains("@")) {
                student_email = temp_email;
                break;
            } else {
                System.out.println("Please Enter correct email");
            }
        }

        System.out.print("Student Roll No: ");
        student_rollno = inputs.next();

        System.out.print("Student Data of Birth(dd/MM/yyyy): ");
        String date = inputs.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        student_dob = LocalDate.parse(date, formatter);

    }

    public void resultGenerate() {
        float student_total_marks = 0;

        for (int i = 0; i < StudentMark.length; i++) {
            student_total_marks += StudentMark[i];
        }

        percentage = (student_total_marks * 100) / total_mark;
        
        for (int i = 0; i < StudentMark.length; i++) 
        {
             StudentPercentage[i] = (StudentMark[i] * 100) / 100;
        }

        for (int i = 0; i < StudentMark.length; i++) 
        {
            if (StudentPercentage[i] >= 80) {
                SubjectGrade[i] = 'A';
            } else if (StudentPercentage[i] < 80 && StudentPercentage[i] >= 70) {
                SubjectGrade[i] = 'B';

            } else if (StudentPercentage[i] < 70 && StudentPercentage[i] >= 60) {
                SubjectGrade[i] = 'C';

            } else if (StudentPercentage[i] < 60 && StudentPercentage[i] >= 50) {
                SubjectGrade[i] = 'D';
            } else if (StudentPercentage[i] < 50) {
                SubjectGrade[i] = 'F';
            }
        }

        if (percentage >= 80) {
            grade = 'A';
        } else if (percentage < 80 && percentage >= 70) {
            grade = 'B';

        } else if (percentage < 70 && percentage >= 60) {
            grade = 'C';

        } else if (percentage < 60 && percentage >= 50) {
            grade = 'D';
        } else if (percentage < 50) {
            grade = 'F';
        }
    }

    public void markSheetGenerate() {
        System.out.println("------------------------------------------Mark Sheet---------------------------------------");
        System.out.println("Name          : " + studentname);
        System.out.println("Email         : " + student_email);
        System.out.println("Roll No       : " + student_rollno);
        System.out.println("Date of Birth : " + student_dob);
        System.out.println("\n\n");
        System.out.println("Courses    Mark    Grade");
        for (int i = 0; i < StudentMark.length; i++) {
            System.out.println("" +coursename[i] + "    "+StudentMark[i]+"   "+SubjectGrade[i]);
        }
        System.out.println("\n\n");
        System.out.println("Percentage : " + percentage+"%");
        System.out.println("Overall Grade : " + grade);
    }

    public void runprocess() {
        courseName();
        StudentMarks();
        StudentDetail();
        resultGenerate();
        markSheetGenerate();

    }

}
