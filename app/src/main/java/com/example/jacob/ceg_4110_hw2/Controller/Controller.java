package com.example.jacob.ceg_4110_hw2.Controller;

import android.widget.TextView;

import com.example.jacob.ceg_4110_hw2.View.MainActivity;
import com.example.jacob.ceg_4110_hw2.Model.Model;
import com.example.jacob.ceg_4110_hw2.Model.Clocks;
import com.example.jacob.ceg_4110_hw2.View.MainActivity;


public class Controller {
    private MainActivity main;
    private Model model;

    public Controller(MainActivity main){
        this.model = new Model(this);
        this.main = main;
    }

    public Clocks makeClock(String s, TextView name, TextView textClock) {
        Clocks clock = new Clocks(s);
        boolean clockExist = false;
        for (Clocks c: model.clocks){
            if (c.getName().equals(s)){
                clockExist = true;
                break;
            }
        }
        model.clocks.add(clock);
        model.names.add(name);
        model.textClockView.add(textClock);

        if (!clockExist)
            startClock(clock);
        model.command.push("makeClock");
        return clock;

    }

    public void startClock(Clocks clock) {
        model.getTimeKeeper().startClock(clock);
    }

    public void alterTime(String s, String name){
        for (Clocks clock:model.clocks){
            String clockName = clock.getName();
            if (clockName.equals(name)){
                switch (s){
                    case "+sec": clock.addSec();
                        break;
                    case "-sec": clock.subtractSec();
                        break;
                    case "+min": clock.addMin();
                        break;
                    case "-min": clock.subtractMin();
                        break;
                    case "+hr": clock.addHour();
                        break;
                    case "-hr": clock.subtractHour();
                        break;
                    case "+day": clock.addDay();
                        break;
                    case "-day": clock.subtractDay();
                        break;
                    case "+mon": clock.addMonth();
                        break;
                    case "-mon": clock.subtractMonth();
                        break;
                    case "+yr": clock.addYear();
                        break;
                    case "-yr": clock.subtractYear();
                        break;
                }

                model.command.push(name + "`"+ s);
            }
        }
    }

    public void start() {
        model.start();
    }

    public void undo() {
        if (model.command.isEmpty())
            return;
        String activity = model.command.pop();
        model.retract.push(activity);
        if (activity.equals("toggleView")){
            toggleView();
            model.command.pop();

        } else if (activity.equals("makeClock")){
            model.retract.pop();
            model.retract.push("makeClock`" + model.clocks.get(model.clocks.size()-1).getName());
            main.removeClock(model.names.get(model.names.size()-1), model.textClockView.get(model.textClockView.size()-1));
            model.clocks.remove(model.clocks.size()-1);
            model.names.remove(model.names.size()-1);
            model.textClockView.remove(model.textClockView.size()-1);

        } else {
            String[] split = activity.split("\\`");
            for (Clocks clock:model.clocks){
                String clockName = clock.getName();
                if (clockName.equals(split[0])){
                    switch (split[1]){
                        case "+sec": clock.addSec();
                            break;
                        case "-sec": clock.subtractSec();
                            break;
                        case "+min": clock.addMin();
                            break;
                        case "-min": clock.subtractMin();
                            break;
                        case "+hr": clock.addHour();
                            break;
                        case "-hr": clock.subtractHour();
                            break;
                        case "+day": clock.addDay();
                            break;
                        case "-day": clock.subtractDay();
                            break;
                        case "+mon": clock.addMonth();
                            break;
                        case "-mon": clock.subtractMonth();
                            break;
                        case "+yr": clock.addYear();
                            break;
                        case "-yr": clock.subtractYear();
                            break;
                    }
                }
            }
        }

    }

    public void redo() {
        if (model.retract.isEmpty())
            return;
        String activity = model.retract.pop();
        String[] split = activity.split("\\`");
        if (activity.equals("toggleView")){
            toggleView();
        } else if (split[0].equals("makeClock"))
            main.createClock(split[1]);
        else
            alterTime(split[1],split[0]);

    }

    public void toggleView() {
        int index = 0;
        boolean textClockSeeable = true;
        if (model.textClockView.get(0).getVisibility()==TextView.GONE)
            textClockSeeable=false;
        for (Clocks clock:model.clocks){
            if (!textClockSeeable){
                model.textClockView.get(index).setVisibility(TextView.VISIBLE);

            }
            else{
                model.textClockView.get(index).setVisibility(TextView.GONE);

            }
            index++;
        }
        model.command.push("toggleView");
    }

    public void editClock(String s, String name) {
        int index=0;
        for (Clocks clock: model.clocks){
            if (clock.getName().equals(name))
                main.editView(s, model.textClockView.get(index));
        }

        index++;


    }
}
