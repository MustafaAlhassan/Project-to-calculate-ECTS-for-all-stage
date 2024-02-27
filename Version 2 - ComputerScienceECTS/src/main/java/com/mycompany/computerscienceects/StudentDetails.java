package com.mycompany.computerscienceects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class StudentDetails {

    private ArrayList<Integer> degrees = new ArrayList<>(); //store degrees
    private String path;
    private String name; //Name of student
    private int id; //id of student

    public ArrayList<Integer> getDegrees() {
        return degrees;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    StudentDetails(String path) {
        this.path = path;
    }

    //to store degrees
    public void setDegrees() {
        try {
            BufferedReader details = new BufferedReader(new FileReader(path));
            details.readLine(); //to skip line
            name = details.readLine(); //to get name
            details.readLine(); //to skip line
            id = Integer.parseInt(details.readLine()); //to get id
            String getInfo = details.readLine();
            while (getInfo != null) {
                getInfo = details.readLine();
                degrees.add(Integer.valueOf(getInfo));
                getInfo = details.readLine();
            }
            details.close();
        } catch (Exception e) {
            System.out.println("Error was found");
        }
    }
}
