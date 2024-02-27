package com.mycompany.computerscienceects;

import java.io.File;
import javax.swing.JOptionPane;

public class ComputerScienceECTS {

    public static void main(String[] args) {
        while (true) {
            String options[] = {"Input Student Data","Calculate ECTS", "Exit"};
            int option = JOptionPane.showOptionDialog(null, "Please Choose The Option You Need", "Insertion",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            
            if(option == 0){ //input Student Data (Name, ID and Degrees)
                String name = JOptionPane.showInputDialog(null, "Please, Enter student name: ", "INFOMATION", JOptionPane.INFORMATION_MESSAGE).toLowerCase();
                String id = JOptionPane.showInputDialog(null, "Please, Enter student name id: ", "INFOMATION", JOptionPane.INFORMATION_MESSAGE).toLowerCase();
                EnterStudentInfo inputInfo = new EnterStudentInfo(name,id);
                inputInfo.inputStudentInfoAndDegree();
            } else if (option == 1) { //Used to calculate ECTS for student
                String path = "Data\\Semesters\\"; //you do not need write path because the txt file is in same file of project
                Stage stage = new Stage(path); 
                stage.setSemester();
                String name;
                String pathStudent = "";
                boolean flag = true;
                while (flag) { //Uesd to check student file if it is exists or not
                    pathStudent = "Data\\Students\\";
                    name = JOptionPane.showInputDialog(null, "Please, Enter Student name: ", "Insertion", JOptionPane.INFORMATION_MESSAGE).toLowerCase();
                    while (true) {
                        pathStudent = pathStudent + name + ".txt";
                        File f = new File(pathStudent);
                        if (f.exists()) {
                            flag = false;
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "There is no student with this name: " + name, "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                }
                StudentDetails details = new StudentDetails(pathStudent);
                details.setDegrees();
                CalculateECTS allECTS = new CalculateECTS();
                int ECTS = allECTS.calculation(details, stage);
                if (ECTS == 240) {
                    JOptionPane.showMessageDialog(null, "The student details:\nName: "
                            + details.getName() + "\nID: " + details.getId() + "\nTotal ECTS: " + ECTS
                            + "\ncanguration you graduwait", "calculation", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "The student details:\nName: "
                            + details.getName() + "\nID: " + details.getId() + "\nTotal ECTS: " + ECTS
                            + "\nYou still have " + allECTS.getFailedCount() + " subject that you didnt pass it" + "\nThe subject which failed in:\n" + allECTS.getFailedSubjects(), "calculation", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Thank you!");
                break;
            }
        }

    }
}
