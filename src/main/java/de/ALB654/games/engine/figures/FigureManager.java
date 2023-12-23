package de.ALB654.games.engine.figures;

import de.ALB654.games.engine.ChessBoard;
import de.ALB654.games.engine.SpriteManager;
import de.ALB654.games.engine.figures.figures.TurmFigure;

public class FigureManager {

    private final SpriteManager spriteManager;
    private final ChessBoard chessBoard;
    private final ChessFigure[][] figureField;

    public FigureManager(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        this.spriteManager = new SpriteManager(chessBoard.getxTileSize(), chessBoard.getyTileSize());
        this.figureField = new ChessFigure[chessBoard.getxTileAmount()][chessBoard.getyTileAmount()];

        fillFigureField();
    }

    private void fillFigureField() {
        figureField[0][0] = new TurmFigure(chessBoard.getPositionFromTile("A1")[0], chessBoard.getPositionFromTile("A1")[1], true, spriteManager);
    }
}
