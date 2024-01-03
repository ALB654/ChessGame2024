package de.ALB654.games.chess.input;

import de.ALB654.games.chess.logic.LogicBoard;
import de.ALB654.games.chess.logic.LogicFigure;
import de.ALB654.games.chess.render.FigureRenderManager;
import de.ALB654.games.chess.render.GamePanel;
import de.ALB654.games.chess.render.animation.AnimationManager;
import de.ALB654.games.chess.render.animation.animation.LinearAnimation;
import de.ALB654.games.chess.render.animation.animationTimes.EaseInOutAnimationTime;
import de.ALB654.games.chess.render.animation.animationTimes.LinearAnimationTime;
import de.ALB654.games.chess.render.renderObjects.ChessboardRenO;
import de.ALB654.games.chess.render.renderObjects.FigurRenO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseInputManager extends MouseAdapter {

    private final LogicBoard logicManager;

    private final ChessboardRenO chessboardRenO;

    private final FigureRenderManager figureRenderManager;
    private final AnimationManager animationManager;

    private ActiveFigure activeFigure = null;

    private GamePanel gamePanel;


    public MouseInputManager(LogicBoard logicManager, ChessboardRenO chessboardRenO, FigureRenderManager figureRenderManager, AnimationManager animationManager) {
        this.logicManager = logicManager;
        this.chessboardRenO = chessboardRenO;
        this.figureRenderManager = figureRenderManager;
        this.animationManager = animationManager;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int[] positionOnBoard = chessboardRenO.getTileAt(e.getX(), e.getY());

        int xPos = positionOnBoard[0];
        int yPos = positionOnBoard[1];

        if(positionOnBoard[0] != -1) {

            if (activeFigure != null) {
                ArrayList<LogicBoard.BoardPosition> possibleMoves = activeFigure.possibleMoves();

                for(LogicBoard.BoardPosition bp : possibleMoves) {
                    if(bp.x() == xPos && bp.y() == yPos && !bp.renderMode().equals(LogicBoard.BoardPosition.RenderMode.OWN_POS)) {

                        LogicFigure hitLogicFigure = logicManager.getFigureOnPos(xPos, yPos);
                        if(hitLogicFigure != null) {
                            FigurRenO hitFigurRenO = figureRenderManager.getFigureRenOPerLogicId(hitLogicFigure.getId());
                            animationManager.playAnimation(hitFigurRenO , new LinearAnimation(), 500, new LinearAnimationTime(), hitFigurRenO.getxPos(), hitFigurRenO.getyPos(), -hitFigurRenO.getWidth(), hitFigurRenO.getyPos());
                        }

                        //Move figure
                        logicManager.moveFigure(logicManager.createBoardPosition(activeFigure.xPos, activeFigure.yPos), bp);

                        LogicFigure logicFigure = logicManager.getFigureOnPos(xPos, yPos);
                        FigurRenO figurRenO = figureRenderManager.getFigureRenOPerLogicId(logicFigure.getId());


                        int[] renderPos = chessboardRenO.getPositionFromTile(xPos, yPos);

                        animationManager.playAnimation(figurRenO , new LinearAnimation(), 500, new EaseInOutAnimationTime(), figurRenO.getxPos(), figurRenO.getyPos(), renderPos[0], renderPos[1]);

                        resetPossiblePositionMarkers();
                        return;
                    }
                }
            }

            LogicFigure logicFigure = logicManager.getFigureOnPos(xPos, yPos);

            if(logicFigure == null) {
                resetPossiblePositionMarkers();
                return;
            }

            ArrayList<LogicBoard.BoardPosition> possibleMoves = logicFigure.getPossibleMoves(xPos, yPos);
            chessboardRenO.renderPossibleBoardPositions(possibleMoves);

            activeFigure = new ActiveFigure(logicFigure, xPos, yPos, possibleMoves);
        }

        gamePanel.repaint();
    }

    private void resetPossiblePositionMarkers() {
        chessboardRenO.removePossibleBoardPositions();
        activeFigure = null;
        gamePanel.repaint();
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    private record ActiveFigure(LogicFigure figure, int xPos, int yPos, ArrayList<LogicBoard.BoardPosition> possibleMoves) {}
}
