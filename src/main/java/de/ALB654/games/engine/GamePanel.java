package de.ALB654.games.engine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    ArrayList<ObjectPanel> panels = new ArrayList<>();

    {
        panels.add(new ChessBoard(8, 8, 800, 800, 100, 100));

        Dimension dim = new Dimension(800, 800);

        setSize(dim);
        setPreferredSize(dim);
        setMinimumSize(dim);
    }

    @Override
    protected void paintComponent(Graphics gra) {
        super.paintComponent(gra);

        Graphics2D g2d = (Graphics2D) gra;

        for(ObjectPanel panel : panels) {
            g2d.translate(panel.getxPos(), panel.getyPos());
            panel.draw(g2d);
            g2d.translate(-panel.getxPos(), -panel.getyPos());
        }
    }

}
