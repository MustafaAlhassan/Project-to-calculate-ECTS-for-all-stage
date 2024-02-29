package com.mycompany.computerscienceects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class Stage {

    private ArrayList<Semester> semester = new ArrayList<>(8); //to store all semesters in which contains the subjects and their degrees 
    private String path;

    public ArrayList<Semester> getSemester() {
        return semester;
    }

    Stage(String path) {
        this.path = path;
    }

    //to set subjects and ECTS of subjects
    public void setSemester() {
        try {
            for (int i = 0; i < 8; i++) {
                Semester sem = new Semester(); //create new object to store subjects and ECTS
                String p = path + "Semester" + (i + 1) + ".txt";
                BufferedReader subjects = new BufferedReader(new FileReader(p));
                String getSubject = subjects.readLine(); //get subject name
                while (getSubject != null) {
                    sem.setSubjects(getSubject);
                    getSubject = subjects.readLine(); // get ECTS value
                    sem.setECTS(Integer.parseInt(getSubject));
                    getSubject = subjects.readLine(); //get subject name
                }
                semester.add(sem); //store object of class semester
                subjects.close();
            }
        } catch (Exception e) {
            System.out.println("Error was found");
        }
    }
}
