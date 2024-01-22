package com.mycompany.computerscienceects;

import java.util.ArrayList;

class Semester {

    private ArrayList<String> subjects = new ArrayList<>(); //store subjects
    private ArrayList<Integer> ECTS = new ArrayList<>(); //store ECTS

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Integer> getECTS() {
        return ECTS;
    }

    public void setECTS(ArrayList<Integer> ECTS) {
        this.ECTS = ECTS;
    }

    void setSubjects(String subject) {
        subjects.add(subject);
    }

    void setECTS(int ects) {
        ECTS.add(ects);
    }

}
