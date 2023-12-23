package de.ALB654.games.engine;

import java.awt.*;

public abstract class ObjectPanel {

    private final int width;
    private final int height;

    private int xPos;
    private int yPos;

    protected ObjectPanel(int width, int height, int xPos, int yPos) {
        this.width = width;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public abstract void draw(Graphics2D g2d);

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
