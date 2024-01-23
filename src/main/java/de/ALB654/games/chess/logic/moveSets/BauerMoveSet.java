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
    public ArrayList<LogicBoard.BoardPosition> getPossibleHitMoves(int xPos, int yPos, boolean isBlack, LogicBoard logicBoard) {
        ArrayList<LogicBoard.BoardPosition> positions = new ArrayList<>();

        Vector2i ownPos = new Vector2i(xPos, yPos);

        if(up) {
            Vector2i hit1 = ownPos.add(new Vector2i(-1, -1));
            Vector2i hit2 = ownPos.add(new Vector2i(1, -1));

            if(isPosOnBoard(hit1, logicBoard)) {
                positions.add(logicBoard.createBoardPosition(hit1));
            }

            if(isPosOnBoard(hit2, logicBoard)) {
                positions.add(logicBoard.createBoardPosition(hit2));
            }

        } else {
            Vector2i hit1 = ownPos.add(new Vector2i(-1, 1));
            Vector2i hit2 = ownPos.add(new Vector2i(1, 1));

            if(isPosOnBoard(hit1, logicBoard)) {
                positions.add(logicBoard.createBoardPosition(hit1));
            }

            if(isPosOnBoard(hit2, logicBoard)) {
                positions.add(logicBoard.createBoardPosition(hit2));
            }
        }

        return positions;
    }

    @Override
    public ArrayList<LogicBoard.BoardPosition> getPossibleMoves(int xPos, int yPos, boolean isBlack, LogicBoard logicBoard) {
        ArrayList<LogicBoard.BoardPosition> positions = new ArrayList<>();

        positions.add(logicBoard.createBoardPosition(xPos, yPos, LogicBoard.BoardPosition.RenderMode.OWN_POS));

        Vector2i ownPos = new Vector2i(xPos, yPos);

        if(up) {

            posCheck(ownPos.add(new Vector2i(0, -1)), positions, logicBoard);

            if(yPos == 6)
                posCheck(ownPos.add(new Vector2i(0, -2)), positions, logicBoard);

            hitCheck(ownPos.add(new Vector2i(-1, -1)), positions, isBlack, logicBoard);
            hitCheck(ownPos.add(new Vector2i(1, -1)), positions, isBlack, logicBoard);

        } else {
            posCheck(ownPos.add(new Vector2i(0, 1)), positions, logicBoard);

            if(yPos == 1)
                posCheck(ownPos.add(new Vector2i(0, 2)), positions, logicBoard);

            hitCheck(ownPos.add(new Vector2i(1, 1)), positions, isBlack, logicBoard);
            hitCheck(ownPos.add(new Vector2i(-1, 1)), positions, isBlack, logicBoard);
        }

        return positions;
    }

    private boolean posCheck(Vector2i pos, ArrayList<LogicBoard.BoardPosition> positions, LogicBoard logicBoard) {

        if(!isPosOnBoard(pos, logicBoard))
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

        if(!isPosOnBoard(pos, logicBoard))
            return false;

        LogicFigure figOnPos = logicBoard.getFigureOnPos(pos.getX(), pos.getY());
        if(figOnPos != null) {
            if(isBlack != figOnPos.isBlack()) {
                positions.add(logicBoard.createBoardPosition(pos, LogicBoard.BoardPosition.RenderMode.HIT));
            } else
                positions.add(logicBoard.createBoardPosition(pos, LogicBoard.BoardPosition.RenderMode.FRIENDLY_HIT));

            return true;
        }

        return false;
    }

    private boolean isPosOnBoard(Vector2i pos, LogicBoard logicBoard) {
        if(pos.getY() >= logicBoard.getYSize() || pos.getY() < 0 || pos.getX() >= logicBoard.getXSize() || pos.getX() < 0)
            return false;
        return true;
    }
}
