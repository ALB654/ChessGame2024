package de.ALB654.games.chess.logic.moveSets;

import de.ALB654.games.chess.logic.LogicBoard;
import de.ALB654.games.chess.logic.LogicFigure;
import de.ALB654.games.chess.logic.MoveSet;
import de.ALB654.games.chess.utils.Vector2i;

import java.util.ArrayList;

public class KoenigMoveSet implements MoveSet {
    @Override
    public ArrayList<LogicBoard.BoardPosition> getPossibleMoves(int xPos, int yPos, boolean isBlack, LogicBoard logicBoard) {
        ArrayList<LogicBoard.BoardPosition> positions = new ArrayList<>();

        Vector2i ownPos = new Vector2i(xPos, yPos);

        posCheck(ownPos.add(new Vector2i(1, 0)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(1, 1)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(1, -1)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(-1, 0)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(-1, 1)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(-1, -1)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(0, 1)), positions, isBlack, logicBoard);
        posCheck(ownPos.add(new Vector2i(0, -1)), positions, isBlack, logicBoard);

        ArrayList<LogicBoard.BoardPosition> movesFromOther = new ArrayList<>();

        for(int x = 0; x < logicBoard.getXSize(); x++) {
            for(int y = 0; y < logicBoard.getYSize(); y++) {
                LogicFigure logicFigure = logicBoard.getFigureOnPos(x, y);
                if(logicFigure != null && logicFigure.isBlack() != isBlack) {
                    ArrayList<LogicBoard.BoardPosition> moves = logicFigure.getPossibleMoves(x, y);
                    moves.forEach(m -> {
                        if(m.renderMode() == LogicBoard.BoardPosition.RenderMode.NORMAL_MOVE)
                            movesFromOther.add(m);
                    });
                }
            }
        }

        ArrayList<LogicBoard.BoardPosition> notPossiblePositions = new ArrayList<>();

        positions.forEach(p -> {
            movesFromOther.forEach(o -> {
                if(p.isOnlyPosEqual(o))
                    notPossiblePositions.add(p);
            });
        });

        positions.removeAll(notPossiblePositions);

        return positions;
    }

    private boolean posCheck(Vector2i pos, ArrayList<LogicBoard.BoardPosition> positions, boolean isBlack, LogicBoard logicBoard) {

        if(pos.getY() >= logicBoard.getYSize() || pos.getY() < 0 || pos.getX() >= logicBoard.getXSize() || pos.getX() < 0)
            return false;

        LogicFigure figOnPos = logicBoard.getFigureOnPos(pos.getX(), pos.getY());
        if(figOnPos != null) {
            if(isBlack != figOnPos.isBlack())
                positions.add(logicBoard.createBoardPosition(pos, LogicBoard.BoardPosition.RenderMode.HIT));

            return true;
        } else {
            positions.add(logicBoard.createBoardPosition(pos));
        }

        return false;
    }
}
