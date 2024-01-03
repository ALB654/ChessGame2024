package de.ALB654.games.chess.render.renderObjects;

import de.ALB654.games.chess.FigureType;
import de.ALB654.games.chess.render.RenderObject;
import de.ALB654.games.chess.render.animation.Moveable;
import de.ALB654.games.chess.render.sprite.Sprite;

import java.awt.*;

public class FigurRenO extends RenderObject implements Moveable {

    private Sprite sprite;
    private boolean isBlack;
    private FigureType type;

    private int logicFigureId;

    public FigurRenO(int id, Sprite sprite, int xPos, int yPos, boolean isBlack, FigureType type, int logicFigureId) {
        super(id, sprite.getWidth(), sprite.getHeight(), xPos, yPos);
        this.isBlack = isBlack;
        this.type = type;
        this.sprite = sprite;
        this.logicFigureId = logicFigureId;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(sprite.getImage(), getxPos(), getyPos(), null);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    }

    @Override
    public void drawLocal(Graphics2D g2d) {

    }

    public boolean isBlack() {
        return isBlack;
    }

    public FigureType getType() {
        return type;
    }

    public int getLogicFigureId() {
        return logicFigureId;
    }

    @Override
    public void moveToPosition(int x, int y) {
        setxPos(x);
        setyPos(y);
    }
}
