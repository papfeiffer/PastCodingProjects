package edu.macalester.comp124;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

/**
 * This class is a GraphicsProgram that draws four flags.
 *
 * Created by shoop on 2/1/16.
 */
public class VerticalTriColorFlags extends GraphicsProgram {
    // the width of each stripe on each of the flags
    private static final double STRIPE_WIDTH = 100.0;
    // the height of each stripe on each of the flags
    private static final double STRIPE_HEIGHT = 200.0;
    // the blank space to the left and top of each of the four flags being displayed
    private static final double SPACING = 34.0;

    public void run() {
    // You complete this

        double x = SPACING;
        double y = SPACING;

        Color nigeriaGreen = new Color(0,128,0);
        Color irelandOrange = new Color(244, 138, 19);
        Color irelandGreen = new Color(48, 146, 49);

        triColorVertical(x, y, nigeriaGreen, Color.WHITE, nigeriaGreen);
        triColorVertical(((x*2)+(STRIPE_WIDTH*3)), y, Color.RED, Color.YELLOW, Color.BLUE);
        //triColorVertical(x, getHeight()-((SPACING) + STRIPE_HEIGHT), Color.RED, Color.WHITE, Color.BLUE);
        triColorVertical(x, getHeight()-((SPACING) + STRIPE_HEIGHT), irelandGreen, Color.WHITE, irelandOrange);
        triColorVertical(((x*2)+(STRIPE_WIDTH*3)), getHeight()-((SPACING) + STRIPE_HEIGHT), Color.BLACK, Color.YELLOW, Color.RED);

    }


    /**
     * Draws three vertical stripes, one of each color.
     *
     * @param x   location of the top left corner of three stripes to be drawn
     * @param y   location of the top left corner of three stripes to be drawn
     * @param color1  color of the left of the three stripes
     * @param color2  color of the middle of the three stripes
     * @param color3  color of the right of the three stripes
     */
    private void triColorVertical (double x, double y, Color color1, Color color2, Color color3) {
        // you complete this according to the description and documentation of the parameters
        double x0 = x;
        double y0 = y;
        createFilledStripe(x0, y0, color1);
        double x1 = x + 100.0;
        createFilledStripe(x1, y0, color2);
        double x2 = x1 + 100.0;
        createFilledStripe(x2, y0, color3);
    }

    /**
     * Creates and returns a GRect representing one of the vertical stripes on a flag.
     *
     * @param x x value of top left corner of this stripe
     * @param y y value of top left corner of this stripe
     * @param color the Color for this particular stripe
     * @return the new instance of a GRect that is filled with the color
     */
    private void createFilledStripe(double x, double y, Color color) {
        GRect Rect1 = new GRect(x, y, STRIPE_WIDTH, STRIPE_HEIGHT  ); //created GRect object
        Rect1.setFilled(true);
        Rect1.setFillColor(color);
        add(Rect1);
        return;
    }
}
