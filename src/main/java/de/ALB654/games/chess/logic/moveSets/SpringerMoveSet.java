package de.ALB654.games.chess.logic.moveSets;

import de.ALB654.games.chess.logic.LogicBoard;
import de.ALB654.games.chess.logic.LogicFigure;
import de.ALB654.games.chess.logic.MoveSet;
import de.ALB654.games.chess.utils.Vector2i;

import java.util.ArrayList;

public class SpringerMoveSet implements MoveSet {

    @Override
    public ArrayList<LogicBoard.BoardPosition> getPossibleHitMoves(int xPos, int yPos, boolean isBlack, LogicBoard logicBoard) {
        return getPossibleMoves(xPos, yPos, isBlack, logicBoard);
    }

    @Override
    public ArrayList<LogicBoard.BoardPosition> getPossibleMoves(int xPos, int yPos, boolean isBlack, LogicBoard logicBoard) {
        ArrayList<LogicBoard.BoardPosition> positions = new ArrayList<>();

        positions.add(logicBoard.createBoardPosition(xPos, yPos, LogicBoard.BoardPosition.RenderMode.OWN_POS));

        Vector2i ownPos = new Vector2i(xPos, yPos);


        posCheck(ownPos.add(new Vector2i(-1, -2)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(1, -2)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(-1, 2)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(1, 2)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(-2, -1)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(-2, 1)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(2, -1)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(2, 1)), positions, isBlack, logicBoard);

        return positions;
    }

    private boolean posCheck(Vector2i pos, ArrayList<LogicBoard.BoardPosition> positions, boolean isBlack, LogicBoard logicBoard) {

        if(pos.getY() >= logicBoard.getYSize() || pos.getY() < 0 || pos.getX() >= logicBoard.getXSize() || pos.getX() < 0)
            return false;

        LogicFigure figOnPos = logicBoard.getFigureOnPos(pos.getX(), pos.getY());
        if(figOnPos != null) {
            if(isBlack != figOnPos.isBlack())
                positions.add(logicBoard.createBoardPosition(pos, LogicBoard.BoardPosition.RenderMode.HIT));
            else
                positions.add(logicBoard.createBoardPosition(pos, LogicBoard.BoardPosition.RenderMode.FRIENDLY_HIT));

            return true;
        } else {
            positions.add(logicBoard.createBoardPosition(pos));
        }

        return false;
    }
}
