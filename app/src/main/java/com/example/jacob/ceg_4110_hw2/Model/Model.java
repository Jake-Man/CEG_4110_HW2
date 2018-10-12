package com.example.jacob.ceg_4110_hw2.Model;

import android.widget.TextView;

import com.example.jacob.ceg_4110_hw2.Controller.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Model {
    public Controller c;
    public List <Clocks> clocks;
    public ArrayList <TextView> names;
    public ArrayList<TextView> textClockView;
    public Stack<String> command;
    public Stack<String> retract;
    public TimeKeeper timeKeeper;


    public Model(Controller controller) {
        this.c = controller;
    }

    public void start() {
        this.timeKeeper = new TimeKeeper(c);
        this.timeKeeper.startTimer();
        this.clocks = new ArrayList<Clocks>();
        this.names = new ArrayList<TextView>();
        this.command = new Stack<String>();
        this.retract = new Stack<String>();


    }

    public TimeKeeper getTimeKeeper() {
        return this.timeKeeper;
    }
}
