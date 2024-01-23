package de.ALB654.games.chess;


import de.ALB654.games.chess.input.MouseInputManager;
import de.ALB654.games.chess.logic.LogicBoard;
import de.ALB654.games.chess.logic.LogicFigure;
import de.ALB654.games.chess.logic.moveSets.*;
import de.ALB654.games.chess.render.FigureRenderManager;
import de.ALB654.games.chess.render.GamePanel;
import de.ALB654.games.chess.render.Window;
import de.ALB654.games.chess.render.animation.AnimationManager;
import de.ALB654.games.chess.render.renderObjects.ChessboardRenO;
import de.ALB654.games.chess.render.sprite.SpriteManager;

import java.awt.*;

public class Chess {

    private final GamePanel panel;
    private final SpriteManager spriteManager;
    private final FigureRenderManager figureRenderManager;
    private final LogicBoard logicBoard;
    private final AnimationManager animationManager;

    public Chess() {
        logicBoard = new LogicBoard(8, 8);
        setFigures();

        spriteManager = new SpriteManager(100, 100);
        animationManager = new AnimationManager();

        ChessboardRenO chessboardRenO = new ChessboardRenO(0, 8, 8 , 800, 800, 50, 50);

        this.figureRenderManager = new FigureRenderManager(spriteManager, logicBoard, chessboardRenO);
        panel = new GamePanel(new MouseInputManager(logicBoard, chessboardRenO, figureRenderManager, animationManager));

        animationManager.setGamePanel(panel);

        panel.addRenderObject(chessboardRenO);
        figureRenderManager.getFigureRenOs().forEach(panel::addRenderObject);
    }

    private void setFigures() {

        logicBoard.addFigure(new LogicFigure(0, FigureType.BAUER, true, new BauerMoveSet(false)), logicBoard.createBoardPosition(0, 1));
        logicBoard.addFigure(new LogicFigure(1, FigureType.BAUER, true, new BauerMoveSet(false)), logicBoard.createBoardPosition(1, 1));
        logicBoard.addFigure(new LogicFigure(2, FigureType.BAUER, true, new BauerMoveSet(false)), logicBoard.createBoardPosition(2, 1));
        logicBoard.addFigure(new LogicFigure(3, FigureType.BAUER, true, new BauerMoveSet(false)), logicBoard.createBoardPosition(3, 1));
        logicBoard.addFigure(new LogicFigure(4, FigureType.BAUER, true, new BauerMoveSet(false)), logicBoard.createBoardPosition(4, 1));
        logicBoard.addFigure(new LogicFigure(5, FigureType.BAUER, true, new BauerMoveSet(false)), logicBoard.createBoardPosition(5, 1));
        logicBoard.addFigure(new LogicFigure(6, FigureType.BAUER, true, new BauerMoveSet(false)), logicBoard.createBoardPosition(6, 1));
        logicBoard.addFigure(new LogicFigure(7, FigureType.BAUER, true, new BauerMoveSet(false)), logicBoard.createBoardPosition(7, 1));

        logicBoard.addFigure(new LogicFigure(8, FigureType.BAUER, false, new BauerMoveSet(true)), logicBoard.createBoardPosition(0, 6));
        logicBoard.addFigure(new LogicFigure(9, FigureType.BAUER, false, new BauerMoveSet(true)), logicBoard.createBoardPosition(1, 6));
        logicBoard.addFigure(new LogicFigure(10, FigureType.BAUER, false, new BauerMoveSet(true)), logicBoard.createBoardPosition(2, 6));
        logicBoard.addFigure(new LogicFigure(11, FigureType.BAUER, false, new BauerMoveSet(true)), logicBoard.createBoardPosition(3, 6));
        logicBoard.addFigure(new LogicFigure(12, FigureType.BAUER, false, new BauerMoveSet(true)), logicBoard.createBoardPosition(4, 6));
        logicBoard.addFigure(new LogicFigure(13, FigureType.BAUER, false, new BauerMoveSet(true)), logicBoard.createBoardPosition(5, 6));
        logicBoard.addFigure(new LogicFigure(14, FigureType.BAUER, false, new BauerMoveSet(true)), logicBoard.createBoardPosition(6, 6));
        logicBoard.addFigure(new LogicFigure(15, FigureType.BAUER, false, new BauerMoveSet(true)), logicBoard.createBoardPosition(7, 6));

        logicBoard.addFigure(new LogicFigure(16, FigureType.KOENIG, false, new KoenigMoveSet()), logicBoard.createBoardPosition(4, 4));
        logicBoard.addFigure(new LogicFigure(17, FigureType.TURM, true, new TurmMoveSet()), logicBoard.createBoardPosition(3, 4));

    }

    public void openGame() {
        System.out.println("Yeah nices Game! Starte...");

        EventQueue.invokeLater(() -> {
            Window w = new Window(1000, 1000, panel);
            w.setVisible(true);
        });
    }

}
