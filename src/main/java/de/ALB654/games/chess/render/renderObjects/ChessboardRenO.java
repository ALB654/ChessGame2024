package de.ALB654.games.chess.render.renderObjects;

import de.ALB654.games.chess.render.RenderObject;

import java.awt.*;

public class ChessboardRenO extends RenderObject {

    private final int xTileAmount;

    private final int yTileAmount;

    private final int xTileSize;

    private final int yTileSize;

    private final TilePosition[][] tilePositions;

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
        int xTile = renderXPos * (xTileAmount / getWidth());
        int yTile = renderYPos * (yTileAmount / getHeight()) + 1;

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
