package com.example.demo.Base;

import javafx.beans.property.SimpleStringProperty;

public class Status {
    int StatusID;
    SimpleStringProperty Name;

    public Status(int statusID, String name) {
        this.StatusID = statusID;
        this.Name =new SimpleStringProperty(name);
    }

    public int getCol1() {
        return StatusID;
    }

    public String getCol2() {
        return Name.get();
    }
}
