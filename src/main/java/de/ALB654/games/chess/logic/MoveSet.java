package de.ALB654.games.chess.logic;

import java.util.ArrayList;

public interface MoveSet {

    ArrayList<LogicBoard.BoardPosition> getPossibleMoves(int xPos, int yPos, boolean isBlack, LogicBoard logicBoard);

}
