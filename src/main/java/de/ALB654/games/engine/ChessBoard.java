package de.ALB654.games.engine;

import java.awt.*;

public class ChessBoard extends ObjectPanel {

    private final String xChessLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int xTileAmount;

    private final int yTileAmount;

    private final int xTileSize;

    private final int yTileSize;

    private final TilePosition[][] tilePositions;

    public ChessBoard(int xTileSize, int yTileSize, int width, int height, int xPos, int yPos) {
        super(width, height, xPos, yPos);
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

/*

    A4 B4 C4 D4
    A3 B3 C3 D3
    A2 B2 C2 D2
    A1 B1 C1 D1

 */
    public String getTileAt(int xPos, int yPos) {
        int xTile = xPos * (xTileAmount / getWidth());
        int yTile = yPos * (yTileAmount / getHeight()) + 1;

        return xChessLetters.substring(xTile, xTile + 1) + yTile;
    }

    public String getTileAtLocal(int xPos, int yPos) {
        return getTileAt(xPos + getxPos(), yPos + getyPos());
    }

    public int[] getLocalPositionFromTile(String tile) {
        int xPos = xTileSize * (xChessLetters.indexOf(Character.toString(tile.charAt(1))));
        int yPos = yTileSize * (Integer.parseInt(Character.toString(tile.charAt(1))) - 1);
        return new int[] { xPos, yPos };
    }

    public int[] getPositionFromTile(String tile) {
        int[] pos = getLocalPositionFromTile(tile);
        pos[0] += getxPos();
        pos[1] += getyPos();

        return pos;
    }

    @Override
    public void draw(Graphics2D g2d) {
        boolean black = true;
        for(int x = 0; x < xTileAmount; x++) {
            black = !black;
            for(int y = 0; y < yTileAmount; y++) {
                if(black)
                    g2d.setColor(new Color(93, 53, 41));
                else
                    g2d.setColor(new Color(209, 149, 121));

                TilePosition tilePos = tilePositions[x][y];

                g2d.fillRect(tilePos.x, tilePos.y, getxTileSize(), getyTileSize());

                black = !black;
            }
        }
    }

    public TilePosition[][] getTilePositions() {
        return tilePositions;
    }

    public int getxTileAmount() {
        return xTileAmount;
    }

    public int getyTileAmount() {
        return yTileAmount;
    }

    public int getxTileSize() {
        return xTileSize;
    }

    public int getyTileSize() {
        return yTileSize;
    }

    public record TilePosition(int x, int y) {};
}
