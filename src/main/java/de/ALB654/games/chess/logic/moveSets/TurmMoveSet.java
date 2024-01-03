package de.ALB654.games.chess.logic.moveSets;

import de.ALB654.games.chess.logic.LogicBoard;
import de.ALB654.games.chess.logic.LogicFigure;
import de.ALB654.games.chess.logic.MoveSet;

import java.util.ArrayList;

public class TurmMoveSet implements MoveSet {


    @Override
    public ArrayList<LogicBoard.BoardPosition> getPossibleMoves(int xPos, int yPos, boolean isBlack, LogicBoard logicBoard) {

        ArrayList<LogicBoard.BoardPosition> positions = new ArrayList<>();

        positions.add(logicBoard.createBoardPosition(xPos, yPos, LogicBoard.BoardPosition.RenderMode.OWN_POS));

        for(int x = xPos - 1; x >= 0; x--) {
            if(rayCheck(x, yPos, positions, isBlack, logicBoard))
                break;
        }

        for(int x = xPos + 1; x < logicBoard.getXSize(); x++) {
            if(rayCheck(x, yPos, positions, isBlack, logicBoard))
                break;
        }

        for(int y = yPos - 1; y >= 0; y--) {
            if(rayCheck(xPos, y, positions, isBlack, logicBoard))
                break;
        }

        for(int y = yPos + 1; y < logicBoard.getYSize(); y++) {
            if(rayCheck(xPos, y, positions, isBlack, logicBoard))
                break;
        }

        return positions;
    }

    private boolean rayCheck(int x, int y, ArrayList<LogicBoard.BoardPosition> positions, boolean isBlack, LogicBoard logicBoard) {
        LogicFigure figOnPos = logicBoard.getFigureOnPos(x, y);
        if(figOnPos != null) {
            if(isBlack != figOnPos.isBlack())
                positions.add(logicBoard.createBoardPosition(x, y, LogicBoard.BoardPosition.RenderMode.HIT));

            return true;
        } else {
            positions.add(logicBoard.createBoardPosition(x, y));
        }

        return false;
    }
}
