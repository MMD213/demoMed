package com.example.demo.Base;

import javafx.beans.property.SimpleStringProperty;

public class Diagnosis {
    int IDDiagnosis;
    SimpleStringProperty Patient,DateOfApplication,Disease, Treatment, Doctor,Complaints,Improvement,Status;

    public Diagnosis(int IDdiagnosis1, String patient1, String dateOfApplication1, String disease1, String treatment1, String  doctor1, String complaints1, String improvement1, String status1) {
        this.IDDiagnosis = IDdiagnosis1;
       this.Patient =new SimpleStringProperty(patient1);
       this.DateOfApplication =new SimpleStringProperty(dateOfApplication1);
       this.Disease = new SimpleStringProperty(disease1);
       this.Treatment = new SimpleStringProperty(treatment1);
       this.Doctor = new SimpleStringProperty(doctor1);
       this.Complaints = new SimpleStringProperty(complaints1);
       this.Improvement = new SimpleStringProperty(improvement1);
       this.Status = new SimpleStringProperty(status1);
    }
    public int getCol1() {
        return IDDiagnosis;
    }
    public String getCol2() {
        return Patient.get();
    }
    public String getCol3() {
        return DateOfApplication.get();
    }
    public String getCol4() {
        return Disease.get();
    }
    public String getCol5() {
        return Treatment.get();
    }
    public String getCol6() {
        return Doctor.get();
    }
    public String getCol7() {
        return Complaints.get();
    }
    public String getCol8() {
        return Improvement.get();
    }
    public String getCol9() {
        return Status.get();
    }

}
