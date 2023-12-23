package de.ALB654.games.chess.render;

import de.ALB654.games.chess.logic.LogicBoard;
import de.ALB654.games.chess.logic.LogicFigure;
import de.ALB654.games.chess.render.renderObjects.ChessboardRenO;
import de.ALB654.games.chess.render.renderObjects.FigurRenO;
import de.ALB654.games.chess.render.sprite.SpriteManager;

import java.util.ArrayList;

public class FigureRenderManager {

    private final ArrayList<FigurRenO> figureRenOs = new ArrayList<>();
    private final SpriteManager spriteManager;

    private final ChessboardRenO chessboardRenO;

    public FigureRenderManager(SpriteManager spriteManager, LogicBoard logicBoard, ChessboardRenO chessboardRenO) {
        this.spriteManager = spriteManager;
        this.chessboardRenO = chessboardRenO;

        loadFigureRenderObjects(logicBoard);
    }

    private void loadFigureRenderObjects(LogicBoard logicBoard) {
        int renOId = 1;
        for(int x = 0; x < logicBoard.getXSize(); x++) {
            for(int y = 0; y < logicBoard.getYSize(); y++) {
                LogicFigure figure = logicBoard.getFigureOnPos(x, y);

                if(figure != null) {
                    int[] pos = chessboardRenO.getPositionFromTile(x, y);
                    figureRenOs.add(new FigurRenO(renOId++, spriteManager.getSprite(figure.getFigureType(), figure.isBlack()), pos[0], pos[1], figure.isBlack(), figure.getFigureType(), figure.getId()));
                }
            }
        }
    }

    public FigurRenO getFigureRenO(int id) {
        for(FigurRenO figurRenO : figureRenOs) {
            if(figurRenO.getId() == id)
                return figurRenO;
        }
        return null;
    }

    public ArrayList<FigurRenO> getFigureRenOs() {
        return figureRenOs;
    }
}
