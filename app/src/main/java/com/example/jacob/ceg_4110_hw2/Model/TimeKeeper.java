package com.example.jacob.ceg_4110_hw2.Model;

import com.example.jacob.ceg_4110_hw2.Controller.Controller;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimeKeeper extends TimerTask {
    Clocks clock;
    Timer timer;
    Controller controller;

    TimeKeeper(Controller controller){
        this.controller = controller;
    }

    public TimeKeeper (Clocks clock, Controller controller){
        this.clock = clock;
        this.controller = controller;
    }


    public void startClock(Clocks clock) {
        this.timer.schedule(new TimeKeeper(clock, controller),0,1000);
    }



    public Timer startTimer() {
        return this.timer = new Timer();
    }

    @Override
    public void run() {
        clock.clock.set(Calendar.SECOND, clock.clock.get(Calendar.SECOND)+1);
        this.controller.editClock(clock.format.format(clock.clock.getTime()), this.clock.getName());

    }
}

