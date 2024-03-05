package com.mycompany.computerscienceects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import javax.swing.JOptionPane;

class Options {

    int menu() {
        String options[] = {"Input Student Data", "Calculate ECTS", "Exit"};
        int option = JOptionPane.showOptionDialog(null, "Please Choose The Option You Need", "Insertion",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        return option;
    }

    void inputStudentData() {
        String name = JOptionPane.showInputDialog(null, "Please, Enter student name: ", "INFOMATION", JOptionPane.INFORMATION_MESSAGE).toLowerCase();
        String id = JOptionPane.showInputDialog(null, "Please, Enter student name id: ", "INFOMATION", JOptionPane.INFORMATION_MESSAGE).toLowerCase();
        EnterStudentInfo inputInfo = new EnterStudentInfo(name, id);
        inputInfo.inputStudentInfoAndDegree();
    }

    void CalculateECTS() {
        String name = JOptionPane.showInputDialog(null, "Please, Enter Student name: ", "Insertion", JOptionPane.INFORMATION_MESSAGE).toLowerCase();
        String studentFilePath = "Data\\Students\\" + name + ".txt";
        if (!isExists(studentFilePath)) {
            JOptionPane.showMessageDialog(null, "There is no student with this name: " + name, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        StudentMessage(studentFilePath);
    }

    boolean isExists(String studentFilePath) {
        File f = new File(studentFilePath);
        return f.exists();
    }
    
    void StudentMessage(String studentFilePath){
        CalculateECTS allECTS = new CalculateECTS();
        int totalECTS = allECTS.calculation(studentFilePath);
        try {
            BufferedReader StudentFile = new BufferedReader(new FileReader(studentFilePath));
            if (totalECTS == 240) {
                JOptionPane.showMessageDialog(null, StudentFile.readLine() + "\n" + StudentFile.readLine() + "\nTotal ECTS: " + totalECTS
                        + "\ncanguration you graduwait", "calculation", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, StudentFile.readLine() + "\n" + StudentFile.readLine() + "\nTotal ECTS: " + totalECTS
                        + "\nYou still have " + allECTS.getFailedCount() + " subject that you didn't pass it" + "\nThe subject which failed in:\n" + Arrays.toString(allECTS.getFailedSubject().toArray()), "calculation", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error was found");
        }
    }
}