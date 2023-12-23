package de.ALB654.games.engine;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private final int xWidth;
    private final int yWidth;

    public Window(int xWidth, int yWidth) {
        this.xWidth = xWidth;
        this.yWidth = yWidth;

        add(new GamePanel());

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
