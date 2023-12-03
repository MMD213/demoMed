package com.example.demo.Base;

import javafx.beans.property.SimpleStringProperty;

public class Specialty {
    int IdSpecialty;
    SimpleStringProperty SpecialtyName;

    public Specialty(int idSpecialty, String specialtyName) {
        this.IdSpecialty = idSpecialty;
        this.SpecialtyName =new SimpleStringProperty(specialtyName);
    }

    public int getCol1() {
        return IdSpecialty;
    }

    public String getCol2() {
        return SpecialtyName.get();
    }

}
