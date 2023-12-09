package com.example.demo.Base;

import javafx.beans.property.SimpleStringProperty;

public class Vrach1 {
    int IdVrach;
    SimpleStringProperty FIOVrach,SpecialnostVrach;
    float Staj;

    public Vrach1(int idVrach1, String FIOVrach1, String specialnostVrach1, Float staj1) {
        this.IdVrach = idVrach1;
        this.FIOVrach =new SimpleStringProperty(FIOVrach1);
        this.SpecialnostVrach = new SimpleStringProperty(specialnostVrach1);
        this.Staj = staj1;


    }

    public int getCol1() {
        return IdVrach;
    }
    public String getCol2() {
        return FIOVrach.get();
    }
    public String getCol3() {
        return SpecialnostVrach.get();
    }

    public float getCol4() {
        return Staj;
    }


}
