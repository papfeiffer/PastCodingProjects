package edu.macalester.comp124.stopWatch;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by paigepfeiffer on 3/7/16.
 */
public class TestStopWatchProgram {


    @Test
    public void secondsPass59() { //set clock at 59 seconds
        StopWatchProgram test = new StopWatchProgram();
        test.init();
        test.setClock59Seconds();
        test.setupJavaTimer();
        int incrementMinute = 0;
        if(test.stopwatch.sec1Num.getValueDisplayed() == 0 && test.stopwatch.sec2Num.getValueDisplayed() == 0) {
            incrementMinute++;
            assertEquals(incrementMinute, test.stopwatch.min1Num.getValueDisplayed());
        }
    }

    @Test
    public void minutesPass59() {
        StopWatchProgram test = new StopWatchProgram();
        test.init();
        test.setClock59Minutes();
        test.setupJavaTimer();
        int incrementHour = 0;
        if(test.stopwatch.sec1Num.getValueDisplayed() == 0 && test.stopwatch.sec2Num.getValueDisplayed() == 0 && test.stopwatch.min1Num.getValueDisplayed() == 0 && test.stopwatch.min2Num.getValueDisplayed() == 0) {
            incrementHour++;
            assertEquals(incrementHour, test.stopwatch.hour1Num.getValueDisplayed());
        }
    }

    @Test
    public void hoursPass59 () {
        StopWatchProgram test = new StopWatchProgram();
        test.init();
        test.setClock59Hours();
        test.setupJavaTimer();
        if (test.stopwatch.sec1Num.getValueDisplayed() == 0 && test.stopwatch.sec2Num.getValueDisplayed() == 0 && test.stopwatch.min1Num.getValueDisplayed() == 0 && test.stopwatch.min2Num.getValueDisplayed() == 0 && test.stopwatch.hour1Num.getValueDisplayed() == 0 && test.stopwatch.hour2Num.getValueDisplayed() == 0) {
            assertEquals(0, test.stopwatch.sec1Num.getValueDisplayed());
            assertEquals(0, test.stopwatch.sec2Num.getValueDisplayed());
            assertEquals(0, test.stopwatch.min1Num.getValueDisplayed());
            assertEquals(0, test.stopwatch.min2Num.getValueDisplayed());
            assertEquals(0, test.stopwatch.hour1Num.getValueDisplayed());
            assertEquals(0, test.stopwatch.hour2Num.getValueDisplayed());
        }
    }

}
