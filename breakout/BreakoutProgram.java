package edu.macalester.comp124.breakout;
import acm.program.GraphicsProgram;
import acm.graphics.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Main GraphicsProgram for the breakout game described
 * in exercise 10.10 int the Roberts Textbook.
 *
 */
public class BreakoutProgram extends GraphicsProgram implements KeyListener {

    private boolean leftKeyPressed = false;
    private boolean rightKeyPressed = false;

    private GLabel label;

    public final static int ONE_SECOND = 1000;

    private BrickWall brickwall;
    private Ball ball;
    private Paddle paddle;
    private static final double BALL_SIZE = 30;
    private static final int PAUSE_TIME = 7;

    private int numofLives = 3;

    public void init() {

        ball = new Ball(750, 800, BALL_SIZE, BALL_SIZE);
        brickwall = new BrickWall();
        paddle = new Paddle(500, 500, 130, 20);

        paddle.drawPaddle(paddle);
        add(paddle);
        add(brickwall);
        ball.setFilled(true);
        add(ball, getWidth() / 1.5, getHeight() / 1.5);

        setFocusable(true);
        addKeyListeners();

        //addMouseListeners();

        JButton button = new JButton("End Game");
        button.setSize(80, 40);
        add(button, SOUTH);

        setSize(1070, 600);

        label = new GLabel("Lives: " + getNumofLives());
        label.setFont("SanSerif-bold-24");
        add(label, 930, 475);

        addActionListeners();
    }

    public void run() {
        //
        waitForClick();
        while (true) {
            while (!checkforWin() && !checkforLose()) {
                moveBall(ball);
                pause(PAUSE_TIME);
                checkPaddleCollision(ball);
                checkBrickCollision(ball);

                if (checkforLose()) {
                    remove(label);
                    numofLives--;
                    label = new GLabel("Lives: " + getNumofLives());
                    label.setFont("SanSerif-bold-24");
                    add(label, 930, 500);

                    ball = new Ball(750, 800, BALL_SIZE, BALL_SIZE);
                    ball.setFilled(true);
                    add(ball, getWidth() / 1.9, getHeight() / 1.8);
                    pause(PAUSE_TIME);


                    if (numofLives == 0) {
                        GLabel label2 = new GLabel("You lose!");
                        label2.setFont("SanSerif-bold-24");
                        add(label2, 505, 425);
                    }

                }

                if (checkforWin()) {
                    GLabel label3 = new GLabel("You win!");
                    label3.setFont("SanSerif-bold-24");
                    add(label3, 505, 300);

                }
            }
        }
    }


        /**
         * Every time the left and right arrow keys are pressed while the game is
         * running, the paddle moves to the left or right.
         */

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftKeyPressed = true;
            paddle.move(-40, 0);
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightKeyPressed = true;
            paddle.move(40, 0);
            return;
        }
        repaint();
    }

        /**
        * This method moves the ball in the opposite direction when it hits a surface.
         * The ball is also prevented from leaving the program frame except for at the
         * bottom.
        *
        */
    private void moveBall(Ball ball) {
        double bx = ball.getX();
        double by = ball.getY();
        double dx = ball.getDx();
        double dy = ball.getDy();

        if (bx < 0) {                                 //Prevents ball from flying out of the top left of the program
            dx = ball.setDx(Math.abs(ball.getDx()));
        }
        if (bx > getWidth() - BALL_SIZE) {            //Allows ball to move in opposite x direction when it bounces
            dx = ball.setDx(-Math.abs(ball.getDx())); //off wall
        }
        if (by < 0) {
            dy = ball.setDy(Math.abs(ball.getDy()));
        }

        ball.move(dx, dy);
    }

    /**
     * This method checks what happens when the ball collides with the paddle. The
     * ball will bounce away from the paddle and toward the brick wall.
     * @param ball
     */

    private void checkPaddleCollision(Ball ball) {

        GObject colliderbottomLeft = getElementAt(ball.getX(), ball.getY() + BALL_SIZE);
        GObject colliderbottomRight = getElementAt(ball.getX() + BALL_SIZE, ball.getY() + BALL_SIZE);
        if (colliderbottomLeft instanceof Paddle || colliderbottomRight instanceof Paddle) {
            //as soon as you detect paddle collision, move ball away from paddle
            double paddleYPos = paddle.getY();
            double newballYPos = paddleYPos - ball.getHeight() - 0.5;
            ball.setLocation(ball.getX(), newballYPos);
            ball.setDy(-Math.abs(ball.getDy())); //random y coordinate?
            //bug somewhere in program

        }

    }

    /**
     * This method checks what happens when the ball collides with a brick in
     * the brick wall. This method calls the collideBricks() method in the
     * BrickWall class in order to remove bricks and to move the ball away
     * from where the given brick is removed.
     * @param ball
     */

    private void checkBrickCollision(Ball ball) {
        GObject collider = getElementAt(ball.getX(), ball.getY());
        GObject collider1 = getElementAt(ball.getX() + ball.getWidth(), ball.getY());
        GObject collider2 = getElementAt(ball.getX(), ball.getY() + ball.getWidth());
        GObject collider3 = getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getWidth());

        if (collider instanceof BrickWall || collider1 instanceof BrickWall || collider2 instanceof BrickWall || collider3 instanceof BrickWall) {
            //as soon as you detect brick collision, move ball away from brick
            brickwall.collideBricks(ball);
            //This method will remove bricks
            }
        }

    /**
     * checkforLose() concerns whether the ball leaves the frame and whether
     * the number of lives is 0. If the number of lives is 0, the game ends
     * and the player loses.
     * @return
     */

    private boolean checkforLose() {
        double by = ball.getY();

        if (by > getHeight() + BALL_SIZE && numofLives > 0) {
            return true;
        }

        if (numofLives == 0) {
            return true;
        }

        return false;
    }

    /**
     * checkforWin() concerns whether all the bricks are removed. If so, the
     * player is a winner and the game ends.
     * @return
     */

    private boolean checkforWin() {

        if(brickwall.getNumofBricks() == 0) {
            return true;
        }

        return false;
    }

    /**
     * If the "End Game" button is pressed, the GraphicsProgram console closes
     * and the game in progress or finished game ends.
     * @param e
     */

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("End Game")) {
            System.exit(0);
        }
    }



    public int getNumofLives() {
        return numofLives;
    }

}












