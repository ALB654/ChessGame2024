package de.ALB654.games.chess.render;

import java.awt.*;

public abstract class RenderObject {

    private final int id;

    private final int width;
    private final int height;

    private int xPos;
    private int yPos;

    boolean changed;

    protected RenderObject(int id, int width, int height, int xPos, int yPos) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;

        this.changed = false;
    }

    public abstract void draw(Graphics2D g2d);
    public abstract void drawLocal(Graphics2D g2d);

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
        this.changed = true;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
        this.changed = true;
    }

    public int getId() {
        return id;
    }

    public boolean hasChanged() {
        return changed;
    }

    public void changedRecognized() {
        this.changed = false;
    }
}
