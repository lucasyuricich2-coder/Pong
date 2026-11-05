/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sala 2 - 7
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginDialog extends JDialog {
    private JTextField player1Field;
    private JTextField player2Field;
    private String player1Name;
    private String player2Name;
    private boolean confirmed = false;

    private Color player1Color;
    private Color player2Color;

    private final Color[] basicColors = {
        Color.BLUE, Color.RED, Color.YELLOW, Color.ORANGE,
        Color.CYAN, Color.MAGENTA, Color.PINK, Color.WHITE
    };
    private final String[] colorNames = {
        "Azul", "Rojo", "Amarillo", "Naranja",
        "Cian", "Magenta", "Rosa", "Blanco"
    };

    public LoginDialog(JFrame parent) {
        super(parent, "Login - Pong Game", true);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0, 0, 0));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        JLabel title = new JLabel("PONG GAME");
        title.setFont(new Font("Consolas", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(title, gbc);

        JLabel l1 = new JLabel("Jugador 1:");
        l1.setFont(new Font("Consolas", Font.BOLD, 25));
        l1.setForeground(Color.WHITE);
        gbc.gridwidth = 1; gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(l1, gbc);

        player1Field = new JTextField(15);
        player1Field.setFont(new Font("Consolas", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(player1Field, gbc);

        JLabel l2 = new JLabel("Jugador 2:");
        l2.setFont(new Font("Consolas", Font.BOLD, 25));
        l2.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(l2, gbc);

        player2Field = new JTextField(15);
        player2Field.setFont(new Font("Consolas", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(player2Field, gbc);

        JLabel lc1 = new JLabel("Color J1:");
        lc1.setFont(new Font("Consolas", Font.BOLD, 20));
        lc1.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(lc1, gbc);

        JComboBox<String> colorBox1 = new JComboBox<>(colorNames);
        colorBox1.setSelectedIndex(0);
        colorBox1.setFont(new Font("Consolas", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(colorBox1, gbc);

        JLabel lc2 = new JLabel("Color J2:");
        lc2.setFont(new Font("Consolas", Font.BOLD, 20));
        lc2.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(lc2, gbc);

        JComboBox<String> colorBox2 = new JComboBox<>(colorNames);
        colorBox2.setSelectedIndex(1);
        colorBox2.setFont(new Font("Consolas", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(colorBox2, gbc);
 
        JButton startBtn = new JButton("Iniciar Juego");
        startBtn.setFont(new Font("Consolas", Font.BOLD, 16));
        startBtn.setBackground(new Color(0, 180, 0));
        startBtn.setForeground(Color.WHITE);
        startBtn.setFocusPainted(false);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(startBtn, gbc);

        startBtn.addActionListener(e -> {
            String p1 = player1Field.getText().trim();
            String p2 = player2Field.getText().trim();

            if (p1.isEmpty() || p2.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Por favor ingrese los nombres de ambos jugadores.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (p1.equals(p2)) {
                JOptionPane.showMessageDialog(this,
                    "Los nombres deben ser diferentes.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            player1Name = p1;
            player2Name = p2;
            player1Color = basicColors[colorBox1.getSelectedIndex()];
            player2Color = basicColors[colorBox2.getSelectedIndex()];
            confirmed = true;
            dispose();
        });

        getRootPane().setDefaultButton(startBtn);

        add(panel);
        setSize(450, 420);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                player1Field.requestFocusInWindow();
            }
        });
    }

    public boolean isConfirmed() { return confirmed; }
    public String getPlayer1Name() { return player1Name; }
    public String getPlayer2Name() { return player2Name; }
    public Color getPlayer1Color() { return player1Color; }
    public Color getPlayer2Color() { return player2Color; }
}