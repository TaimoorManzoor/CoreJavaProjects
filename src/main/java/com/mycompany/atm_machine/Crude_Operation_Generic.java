/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_machine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.*;

public class Crude_Operation_Generic
{
    String Firstname;
    String Lastname;
    String Roll_no;
    String CNIC;
    String dob;
    String gpa;
    HashMap<String,String> a=new HashMap();
    Map<String,HashMap> map =new HashMap();
    Scanner inputs=new Scanner(System.in);
    
    public void insert()
    {
        System.out.print("Let's Register in Our Portal\n");
        
        System.out.print("Enter your First Name: ");
        Firstname=inputs.next();
        a.put("First_Name",Firstname);
        
        System.out.print("Enter your Last Name: ");
        Lastname=inputs.next();
        a.put("Last_Name",Lastname);
        
        System.out.print("Enter your CNIC: ");
        CNIC=inputs.next();
        a.put("CNIC",CNIC);
        
        System.out.print("Enter your Date of Birth: ");
        String date = inputs.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate student_dob = LocalDate.parse(date, formatter);
        dob=student_dob.format(formatter); 
        a.put("Date_of_Birth",dob);
        
        System.out.print("Enter your GPA: ");
        gpa = inputs.next();
        a.put("GPA",gpa);
        
        System.out.println("Enter your Roll Number: ");
        Roll_no=inputs.next();
        map.put(Roll_no,  new HashMap<>(a));
    }

     public void Fetch() {
        if(map.isEmpty())
        {
            System.out.println("No record found");
        }
        else
        {
            System.out.println("Roll Number | First Name | Last Name | CNIC        | Date of Birth | GPA");

        Set<Map.Entry<String, HashMap>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, HashMap>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, HashMap> entry = iterator.next();
            String rollNumber = entry.getKey();
            HashMap<String, String> studentData = entry.getValue();

            System.out.printf("%-12s| %-11s| %-10s| %-12s| %-14s| %s%n",
                    rollNumber,
                    studentData.get("First_Name"),
                    studentData.get("Last_Name"),
                    studentData.get("CNIC"),
                    studentData.get("Date_of_Birth"),
                    studentData.get("GPA"));
        }
        }
        
         
    }
    
    public void RemoveAllData()
    {
        System.out.println("All record are deleted sucessfully");
       map.clear();
    }
    public void RemoveSpecificData()
    {
        System.out.println("Which Student would you like to remove");
        String temp=inputs.next();
        map.remove(temp);

    }
    
      public void MenuBar() {
        int n = 1;
        while (n != 0) {
            System.out.println("-------Welcome to Our Portal-------");
            System.out.println("Enter  1 : Register");
            System.out.println("Enter  2 : Student Record");
            System.out.println("Enter  3 : Remove All Record");
            System.out.println("Enter  4 : Remove Specific Record");
            System.out.println("Enter  0 : Exit");

            
            n = inputs.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Welcome to Register");
                    insert();
                    break;
                case 2:
                    System.out.println("Welcome to Student Record");
                    Fetch();
                    break;

                case 3:
                    System.out.println("Welcome to Remove All Record");
                    RemoveAllData();
                    break;

                case 4:
                    System.out.println("Welcome to Remove Specific Record");
                    RemoveSpecificData();
                    break;

                case 0:
                    System.out.println("System Exit");
                    break;
                default:
                    System.out.println("Incorrect Option");
                    break;
            }

        }
    }
}
