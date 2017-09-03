package edu.macalester.comp124;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

/**
 * Created by paigepfeiffer on 2/8/16.
 */

    public class HorizontalTriColorFlags extends GraphicsProgram {
        // the width of each stripe on each of the flags
        private static final double STRIPE_WIDTH = 260.0;
        // the height of each stripe on each of the flags
        private static final double STRIPE_HEIGHT = 50.0;
        // the blank space to the left and top of each of the four flags being displayed
        private static final double SPACING = 34.0;

        public void run() {

            double x = SPACING;
            double y = SPACING;

            Color armeniaOrange = new Color(250, 180, 29);
            Color bulgariaGreen = new Color(63, 155, 120);
            Color estoniaBlue = new Color(83, 146, 186);

            horColorVertical(x, y, Color.RED, Color.BLUE, armeniaOrange); //Armenian flag
            horColorVertical((x*2)+STRIPE_WIDTH, y, Color.RED, Color.WHITE, Color.RED); //Austrian flag
            horColorVertical(x, (2*y)+(3*STRIPE_HEIGHT),Color.WHITE,bulgariaGreen, Color.RED); //Bulgaria flag
            horColorVertical(((x*2)+STRIPE_WIDTH), (2*y)+(3*STRIPE_HEIGHT), estoniaBlue, Color.BLACK, Color.WHITE); //Estonia flag

        }

        private void horColorVertical(double x, double y, Color color1, Color color2, Color color3) {
            double x0 = x;
            double y0 = y;
            createFilledStripe(x0, y0, color1);
            double y1 = y + STRIPE_HEIGHT;
            createFilledStripe(x0, y1, color2);
            double y2 = y1 + STRIPE_HEIGHT;
            createFilledStripe(x0, y2, color3);
        }

        private void createFilledStripe(double x, double y, Color color) {
            GRect Rect1 = new GRect(x, y, STRIPE_WIDTH, STRIPE_HEIGHT);
            Rect1.setFilled(true);
            Rect1.setFillColor(color);
            add(Rect1);
            return;
        }

    }
