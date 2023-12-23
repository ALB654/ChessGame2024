package de.ALB654.games.engine.figures;

import de.ALB654.games.engine.ObjectPanel;
import de.ALB654.games.engine.SpriteManager;

import java.util.ArrayList;

public abstract class ChessFigure extends ObjectPanel {

    public enum Type {
        BAUER,
        TURM,
        PFERD,
        LAUFER,
        DAME,
        KOENIG
    }

    private SpriteManager spriteManager;
    private Type type;
    private boolean isBlack;

    public ChessFigure(int xPos, int yPos, SpriteManager spriteManager, Type type, boolean isBlack) {
        super(0, 0, xPos, yPos);
        this.spriteManager = spriteManager;
        this.type = type;
        this.isBlack = isBlack;
    }

    protected SpriteManager getSpriteManager() {
        return spriteManager;
    }

    public Type getType() {
        return type;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public abstract ArrayList<ChessMove> getPossibleMoves(ChessFigure[][] field, int xPositionOnField, int yPositionOnField);

    public record ChessMove(int x, int y, boolean isHit) {};
}
