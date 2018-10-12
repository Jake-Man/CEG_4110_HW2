package com.example.jacob.ceg_4110_hw2.View;

import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

import com.example.jacob.ceg_4110_hw2.Controller.Controller;
import com.example.jacob.ceg_4110_hw2.R;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.widget.TextClock;

import com.example.jacob.ceg_4110_hw2.R;

public class MainActivity extends AppCompatActivity {

    private static Button addSecond;
    private static Button subtractSecond;
    private static Button addMinute;
    private static Button subtractMinute;
    private static Button addHour;
    private static Button subtractHour;
    private static Button addDay;
    private static Button subtractDay;
    private static Button addMonth;
    private static Button subtractMonth;
    private static Button addYear;
    private static Button subtractYear;
    private static TextView inputTitle;
    private static Button createNew;
    private static Button toggleView;
    private static Button undo;
    private static Button redo;
    private  Controller controller;






    //private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        //mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        //mViewPager = (ViewPager) findViewById(R.id.container);
        //mViewPager.setAdapter(mSectionsPagerAdapter);

        addSecond = findViewById(R.id.addSecond);
        subtractSecond = findViewById(R.id.subtractSecond);
        addMinute = findViewById(R.id.addMinute);
        subtractMinute = findViewById(R.id.subtractMinute);
        addHour = findViewById(R.id.subtractHour);
        subtractHour = findViewById(R.id.subtractHour);
        addDay = findViewById(R.id.addDay);
        subtractDay = findViewById(R.id.subtractDay);
        addMonth = findViewById(R.id.addMonth);
        subtractMonth = findViewById(R.id.subtractMonth);
        addYear = findViewById(R.id.addYear);
        subtractYear = findViewById(R.id.subtractYear);
        inputTitle = findViewById(R.id.inputTitle);
        toggleView = findViewById(R.id.toggleView);
        undo = findViewById(R.id.undo);
        redo = findViewById(R.id.redo);


        toggleViewListener();

        addSecondListener();
        addMinuteListener();
        addHourListener();
        addYearListener();
        addMonthListener();
        addDayListener();
        subtractSecondListener();
        subtractMinuteListener();
        subtractHourListener();
        subtractYearListener();
        subtractMonthListener();
        subtractDayListener();
        undo();
        redo();

        this.controller = new Controller(this);
        controller.start();
        start();


        createNew = findViewById(R.id.createNew);
        createNew.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ViewGroup layout = findViewById(R.id.myClocks);
                        TextView textClock = (TextView) new TextView(getApplicationContext());
                        TextView name = new TextView(getApplicationContext());


                        controller.makeClock(inputTitle.getText().toString(), name, textClock);

                        layout.addView(name);
                        layout.addView(textClock);

                    }
                }
        );

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
          /*  @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


               /* addSecond = findViewById(R.id.addSecond);
                subtractSecond = findViewById(R.id.subtractSecond);
                addMinute = findViewById(R.id.addMinute);
                subtractMinute = findViewById(R.id.subtractMinute);
                addHour = findViewById(R.id.subtractHour);
                subtractHour = findViewById(R.id.subtractHour);
                addDay = findViewById(R.id.addDay);
                subtractDay = findViewById(R.id.subtractDay);
                addMonth = findViewById(R.id.addMonth);
                addYear = findViewById(R.id.addYear);
                subtractYear = findViewById(R.id.subtractYear);
                inputTitle = findViewById(R.id.inputTitle);
                toggleView = findViewById(R.id.toggleView);
                undo = findViewById(R.id.undo);
                redo = findViewById(R.id.redo);


                toggleViewListener();

                addSecondListener();
                addMinuteListener();
                addHourListener();
                addYearListener();
                addMonthListener();
                addDayListener();
                subtractSecondListener();
                subtractMinuteListener();
                subtractHourListener();
                subtractYearListener();
                subtractMonthListener();
                subtractDayListener();
                undo();
                redo();

                this.controller = new Controller(this);
                controller.start();
                start();


                createNew = findViewById(R.id.createNew);
                createNew.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ViewGroup layout = findViewById(R.id.myClocks);
                                TextView textClock = (TextView) new TextView(getApplicationContext());
                                TextView name = new TextView(getApplicationContext());


                                controller.makeClock(inputTitle.getText().toString(), name, textClock);

                                layout.addView(name);
                                layout.addView(textClock);

                            }
                        }
                );*/

        //   }
        //});

    }

    public void addMonthListener() {
        addMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.editClock("+mon", inputTitle.getText().toString());
            }
        });
    }

    public void addDayListener() {
        addDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.editClock("+day", inputTitle.getText().toString());
            }
        });
    }

    public void subtractSecondListener() {
        subtractSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.editClock("-sec", inputTitle.getText().toString());
            }
        });
    }

    public void subtractMinuteListener() {
        subtractMinute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.editClock("-min", inputTitle.getText().toString());
            }
        });
    }

    public void subtractHourListener() {
        subtractHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.editClock("-hr", inputTitle.getText().toString());
            }
        });
    }

    public void subtractYearListener() {
        subtractYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.editClock("-yr", inputTitle.getText().toString());
            }
        });
    }

    public void subtractMonthListener() {
        subtractMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.editClock("-mon", inputTitle.getText().toString());
            }
        });
    }

    public void redo() {
        redo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        controller.redo();
                    }
                }
        );
    }

    public void undo() {
        undo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        controller.undo();
                    }
                }
        );
    }

    public void subtractDayListener() {
        subtractDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.editClock("-day", inputTitle.getText().toString());
            }
        });
    }

    public void addYearListener() {
        addYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.editClock("+yr", inputTitle.getText().toString());
            }
        });
    }

    public void toggleViewListener() {
        toggleView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        controller.toggleView();
                    }
                }
        );
    }

    public void addSecondListener() {
        addSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.editClock("+sec", inputTitle.getText().toString());
            }
        });
    }

    public void addMinuteListener() {
        addMinute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.editClock("+min", inputTitle.getText().toString());
            }
        });
    }


    public void addHourListener() {
        addHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.editClock("+hr", inputTitle.getText().toString());
            }
        });
    }


    public void createClock(String n){
        ViewGroup layout = findViewById(R.id.myClocks);
        TextView textClock = (TextView) new TextView(getApplicationContext());
        TextView name = new TextView(getApplicationContext());


        controller.makeClock(inputTitle.getText().toString(), name, textClock);

        layout.addView(name);
        layout.addView(textClock);
    }

    public void start(){
        ViewGroup layout = findViewById(R.id.myClocks);
        TextView textClock = (TextView) new TextView(getApplicationContext());
        TextView name = new TextView(getApplicationContext());


        controller.makeClock(inputTitle.getText().toString(), name, textClock);

        layout.addView(name);
        layout.addView(textClock);
    }




    public void editView(final String s, final TextView textView) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(s);
            }
        });
    }

    public void removeClock(TextView name, TextView textClock) {
        ViewGroup layout = findViewById(R.id.myClocks);
        layout.removeView(name);
        layout.removeView(textClock);
    }
}
