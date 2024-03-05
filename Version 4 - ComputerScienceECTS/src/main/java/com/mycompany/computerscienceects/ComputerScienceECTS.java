package com.mycompany.computerscienceects;

import javax.swing.JOptionPane;

public class ComputerScienceECTS {

    public static void main(String[] args) {
        
        Options options = new Options();
        
        while (true) {
            int option = options.menu();
            switch (option) {
                case 0 -> options.inputStudentData(); //input Student Data (Name, ID and Degrees)                    
                case 1 -> options.CalculateECTS(); //Used to calculate ECTS for student                             
                default -> {
                    JOptionPane.showMessageDialog(null, "Thank you!");
                    return;
                }
            }
        }
    }
}