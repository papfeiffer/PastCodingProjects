package edu.macalester.comp124;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

/**
 * Created by paigepfeiffer on 2/8/16.
 */
public class VariousFlags extends GraphicsProgram {


    private static final double CROSS_WIDTH = 35.0;
    private static final double CROSS_RECTANGLE_HEIGHT = 50.0;

    private static final double CROSS_RECTANGLE_WIDTH2 = 60.0;
    private static final double CROSS_RECTANGLE_HEIGHT2 = 35.0;

    private static final double CROSS_SQUARE_WIDTH_AND_HEIGHT = 35.0;

    private static final double WHITE_RECT_HEIGHT = 50.0;
    private static final double WHITE_RECT_WIDTH = 60.0;

    private static final double SPACING = 34.0;

    public void run(){
 //setFillColor = inside of rectangle
 //setColor =  outline of rectangle
        double x = SPACING;
        double y = SPACING;

        drawVarFlags(x, y, Color.WHITE, Color.BLUE);
        drawVarFlags(((x*2)+ ((3*WHITE_RECT_WIDTH)+CROSS_WIDTH)), y, Color.RED, Color.WHITE);
        drawVarFlags(x, ((y*2) + (2*WHITE_RECT_HEIGHT) + CROSS_RECTANGLE_HEIGHT2), Color.BLUE, Color.YELLOW);
    }

    private void drawVarFlags(double x, double y, Color color1, Color color2){
        double x0 = x;
        double y0 = y;
        createFilledStripe(x0, y0, color1);
        double x1 = x + WHITE_RECT_WIDTH;
        createFilledStripe2(x1, y0, color2);
        double x2 = x1 + CROSS_WIDTH;
        createFilledStripe3(x2, y0, color1);
        double y1 = y + WHITE_RECT_HEIGHT; //starts 2nd section of flag
        createColorRect(x0, y1, color2);
        createColorSquare(x1, y1, color2);
        createColorRect(x2, y1, color2);
        double x3 = x2 + CROSS_RECTANGLE_WIDTH2;
        createColorRect(x3, y1, color2);
        double y2 = y + WHITE_RECT_HEIGHT + CROSS_RECTANGLE_HEIGHT2;
        createFilledStripe(x0, y2, color1);
        createFilledStripe2(x1, y2, color2);
        createFilledStripe3(x2, y2, color1);

    }

    private void createFilledStripe(double x, double y, Color color){
        GRect Rect1 = new GRect(x, y, WHITE_RECT_WIDTH, WHITE_RECT_HEIGHT);
        Rect1.setFilled(true);
        Rect1.setFillColor(color);
        //Rect1.setColor(color);
        add(Rect1);
        return;

}

    private void createFilledStripe2(double x, double y, Color color){
        GRect Rect2 = new GRect(x, y, CROSS_WIDTH, CROSS_RECTANGLE_HEIGHT  );
        Rect2.setFilled(true);
        Rect2.setFillColor(color);
        Rect2.setColor(color);
        add(Rect2);
        return;
}

    private void createFilledStripe3(double x, double y, Color color){
        GRect Rect3 = new GRect(x, y, (2*WHITE_RECT_WIDTH), (WHITE_RECT_HEIGHT));
        Rect3.setFilled(true);
        Rect3.setFillColor(color);
        add(Rect3);
        return;
    }

    private void createColorRect(double x, double y, Color color){
        GRect Rect4 = new GRect(x, y, CROSS_RECTANGLE_WIDTH2, CROSS_RECTANGLE_HEIGHT2);
        Rect4.setFilled(true);
        Rect4.setFillColor(color);
        Rect4.setColor(color);
        add(Rect4);
        return;
    }

    private void createColorSquare(double x, double y, Color color){
        GRect Rect5 = new GRect(x, y, CROSS_SQUARE_WIDTH_AND_HEIGHT, CROSS_SQUARE_WIDTH_AND_HEIGHT);
        Rect5.setFilled(true);
        Rect5.setFillColor(color);
        Rect5.setColor(color);
        add(Rect5);
        return;

    }
}
