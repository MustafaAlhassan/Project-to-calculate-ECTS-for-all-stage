package com.mycompany.computerscienceects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class EnterStudentInfo {
    private String name;
    private String id;

    public EnterStudentInfo(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    public void inputStudentInfoAndDegree(){
        try {
            String fileName = "Data\\Students\\" + name + ".txt";
            File studentInfo = new File(fileName);
            if(studentInfo.exists()){
                JOptionPane.showMessageDialog(null, "This name (" + name + ") exists in the system ", "Note", JOptionPane.INFORMATION_MESSAGE);
            }else{
                studentInfo.createNewFile(); // Create new file inside --> Data\Students\
                BufferedWriter enter = new BufferedWriter(new FileWriter(fileName));
                enter.write("Student name: " + name);
                enter.newLine();
                enter.write("Student ID: " + id);
                enter.newLine();

                BufferedReader info = new BufferedReader(new FileReader("Data\\info.txt"));
                String subject = info.readLine(); //get subject name
                while (subject != null) { // used to put subject name and degree 
                    enter.write(subject); 
                    enter.newLine();
                    String degree = JOptionPane.showInputDialog(null, "Please, Enter degree of " + subject + ":", "Degree", JOptionPane.INFORMATION_MESSAGE).toLowerCase();
                    //this while loop use to the check degree if it number and between 0 - 100, if input wrong we get anthor one inside loop and check it.
                    while(degree.isEmpty() || !Character.isDigit(degree.charAt(0)) || Integer.parseInt(degree) > 100 || Integer.parseInt(degree) < 0){
                        JOptionPane.showMessageDialog(null, "Wrong input! write again" + name, "Error", JOptionPane.ERROR_MESSAGE);
                        degree = JOptionPane.showInputDialog(null, "Please, Enter degree of " + subject + ":", "Degree", JOptionPane.INFORMATION_MESSAGE).toLowerCase();
                    }
                    enter.write(degree); 
                    enter.newLine();
                    subject = info.readLine();
                }
                info.close(); //close BufferedReader
                enter.close(); //close BufferedWriter
            }
        } catch (Exception e) {
            System.out.println("Error was found");
        }
    }
}