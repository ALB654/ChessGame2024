package de.ALB654.games.chess.render;


import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private final int xWidth;
    private final int yWidth;

    public Window(int xWidth, int yWidth, GamePanel panel) {
        this.xWidth = xWidth;
        this.yWidth = yWidth;

        add(panel);

        initUI();
    }

    private void initUI() {
        Dimension dim = new Dimension(xWidth, yWidth);

        setMinimumSize(dim);
        setTitle("Chess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        pack();
    }

}
