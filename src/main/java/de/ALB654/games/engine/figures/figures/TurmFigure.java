package de.ALB654.games.engine.figures.figures;

import de.ALB654.games.engine.SpriteManager;
import de.ALB654.games.engine.figures.ChessFigure;

import java.awt.*;
import java.util.ArrayList;

public class TurmFigure extends ChessFigure {

    public TurmFigure(int xPos, int yPos, boolean isBlack, SpriteManager spriteManager) {
        super(xPos, yPos, spriteManager, Type.TURM, isBlack);
    }

    @Override
    public ArrayList<ChessMove> getPossibleMoves(ChessFigure[][] field, int xPositionOnField, int yPositionOnField) {
        ArrayList<ChessMove> moves = new ArrayList<>();

        for(int x = xPositionOnField; x >= 0; x--) {
            if(field[x][yPositionOnField] != null) {
                ChessFigure figure = field[x][yPositionOnField];
                if(figure.isBlack() != isBlack()) {
                    moves.add(new ChessMove(x, yPositionOnField, true));
                }
                break;
            } else {
                moves.add(new ChessMove(x, yPositionOnField, false));
            }
        }

        for(int x = xPositionOnField; x < field.length; x++) {
            if(field[x][yPositionOnField] != null) {
                ChessFigure figure = field[x][yPositionOnField];
                if(figure.isBlack() != isBlack()) {
                    moves.add(new ChessMove(x, yPositionOnField, true));
                }
                break;
            } else {
                moves.add(new ChessMove(x, yPositionOnField, false));
            }
        }

        for(int y = yPositionOnField; y >= 0; y--) {
            if(field[xPositionOnField][y] != null) {
                ChessFigure figure = field[xPositionOnField][y];
                if(figure.isBlack() != isBlack()) {
                    moves.add(new ChessMove(xPositionOnField, y, true));
                }
                break;
            } else {
                moves.add(new ChessMove(xPositionOnField, y, false));
            }
        }

        for(int y = yPositionOnField; y < field[0].length; y++) {
            if(field[xPositionOnField][y] != null) {
                ChessFigure figure = field[xPositionOnField][y];
                if(figure.isBlack() != isBlack()) {
                    moves.add(new ChessMove(xPositionOnField, y, true));
                }
                break;
            } else {
                moves.add(new ChessMove(xPositionOnField, y, false));
            }
        }

        return moves;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getSpriteManager().getSprite(getType(), isBlack()).getImage(), getxPos(), getyPos(), null);
    }
}
