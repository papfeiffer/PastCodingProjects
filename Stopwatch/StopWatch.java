package edu.macalester.comp124.stopWatch;

import acm.graphics.GCompound;
import acm.program.GraphicsProgram;
import java.util.Calendar;

/**
 * This class creates a stopwatch out of LCD numbers. It uses the Number class that extends
 * GCompound. The StopWatchProgram class displays this stopwatch in the console.
 */
public class StopWatch extends GCompound {

    ///////////////////Instance variables///////////////////////////////////////
    private double upLeftX;   // The x position of the upper left corner where this clock will be drawn
    private double upLeftY;   // The y position of the upper left corner where this clock will be drawn

    protected Number hour2Num;
    protected Number hour1Num;
    protected Number colon1;
    protected Number min2Num;
    protected Number min1Num;
    protected Number colon2;
    protected Number sec2Num;
    protected Number sec1Num;

    private int h; // displayed hours
    private int m; // displayed minutes
    private int s; // displayed seconds
    ////////////////////Instance variables/////////////////////////////////////

    /**
     * Constructor for the StopWatch
     * This sets the hours, minutes, and seconds displayed for the stopwatch.
     * All stopwatches start at 00:00:00.
     */

    public StopWatch(int hours, int minutes, int seconds) {
        this.h = hours;
        this.m = minutes;
        this.s = seconds;

        double upLeftX = 20;

        double xPos = upLeftX;
        hour2Num = new Number(0);
        add(hour2Num, xPos, upLeftY);

        xPos += hour2Num.getWidth();
        hour1Num = new Number(0);
        add(hour1Num, xPos, upLeftY);

        xPos += hour1Num.getWidth();
        colon1 = new Number(0);
        add(colon1, xPos, upLeftY);

        xPos += colon1.getWidth();
        min2Num = new Number(0);
        add(min2Num, xPos, upLeftY);

        xPos += min2Num.getWidth();
        min1Num = new Number(0);
        add(min1Num, xPos, upLeftY);

        xPos += min1Num.getWidth();
        colon2 = new Number(0);
        add(colon2, xPos, upLeftY);

        xPos += colon2.getWidth();
        sec2Num = new Number(0);
        add(sec2Num, xPos, upLeftY);

        xPos += sec2Num.getWidth();
        sec1Num = new Number(0);
        add(sec1Num, xPos, upLeftY);
    }

    /**
     *This method draws each digit in the StopWatch display and the colons
     * between the number of seconds and number of minutes and between the
     * number of minutes and the number of hours displayed.
     **/

    public void drawClockTime() {
        int h1 = h % 10; // first digit in hour
        // debug println(" 1st digit for " + h + " is " + h1);
        int h2 = h / 10;
        // debug println("2nd digit for " + h + " is " + h2);

        //Computes values for each digit of minutes (m1, m2) and seconds (s1, s2)
        int m1 = m % 10;
        int m2 = m / 10;
        int s1 = s % 10;
        int s2 = s / 10;

        hour2Num.drawNumber(h2);
        hour1Num.drawNumber(h1);
        colon1.drawNumber(Number.COLON);
        min2Num.drawNumber(m2);
        min1Num.drawNumber(m1);
        colon2.drawNumber(Number.COLON);
        sec2Num.drawNumber(s2);
        sec1Num.drawNumber(s1);

    }

    /**
     * This method is initiated in setupJavaTimer in the StopWatchProgram
     * class. It increments the number of seconds in the sec1Num position.
     * When the next second is 10, the displayed seconds in the sec1Num position
     * loop back to 0 and count to 9 again while simultaneously incrementing
     * the number in the sec2Num position.
     *
     **/

    public void startClock() {
        int nextSecond = sec1Num.getValueDisplayed();

        if (nextSecond < 10) {
            nextSecond++;
            sec1Num.setValueDisplayed(nextSecond);
            sec1Num.drawNumber(sec1Num.getValueDisplayed());
        }
        if (nextSecond == 10) {
            sec1Num.drawNumber(0);
            incrementSeconds2();
        }
    }

    /**
     * This method increments the number of seconds in the sec2Num position.
     * When the next number in this position is 6 (indicating 60 seconds), a
     * call to the incrementMinute1() method is made to add one minute to the
     * displayed time.
     */

    public void incrementSeconds2() {
        int nextSecond = sec2Num.getValueDisplayed();

        if (sec1Num.getValueDisplayed() == 0 && nextSecond < 6) {
            nextSecond++;
            sec2Num.setValueDisplayed(nextSecond);
            sec2Num.drawNumber(nextSecond);
            //incrementSeconds1();

            if (nextSecond == 6) {
                nextSecond = 0;
                sec2Num.setValueDisplayed(nextSecond);
                sec2Num.drawNumber(nextSecond);

                incrementMinute1();
            }
        }
    }

    /**
     * This method increments the number of minutes in the sec2Num position.
     * It increments the number of minutes in the min1Num position.
     * When the next minute is 10, the displayed minutes in the min1Num position
     * loop back to 0 and count to 9 again while simultaneously incrementing
     * the number in the min2Num position.
     */

    public void incrementMinute1() {
        int nextMinute = min1Num.getValueDisplayed();

        if (nextMinute < 10 && sec2Num.getValueDisplayed() == 0) {
            nextMinute++;
            min1Num.setValueDisplayed(nextMinute);
            min1Num.drawNumber(nextMinute);

            if (nextMinute == 10) {
                nextMinute = 0;
                min1Num.setValueDisplayed(nextMinute);
                min1Num.drawNumber(nextMinute);

                incrementMinute2();
            }
        }
    }

    /**
     * This method increments the number of seconds in the min2Num position.
     * When the next number in this position is 6 (indicating 60 minutes), a
     * call to the incrementHour1() method is made to add one hour to the
     * displayed time.
     */

    public void incrementMinute2() {
        int nextMinute = min2Num.getValueDisplayed();

        if (nextMinute < 6 && min1Num.getValueDisplayed() == 0) {
            nextMinute++;
            min2Num.setValueDisplayed(nextMinute);
            min2Num.drawNumber(nextMinute);

            if (nextMinute == 6) {
                nextMinute = 0;
                min2Num.setValueDisplayed(nextMinute);
                min2Num.drawNumber(nextMinute);

                incrementHour1();
            }
        }
    }

    /**
     * This method increments the number of hours in the hour1Num position.
     * When the next hour is 10, the displayed hours in the hour1Num position
     * loop back to 0 and count to 9 again while simultaneously incrementing
     * the number in the min2Num position.
     */

    public void incrementHour1() {
        int nextHour = hour1Num.getValueDisplayed();

        if (nextHour < 10 && min2Num.getValueDisplayed() == 0) {
            nextHour++;
            hour1Num.setValueDisplayed(nextHour);
            hour1Num.drawNumber(nextHour);

            if (nextHour == 10) {
                nextHour = 0;
                hour1Num.setValueDisplayed(nextHour);
                hour1Num.drawNumber(nextHour);

                incrementHour2();
            }
        }
    }

    /**
     * This method increments the number of hours in the hour2Num position.
     * When the next number in this position is 6 (indicating 60 hours),
     * the entire stopwatch is reset to 00:00:00 and the timing starts
     * again automatically from there.
     */

    public void incrementHour2() {
        int nextHour = hour2Num.getValueDisplayed();

        if (nextHour < 6 && hour1Num.getValueDisplayed() == 0) {
            nextHour++;
            hour2Num.setValueDisplayed(nextHour);
            hour2Num.drawNumber(nextHour);

            if (nextHour == 6) {

                sec1Num.setValueDisplayed(0);
                sec1Num.drawNumber(0);
                sec2Num.setValueDisplayed(0);
                sec2Num.drawNumber(0);
                min1Num.setValueDisplayed(0);
                min1Num.drawNumber(0);
                min2Num.setValueDisplayed(0);
                min2Num.drawNumber(0);
                hour1Num.setValueDisplayed(0);
                hour1Num.drawNumber(0);
                hour2Num.setValueDisplayed(0);
                hour2Num.drawNumber(0);
            }
        }
    }


    public StopWatch() {this(0, 0, 0);} //sets a default example?

    public void setH(int h) {
        this.h = h;
    }


    public void setM(int m) {
        this.m = m;
    }

    public void setS(int s) {
        this.s = s;
    }
}



