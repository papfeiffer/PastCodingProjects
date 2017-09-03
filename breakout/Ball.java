package edu.macalester.comp124.breakout;

import acm.graphics.GOval;

/**
 * Created by paigepfeiffer on 3/10/16.
 */
public class Ball extends GOval{

    private double dx;
    private double dy;

    public Ball(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.dx = 2;
        this.dy = 1;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public double setDx(double dx) {
        this.dx = dx;
        return dx;
    }
    public double setDy(double dy) {
        this.dy = dy;
        return dy;
    }
}




