package com.example.jacob.ceg_4110_hw2.Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Clocks {

    String name;
    Calendar clock;
    SimpleDateFormat format;

    public Clocks(String name) {
        this.name = name;
        this.format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        this.name = name;
    }

    public void setName(String s){
        this.name = s;
    }

    public String getName() {
        return this.name;
    }

    public void addSec() {
        this.clock.set(Calendar.SECOND, this.clock.get(Calendar.SECOND)+1);
    }

    public void subtractSec() {
        this.clock.set(Calendar.SECOND, this.clock.get(Calendar.SECOND)-1);
    }

    public void addMin() {
        this.clock.set(Calendar.MINUTE, this.clock.get(Calendar.MINUTE)+1);
    }

    public void subtractMin() {
        this.clock.set(Calendar.MINUTE, this.clock.get(Calendar.MINUTE)-1);
    }

    public void addHour() {
        this.clock.set(Calendar.HOUR, this.clock.get(Calendar.HOUR)+1);
    }

    public void subtractHour() {
        this.clock.set(Calendar.HOUR, this.clock.get(Calendar.HOUR)-1);
    }

    public void addDay() {
        this.clock.set(Calendar.DAY_OF_MONTH, this.clock.get(Calendar.DAY_OF_MONTH)+1);
    }

    public void subtractDay() {
        this.clock.set(Calendar.DAY_OF_MONTH, this.clock.get(Calendar.DAY_OF_MONTH)-1);
    }

    public void addMonth() {
        this.clock.set(Calendar.MONTH, this.clock.get(Calendar.MONTH)+1);
    }

    public void subtractMonth() {
        this.clock.set(Calendar.MONTH, this.clock.get(Calendar.MONTH)-1);
    }

    public void addYear() {
        this.clock.set(Calendar.YEAR, this.clock.get(Calendar.YEAR)+1);
    }

    public void subtractYear() {
        this.clock.set(Calendar.YEAR, this.clock.get(Calendar.YEAR)-1);
    }


}
