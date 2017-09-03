package edu.macalester.comp124.stopWatch;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * This Program will display a stopwatch that can be started and stopped with a
 * button placed at the bottom of the window.
 *
 * Created by shoop on 2/25/16.
 */
public class StopWatchProgram extends GraphicsProgram {

    // TODO: use a StopWatch instance instead of a label
    protected StopWatch stopwatch;     // remove this after you have made your own StopWatch

    Timer timer; // this is used in place of a while(true) loop with a pause
    public final static int ONE_SECOND = 1000;


    private int hours; // the last displayed hours
    private int minutes; // the last displayed minutes
    private int seconds; // the last displayed seconds

    public void init() {
        hours = 0;
        minutes = 0;
        seconds = 0;

        setSize(700, 200); // a reasonable size to hold the stopwatch

        JButton button = new JButton("Start");
        JButton button2 = new JButton("Stop");
        button.setSize(80, 40);
        button2.setSize(80, 40);

        //////// THIS LABEL SHOULD BE REPLACED BY YOUR STOPWATCH
        stopwatch = new StopWatch(0, 0, 0);
        stopwatch.drawClockTime();
        add(stopwatch, 20.0, 20.0);
        ///////////////////////////////////////////////

        add(button, SOUTH); //adds button to user interface
        add(button2, SOUTH);

        addActionListeners();  // for the button

        setupJavaTimer();

    }

    // NOTE: no run() method is necessary in this program, since
    //       the following Java Timer represents how we can start and
    //       stop a continuous loop that triggers events.

    /**
     * A Timer is used in Java Graphics programs to trigger an
     * event to occur repeatedly after a certain amount of time.
     * In our case, we will trigger the event for every second,
     * and update the current time being displayed when the event
     * occurs.
     *
     * In this event-driven program that contains a JButton for the
     * user to start and stop the displayed timer, we must use this
     * code in place of using pause() inside a while(true) loop
     * as we have done previously.
     */
    /**These are the actions performed when the button is pressed.**/

    public void setupJavaTimer() {
        timer = new Timer(ONE_SECOND, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                //TODO: replace this with an update to the LCD version of the stop watch
                //seconds++; //updating seconds is not enough for the real timer
                // label.setLabel(Integer.toString(seconds));
                stopwatch.startClock(); //starts counting seconds

            }
        });
    }  // leave the structure of this method declaration intact

    /**
     * This method is strictly used for testing purposes and is used to test
     * whether a minute is added to the displayed time when the number of
     * seconds passes 59.
     */

    public void setClock59Seconds(){
        stopwatch.sec1Num.setValueDisplayed(9);

        stopwatch.sec2Num.setValueDisplayed(5);

    }

    /**
     * This method is strictly used for testing purposes and is used to test
     * whether an hour is added to the displayed time when the number of minutes
     * passes 59.
     */


    public void setClock59Minutes(){
        stopwatch.sec1Num.setValueDisplayed(9);

        stopwatch.sec2Num.setValueDisplayed(5);

        stopwatch.min1Num.setValueDisplayed(9);

        stopwatch.min2Num.setValueDisplayed(5);

    }

    /**
     * This method is strictly used for testing purposes and is used to test
     * whether the clock is reset to 00:00:00 when the number of hours
     * passes 59.
     */


    public void setClock59Hours() {
        setClock59Minutes();
        setClock59Seconds();
        stopwatch.hour1Num.setValueDisplayed(9);
        stopwatch.hour2Num.setValueDisplayed(5);
    }



    /**
     * Toggle the current state of the displayed StopWatch.
     * If the current state of the displayed StopWatch in
     * this program is "toggled" to 'off', then stop the timer object.
     * If the current state is 'on' then start the timer.
     */
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Start")) {
            // TODO: complete the logic here
            //       Right now this simply starts the timer when you click
            //       the button -
            //       you will need to kill the program to have it go away.
            //       The real version will start and stop your timer.
            //
            timer.start();
            }
        if(cmd.equals("Stop")) {
            timer.stop();
        }
        }
    }


