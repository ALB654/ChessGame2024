package de.ALB654.games.chess.logic;

import de.ALB654.games.chess.FigureType;

import java.util.ArrayList;

public class LogicFigure {

    private final int id;

    private final FigureType figureType;

    private final boolean isBlack;

    private final MoveSet moveSet;

    private LogicBoard logicBoard;

    public LogicFigure(int id, FigureType figureType, boolean isBlack, MoveSet moveSet) {
        this.id = id;
        this.figureType = figureType;
        this.isBlack = isBlack;
        this.moveSet = moveSet;
    }

    public ArrayList<LogicBoard.BoardPosition> getPossibleMoves(int x, int y) {
        if(logicBoard != null)
            return moveSet.getPossibleMoves(x, y, isBlack, logicBoard);
        return null;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public int getId() {
        return id;
    }

    public void setLogicBoard(LogicBoard logicBoard) {
        this.logicBoard = logicBoard;
    }
}
