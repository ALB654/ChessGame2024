package de.ALB654.games.chess.render.renderObjects;

import de.ALB654.games.chess.logic.LogicBoard;
import de.ALB654.games.chess.render.RenderObject;

import java.awt.*;
import java.util.ArrayList;

public class ChessboardRenO extends RenderObject {

    private final int xTileAmount;

    private final int yTileAmount;

    private final int xTileSize;

    private final int yTileSize;

    private final TilePosition[][] tilePositions;


    private ArrayList<LogicBoard.BoardPosition> possiblePositions = null;

    public ChessboardRenO(int id, int xTileSize, int yTileSize, int width, int height, int xPos, int yPos) {
        super(id, width, height, xPos, yPos);
        this.xTileAmount = xTileSize;
        this.yTileAmount = yTileSize;
        this.xTileSize = (width / xTileAmount);
        this.yTileSize = (height / yTileAmount);

        tilePositions = new TilePosition[this.xTileAmount][this.yTileAmount];
        calculateTilePositions();
    }

    private void calculateTilePositions() {
        for(int x = 0; x < xTileAmount; x++) {
            for(int y = 0; y < yTileAmount; y++) {
                tilePositions[x][y] = new TilePosition(x * xTileSize,y * yTileSize);
            }
        }
    }

    public int[] getTileAt(int renderXPos, int renderYPos) {

        int localRenderXPos = (renderXPos - getxPos());
        int localRenderYPos = (renderYPos - getyPos());

        if(localRenderXPos < 0 || localRenderYPos < 0) {
            return new int[] { -1, -1 };
        }

        int xTile =  localRenderXPos / xTileSize;
        int yTile = localRenderYPos / yTileSize;

        if(xTile >= xTileAmount || yTile >= yTileAmount) {
            return new int[] { -1, -1 };
        }

        return new int[] { xTile, yTile };
    }

    public int[] getLocalPositionFromTile(int x, int y) {
        int xPos = xTileSize * x;
        int yPos = yTileSize * y;
        return new int[] { xPos, yPos };
    }

    public int[] getPositionFromTile(int x, int y) {
        int[] pos = getLocalPositionFromTile(x, y);
        pos[0] += getxPos();
        pos[1] += getyPos();

        return pos;
    }

    public void renderPossibleBoardPositions(ArrayList<LogicBoard.BoardPosition> positions) {
        this.possiblePositions = positions;
    }

    public void removePossibleBoardPositions() {
        this.possiblePositions = null;
    }

    @Override
    public void draw(Graphics2D g2d) {}

    @Override
    public void drawLocal(Graphics2D g2d) {
        boolean black = true;
        for(int x = 0; x < xTileAmount; x++) {
            black = !black;
            for(int y = 0; y < yTileAmount; y++) {
                if(black)
                    g2d.setColor(new Color(93, 53, 41));
                else
                    g2d.setColor(new Color(209, 149, 121));

                TilePosition tilePos = tilePositions[x][y];

                g2d.fillRect(tilePos.x, tilePos.y, getXTileSize(), getYTileSize());

                if(possiblePositions != null) {
                    for (LogicBoard.BoardPosition bp : possiblePositions) {
                        if(bp.x() == x && bp.y() == y)
                            switch (bp.renderMode()) {
                                case OWN_POS -> {
                                    g2d.setColor(new Color(70, 203, 199, 100));
                                    int xDist = (int)((double)getXTileSize() * 0.1d);
                                    int yDist = (int)((double)getYTileSize() * 0.1d);
                                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                    g2d.fillOval(tilePos.x + xDist, tilePos.y + yDist, getXTileSize() - 2*xDist, getYTileSize() - 2*yDist);
                                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                                }
                                case NORMAL_MOVE -> {
                                    g2d.setColor(new Color(35, 35, 35, 124));
                                    int xDist = (int)((double)getXTileSize() * 0.2d);
                                    int yDist = (int)((double)getYTileSize() * 0.2d);
                                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                    g2d.fillOval(tilePos.x + xDist, tilePos.y + yDist, getXTileSize() - 2*xDist, getYTileSize() - 2*yDist);
                                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                                }
                                case HIT -> {
                                    g2d.setColor(new Color(239, 23, 23, 124));
                                    g2d.fillRect(tilePos.x, tilePos.y, getXTileSize() + 1, getYTileSize() + 1);
                                }
                                case FRIENDLY_HIT -> {

                                }
                            }
                    }
                }

                black = !black;
            }
        }
    }

    public TilePosition[][] getTilePositions() {
        return tilePositions;
    }

    public int getXTileAmount() {
        return xTileAmount;
    }

    public int getYTileAmount() {
        return yTileAmount;
    }

    public int getXTileSize() {
        return xTileSize;
    }

    public int getYTileSize() {
        return yTileSize;
    }

    public record TilePosition(int x, int y) {};

}
