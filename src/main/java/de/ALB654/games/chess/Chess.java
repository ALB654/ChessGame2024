package de.ALB654.games.chess;


import de.ALB654.games.chess.logic.LogicBoard;
import de.ALB654.games.chess.logic.LogicFigure;
import de.ALB654.games.chess.logic.moveSets.TurmMoveSet;
import de.ALB654.games.chess.render.FigureRenderManager;
import de.ALB654.games.chess.render.GamePanel;
import de.ALB654.games.chess.render.Window;
import de.ALB654.games.chess.render.renderObjects.ChessboardRenO;
import de.ALB654.games.chess.render.sprite.SpriteManager;

import java.awt.*;

public class Chess {

    private final GamePanel panel;
    private final SpriteManager spriteManager;
    private final FigureRenderManager figureRenderManager;
    private final LogicBoard logicBoard;

    public Chess() {
        logicBoard = new LogicBoard(8, 8);
        setFigures();

        spriteManager = new SpriteManager(100, 100);

        ChessboardRenO chessboardRenO = new ChessboardRenO(0, 8, 8 , 800, 800, 50, 50);

        this.figureRenderManager = new FigureRenderManager(spriteManager, logicBoard, chessboardRenO);
        panel = new GamePanel();

        panel.addRenderObject(chessboardRenO);
        figureRenderManager.getFigureRenOs().forEach(panel::addRenderObject);
    }

    private void setFigures() {
        logicBoard.addFigure(new LogicFigure(0, FigureType.TURM, true, new TurmMoveSet()), logicBoard.createBoardPosition(0, 0));
    }

    public void openGame() {
        System.out.println("Yeah nices Game! Starte...");

        EventQueue.invokeLater(() -> {
            Window w = new Window(1000, 1000, panel);
            w.setVisible(true);
        });
    }

}
