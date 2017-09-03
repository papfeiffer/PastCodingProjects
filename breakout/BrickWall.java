package edu.macalester.comp124.breakout;

import acm.graphics.GCompound;
import java.awt.Color;
import java.util.ArrayList;
import acm.graphics.GObject;
/**
 * Created by paigepfeiffer on 3/10/16.
 */
public class BrickWall extends GCompound {

    private double DISTANCE_BETWEEN_COLUMNS = 105;
    private int ROWS = 5;
    private int COLUMNS = 9;
    private double DISTANCE_BETWEEN_ROWS = 45;
    private int numofBricks = 45;

    public BrickWall() {
        drawWall();
    }

    /**
     * This method draws the brick wall that will be used in the
     * main BreakoutProgram class.
     */

    public void drawWall() {
        ArrayList<Color> colors = new ArrayList<Color>();
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        int dx = 60;
        int dy = 60;
        for (int i = 0; i < ROWS; i++) {
            for (int c = 0; c < COLUMNS; c++) {
                Brick brick = defineBrick(colors.get(i));
                add(brick, dx, dy);
                dx += DISTANCE_BETWEEN_COLUMNS;
            }
            dy += DISTANCE_BETWEEN_ROWS;
            dx = 60;
        }
    }

    /**
     * Creates an individual brick with a given color. This method is
     * used to draw the brick wall in drawWall().
     * @param color
     * @return
     */

    public Brick defineBrick(Color color) { //gets x and y coordinates for next brick and its color
        Brick brick = new Brick(90, 40);
        brick.setFilled(true);
        brick.setFillColor(color);
        return brick;
    }

    /**
     * Actions that take place after ball hits brick. If the GObject obtained
     * with the getElementAt() method is the location that the ball hits,
     * then the brick is removed and the ball immediately moves away from
     * the spot where the brick was.
     * @param ball
     */

    public void collideBricks(Ball ball) {
        GObject topLeft = getElementAt(ball.getX(), ball.getY());
        GObject topRight = getElementAt(ball.getX() + ball.getWidth(), ball.getY());
        GObject bottomLeft = getElementAt(ball.getX(), ball.getY() + ball.getWidth());
        GObject bottomRight = getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getWidth());

        double dx = ball.getDx();
        double dy = ball.getDy();
        //in these if statements, we consider if the top left corner of the ball:
        //--1) Hits the side of a brick on the right side of the screen

            if (topLeft != null && bottomLeft != null && topRight == null && bottomRight == null) {
                    remove(topLeft);
                    remove(bottomLeft);
                    dx = ball.setDx(Math.abs(ball.getDx()));
                    numofBricks--;
                }


        //--2) Hits the bottom of a brick
            if (topLeft != null && topRight != null && bottomLeft == null && bottomRight == null) {
                    remove(topLeft);
                    dy = ball.setDy(Math.abs(ball.getDy()));
                    numofBricks--;
                }


        //--3) Hits the left side of a brick
            if(topRight != null && bottomRight != null && topLeft == null && bottomLeft == null) {
                    remove(topRight);
                    dx = ball.setDx(-Math.abs(ball.getDx()));
                    numofBricks--;
                }


        //--4) Hits the top of a brick
            if(bottomLeft != null && bottomRight != null && topLeft == null && topRight == null) {
                    remove(bottomLeft);
                    dy = ball.setDy(-Math.abs(ball.getDy()));
                    numofBricks--;
                }

    }

    public int getNumofBricks() {
        return numofBricks;
    }
}
