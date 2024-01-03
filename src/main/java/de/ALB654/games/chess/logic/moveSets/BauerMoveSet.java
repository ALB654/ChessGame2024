package de.ALB654.games.chess.logic.moveSets;

import de.ALB654.games.chess.logic.LogicBoard;
import de.ALB654.games.chess.logic.LogicFigure;
import de.ALB654.games.chess.logic.MoveSet;
import de.ALB654.games.chess.utils.Vector2i;

import java.util.ArrayList;

public class BauerMoveSet implements MoveSet {

    private final boolean up;

    public BauerMoveSet(boolean up) {
        this.up = up;
    }

    @Override
    public ArrayList<LogicBoard.BoardPosition> getPossibleMoves(int xPos, int yPos, boolean isBlack, LogicBoard logicBoard) {
        ArrayList<LogicBoard.BoardPosition> positions = new ArrayList<>();

        positions.add(logicBoard.createBoardPosition(xPos, yPos, LogicBoard.BoardPosition.RenderMode.OWN_POS));

        Vector2i ownPos = new Vector2i(xPos, yPos);

        if(up) {

            posCheck(ownPos.add(new Vector2i(0, -1)), positions, isBlack, logicBoard);

            if(yPos == 6)
                posCheck(ownPos.add(new Vector2i(0, -2)), positions, isBlack, logicBoard);

            hitCheck(ownPos.add(new Vector2i(-1, -1)), positions, isBlack, logicBoard);
            hitCheck(ownPos.add(new Vector2i(1, -1)), positions, isBlack, logicBoard);

        } else {
            posCheck(ownPos.add(new Vector2i(0, 1)), positions, isBlack, logicBoard);

            if(yPos == 1)
                posCheck(ownPos.add(new Vector2i(0, 2)), positions, isBlack, logicBoard);

            hitCheck(ownPos.add(new Vector2i(1, 1)), positions, isBlack, logicBoard);
            hitCheck(ownPos.add(new Vector2i(-1, 1)), positions, isBlack, logicBoard);
        }

        return positions;
    }

    private boolean posCheck(Vector2i pos, ArrayList<LogicBoard.BoardPosition> positions, boolean isBlack, LogicBoard logicBoard) {

        if(pos.getY() >= logicBoard.getYSize() || pos.getY() < 0 || pos.getX() >= logicBoard.getXSize() || pos.getX() < 0)
            return false;

        LogicFigure figOnPos = logicBoard.getFigureOnPos(pos.getX(), pos.getY());
        if(figOnPos != null) {
            return true;
        } else {
            positions.add(logicBoard.createBoardPosition(pos));
        }

        return false;
    }

    private boolean hitCheck(Vector2i pos, ArrayList<LogicBoard.BoardPosition> positions, boolean isBlack, LogicBoard logicBoard) {

        if(pos.getY() >= logicBoard.getYSize() || pos.getY() < 0 || pos.getX() >= logicBoard.getXSize() || pos.getX() < 0)
            return false;

        LogicFigure figOnPos = logicBoard.getFigureOnPos(pos.getX(), pos.getY());
        if(figOnPos != null) {
            if(isBlack != figOnPos.isBlack()) {
                positions.add(logicBoard.createBoardPosition(pos, LogicBoard.BoardPosition.RenderMode.HIT));
            }
            return true;
        }

        return false;
    }
}
