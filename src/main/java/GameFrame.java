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

public class GameFrame extends JFrame {
    GamePanel panel;
    String player1Name, player2Name;

    GameFrame() {
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(new Color(0, 153, 0));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        startNewGame();
    }

    public void startNewGame() {
        LoginDialog login = new LoginDialog(this);
        login.setVisible(true);

        if (!login.isConfirmed()) {
            System.exit(0);
            return;
        }

        player1Name = login.getPlayer1Name();
        player2Name = login.getPlayer2Name();
        Color c1 = login.getPlayer1Color();
        Color c2 = login.getPlayer2Color();

        if (panel != null) {
            this.remove(panel);
        }

        panel = new GamePanel(player1Name, player2Name, c1, c2, this);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        panel.requestFocusInWindow();
    }
}