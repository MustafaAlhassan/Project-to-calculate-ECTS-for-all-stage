package com.mycompany.computerscienceects;

import java.util.ArrayList;

class CalculateECTS {

    private int failedCount = 0;
    private ArrayList<String> failedSubject = new ArrayList();

    public int getFailedCount() {
        return failedCount;
    }

    //to calculate the ECTS of entire stages
    public int calculation(StudentDetails studentD, Stage stage) {
        ArrayList<Integer> degree = studentD.getDegrees(); //to get degree from StudentDetails class
        ArrayList<Semester> semesters = stage.getSemester(); //to get all semesters object from stage class

        int count = 0;
        int numSemester = semesters.size(); //Number of semesters for all stages
        int totalECTS = 0;

        //pass through semesters
        for (int i = 0; i < numSemester; i++) {
            Semester semester = semesters.get(i); //get semesters sequentailly
            ArrayList<String> subjects = semester.getSubjects(); //get subjects of #semester
            ArrayList<Integer> ECTS = semester.getECTS(); //get subject's ECTS of #semester
            int numSubjects = subjects.size();
            for (int j = 0; j < numSubjects; j++) {
                if (degree.get(count) >= 50) { //if student passed the subject, will compute the subject's ECTS 
                    totalECTS += ECTS.get(j);
                } else {
                    failedSubject.add(subjects.get(j));
                    failedCount++;
                }
                count++;
            }
        }
        return totalECTS;
    }

    public String getFailedSubjects() {
        return failedSubject.toString();
    }
}
