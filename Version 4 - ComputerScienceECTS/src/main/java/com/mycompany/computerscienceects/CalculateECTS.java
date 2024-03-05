package com.mycompany.computerscienceects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class CalculateECTS {

    private ArrayList<String> failedSubject = new ArrayList<>();
    private int failedCount = 0;
    private int totalECTS = 0;

    public int getFailedCount() {
        return failedCount;
    }

    public ArrayList<String> getFailedSubject() {
        return failedSubject;
    }

    int calculation(String studentFilePath) {

        try {
            BufferedReader studentInto = new BufferedReader(new FileReader(studentFilePath));
            studentInto.readLine(); //To skip student name
            studentInto.readLine(); //To skip student id

            String subject = studentInto.readLine();
            String degree = studentInto.readLine();

            while (subject != null) {
                if(Integer.parseInt(degree) >= 50){
                    totalECTS += getECTS(subject);
                }else{
                    failedSubject.add(subject);
                    failedCount++;
                }
                subject = studentInto.readLine();
                degree = studentInto.readLine();
            }
            studentInto.close();

        } catch (Exception e) {
            System.out.println("Error was found");
        }
        return totalECTS;
    }

    int getECTS(String subjectName) {
        int subjectECTS = 0;
        for (int i = 1; i <= 8; i++) {
            String subjectsFilePath = "Data\\Semesters\\Semester" + i + ".txt";
            try {
                BufferedReader semesterInfo = new BufferedReader(new FileReader(subjectsFilePath));
                String subject = semesterInfo.readLine();
                String ECTS = semesterInfo.readLine();
                while(subject != null){
                    if(subjectName.trim().equals(subject.trim())){
                        subjectECTS = Integer.parseInt(ECTS);
                        return subjectECTS;
                    }
                    subject = semesterInfo.readLine();
                    ECTS = semesterInfo.readLine();
                }
                semesterInfo.close();
            } catch (Exception e) {
                System.out.println("Error was found");
            }
        }
        return 0;
    }
}