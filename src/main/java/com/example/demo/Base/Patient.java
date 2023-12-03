package com.example.demo.Base;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Patient {
    int IdPatient;
    SimpleStringProperty InsurancePolicyNumber, MedicalBookNumber, FIO, PlaceOfResidence, DateOfBirth;

    public Patient(int IdPatient1, String InsurancePolicyNumber1, String MedicalBookNumber1, String FIO1, String PlaceOfResidence1, String DateOfBirth1) {
        this.IdPatient = IdPatient1;
        this.InsurancePolicyNumber = new SimpleStringProperty(InsurancePolicyNumber1);
        this.MedicalBookNumber = new SimpleStringProperty(MedicalBookNumber1);
        this.FIO = new SimpleStringProperty(FIO1);
        this.PlaceOfResidence = new SimpleStringProperty(PlaceOfResidence1);
        this.DateOfBirth = new SimpleStringProperty(DateOfBirth1);
    }

    public int getCol1() {
        return IdPatient;
    }
    public String getCol2() {
        return InsurancePolicyNumber.get();
    }
    public String getCol3() {
        return MedicalBookNumber.get();
    }
    public String getCol4() {
        return FIO.get();
    }
    public String getCol5() {
        return PlaceOfResidence.get();
    }
    public String getCol6() {
        return DateOfBirth.get();
    }

}
