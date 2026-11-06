/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sala 2 - 5
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle {
    int id;
    int yVelocity;
    int speed;
    Color paddleColor;

    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id, Color color, int speed){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id = id;
        this.paddleColor = color;
        this.speed = speed;
    }

    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id, Color color){
        this(x, y, PADDLE_WIDTH, PADDLE_HEIGHT, id, color, 13);
    }

    public void keyPressed (KeyEvent e) {
        int key = e.getKeyCode();
        switch(id) {
            case 1:
                if(key==KeyEvent.VK_W) { setYDirection(-speed); move(); }
                if(key==KeyEvent.VK_S) { setYDirection(speed);  move(); }
                break;
            case 2:
                if(key==KeyEvent.VK_UP)   { setYDirection(-speed); move(); }
                if(key==KeyEvent.VK_DOWN) { setYDirection(speed);  move(); }
                break;
            case 3:
                if(key==KeyEvent.VK_R) { setYDirection(-speed); move(); }
                if(key==KeyEvent.VK_F) { setYDirection(speed);  move(); }
                break;
            case 4:
                if(key==KeyEvent.VK_O) { setYDirection(-speed); move(); }
                if(key==KeyEvent.VK_L) { setYDirection(speed);  move(); }
                break;
        }
    }

    public void keyReleased (KeyEvent e) {
        int key = e.getKeyCode();
        switch(id) {
            case 1:
                if(key==KeyEvent.VK_W) { setYDirection(0); move(); }
                if(key==KeyEvent.VK_S) { setYDirection(0); move(); }
                break;
            case 2:
                if(key==KeyEvent.VK_UP)   { setYDirection(0); move(); }
                if(key==KeyEvent.VK_DOWN) { setYDirection(0); move(); }
                break;
            case 3:
                if(key==KeyEvent.VK_R) { setYDirection(0); move(); }
                if(key==KeyEvent.VK_F) { setYDirection(0); move(); }
                break;
            case 4:
                if(key==KeyEvent.VK_O) { setYDirection(0); move(); }
                if(key==KeyEvent.VK_L) { setYDirection(0); move(); }
                break;
        }
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void move() {
        y = y + yVelocity;
    }

    public void draw(Graphics g){
        g.setColor(paddleColor);
        g.fillRect(x, y, width, height);
    }
}