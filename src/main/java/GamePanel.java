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

public class GamePanel extends JPanel implements Runnable {
    static final int GAME_WIDTH = 1500;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 21;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    static final int WINNING_SCORE = 15;

    Thread gameThread;
    Image image;
    Graphics graphics;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    Random random;

    String player1Name, player2Name;
    Color paddle1Color, paddle2Color;
    GameFrame frame;

    volatile boolean running = true;
    volatile boolean gameOver = false;
    volatile boolean paused = false;

    JButton restartButton;

    GamePanel(String p1, String p2, Color c1, Color c2, GameFrame frame) {
        this.player1Name = p1;
        this.player2Name = p2;
        this.paddle1Color = c1;
        this.paddle2Color = c2;
        this.frame = frame;

        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH, GAME_HEIGHT, p1, p2);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        this.setBackground(new Color(0, 153, 0));
        this.setLayout(null);

        restartButton = new JButton("Reiniciar Juego");
        restartButton.setFont(new Font("Consolas", Font.BOLD, 24));
        restartButton.setBackground(new Color(0, 180, 0));
        restartButton.setForeground(Color.WHITE);
        restartButton.setFocusPainted(false);
        restartButton.setFocusable(false);
        restartButton.setBounds((GAME_WIDTH / 2) - 130, (GAME_HEIGHT / 2) + 30, 260, 50);
        restartButton.setVisible(false);
        restartButton.addActionListener(e -> {
            running = false;
            frame.startNewGame();
        });
        this.add(restartButton);

        gameThread = new Thread(this);
        gameThread.start();
    }

    private void togglePause() {
        if (gameOver) return;
        paused = !paused;
        if (paused) {
            paddle1.setYDirection(0);
            paddle2.setYDirection(0);
        }
        repaint();
    }

    public void newBall() {
        random = new Random();
        ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2),
                        random.nextInt(GAME_HEIGHT - BALL_DIAMETER),
                        BALL_DIAMETER, BALL_DIAMETER);
    }

    public void newPaddles() {
        paddle1 = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2),
                             PADDLE_WIDTH, PADDLE_HEIGHT, 1, paddle1Color);
        paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH,
                             (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2),
                             PADDLE_WIDTH, PADDLE_HEIGHT, 2, paddle2Color);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);

        if (!gameOver) {
            g.setColor(new Color(255, 255, 255, 180));
            g.setFont(new Font("Consolas", Font.BOLD, 20));
            String hint = paused
                ? "PAUSA - Presiona ESPACIO para reanudar"
                : "Presiona ESPACIO para pausar";
            FontMetrics fm = g.getFontMetrics();
            g.drawString(hint, 20, GAME_HEIGHT - 20 - fm.getDescent());
        }

        if (paused && !gameOver) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(0, 0, 0, 120));
            g2d.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.YELLOW);
            g.setFont(new Font("Consolas", Font.BOLD, 72));
            String text = "PAUSA";
            FontMetrics fm = g.getFontMetrics();
            g.drawString(text, (GAME_WIDTH - fm.stringWidth(text)) / 2, GAME_HEIGHT / 2 - 20);
        }

        if (gameOver) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(0, 0, 0, 150));
            g2d.fillRect(0, 0, getWidth(), getHeight());

            String winner = (score.player1 >= WINNING_SCORE) ? player1Name : player2Name;
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Consolas", Font.BOLD, 48));
            String text = "¡" + winner + " Gana!";
            FontMetrics fm = g.getFontMetrics();
            g.drawString(text, (GAME_WIDTH - fm.stringWidth(text)) / 2, (GAME_HEIGHT / 2) - 20);
        }
    }

    public void draw(Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }

    public void checkCollision() {
        if (gameOver) return;

        if (ball.y <= 0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if (ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }

        if (ball.intersects(paddle1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if (ball.yVelocity > 0)
                ball.yVelocity++;
            else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        if (ball.intersects(paddle2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            ball.xVelocity = -ball.xVelocity;
            if (ball.yVelocity > 0)
                ball.yVelocity++;
            else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        if (paddle1.y <= 0)
            paddle1.y = 0;
        if (paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
        if (paddle2.y <= 0)
            paddle2.y = 0;
        if (paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;

        if (ball.x <= 0) {
            score.player2++;
            System.out.println(player2Name + ": " + score.player2);
            if (score.player2 >= WINNING_SCORE) {
                endGame();
            } else {
                newPaddles();
                newBall();
            }
        }

        if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.player1++;
            System.out.println(player1Name + ": " + score.player1);
            if (score.player1 >= WINNING_SCORE) {
                endGame();
            } else {
                newPaddles();
                newBall();
            }
        }
    }

    private void endGame() {
        gameOver = true;
        running = false;
        SwingUtilities.invokeLater(() -> {
            restartButton.setVisible(true);  
        });
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                if (!gameOver && !paused) {  
                    move();
                    checkCollision();
                }
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {       
            if (e.getKeyCode() == KeyEvent.VK_SPACE && !gameOver) {
                togglePause();
                return;
            }
            if (gameOver || paused) return;
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}