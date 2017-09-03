package edu.macalester.comp124.breakout;
import acm.graphics.GRect;

import java.awt.*;

/**
 * Created by paigepfeiffer on 3/11/16.
 */
public class Paddle extends GRect {

    private int dx = 900;
    private int dy = 900;

    public Paddle(int dx, int dy, double width, double height) {
        super(dx, dy, width, height);
    }

    public Paddle drawPaddle(Paddle paddle) {
        paddle.setFilled(true);
        paddle.setFillColor(Color.BLACK);
        return paddle;

    }

}
