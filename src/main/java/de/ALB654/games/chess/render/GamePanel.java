package de.ALB654.games.chess.render;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class GamePanel extends JPanel {

    private final ArrayList<RenderObject> renOs = new ArrayList<>();

    {
        Dimension dim = new Dimension(800, 800);

        setSize(dim);
        setPreferredSize(dim);
        setMinimumSize(dim);
    }

    public void addRenderObject(RenderObject renO) {
        renOs.add(renO);

        renOs.sort(Comparator.comparingInt(RenderObject::getId));
    }

    public RenderObject getRenderObject(int id) {
        for(RenderObject renderObject : renOs) {
            if(renderObject.getId() == id)
                return renderObject;
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics gra) {
        super.paintComponent(gra);

        Graphics2D g2d = (Graphics2D) gra;

        for(RenderObject panel : renOs) {
            panel.draw(g2d);

            g2d.translate(panel.getxPos(), panel.getyPos());
            panel.drawLocal(g2d);
            g2d.translate(-panel.getxPos(), -panel.getyPos());
        }
    }
}
