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

public class Score extends Rectangle {
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
    int player2;
    String player1Name;
    String player2Name;

    Score(int GAME_WIDTH, int GAME_HEIGHT, String p1, String p2) {
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
        this.player1Name = p1;
        this.player2Name = p2;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);

        g.setFont(new Font("Consolas", Font.PLAIN, 60));
        g.drawString(String.valueOf(player1 / 10) + String.valueOf(player1 % 10),
                     (GAME_WIDTH / 2) - 85, 50);
        g.drawString(String.valueOf(player2 / 10) + String.valueOf(player2 % 10),
                     (GAME_WIDTH / 2) + 20, 50);

        g.setFont(new Font("Consolas", Font.BOLD, 22));
        g.drawString(player1Name, 20, 32);
        FontMetrics fm = g.getFontMetrics();
        g.drawString(player2Name, GAME_WIDTH - fm.stringWidth(player2Name) - 20, 32);
    }
}