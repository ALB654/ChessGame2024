package de.ALB654.games.chess.logic.moveSets;

import de.ALB654.games.chess.logic.LogicBoard;
import de.ALB654.games.chess.logic.LogicFigure;
import de.ALB654.games.chess.logic.MoveSet;
import de.ALB654.games.chess.utils.Vector2i;

import java.util.ArrayList;

public class LaeuferMoveSet implements MoveSet {
    @Override
    public ArrayList<LogicBoard.BoardPosition> getPossibleMoves(int xPos, int yPos, boolean isBlack, LogicBoard logicBoard) {
        ArrayList<LogicBoard.BoardPosition> positions = new ArrayList<>();

        positions.add(logicBoard.createBoardPosition(xPos, yPos, LogicBoard.BoardPosition.RenderMode.OWN_POS));

        for(Vector2i no = new Vector2i(xPos + 1, yPos - 1); (no.getX() < logicBoard.getXSize() && no.getY() >= 0) ; no.addOwn(new Vector2i(1, -1))) {
            if(rayCheck(no.getX(), no.getY(), positions, isBlack, logicBoard))
                break;
        }

        for(Vector2i nw = new Vector2i(xPos - 1, yPos - 1); (nw.getX() >= 0 && nw.getY() >= 0) ; nw.addOwn(new Vector2i(-1, -1))) {
            if(rayCheck(nw.getX(), nw.getY(), positions, isBlack, logicBoard))
                break;
        }

        for(Vector2i so = new Vector2i(xPos + 1, yPos + 1); (so.getX() < logicBoard.getXSize() && so.getY() < logicBoard.getYSize()) ; so.addOwn(new Vector2i(1, 1))) {
            if(rayCheck(so.getX(), so.getY(), positions, isBlack, logicBoard))
                break;
        }

        for(Vector2i sw = new Vector2i(xPos - 1, yPos + 1); (sw.getX() >= 0 && sw.getY() < logicBoard.getYSize()) ; sw.addOwn(new Vector2i(-1, 1))) {
            if(rayCheck(sw.getX(), sw.getY(), positions, isBlack, logicBoard))
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
