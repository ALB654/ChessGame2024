package de.ALB654.games.engine;

import de.ALB654.games.engine.figures.ChessFigure;

import java.util.HashMap;

public class SpriteManager {

    private HashMap<ChessFigure.Type, Sprite> blackSprites = new HashMap<>();
    private HashMap<ChessFigure.Type, Sprite> whiteSprites = new HashMap<>();

    public SpriteManager(int xSpriteSize, int ySpriteSize) {

        whiteSprites.put(ChessFigure.Type.BAUER, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 665, 0, 133, 133, xSpriteSize, ySpriteSize));
        whiteSprites.put(ChessFigure.Type.KOENIG, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 0, 0, 133, 133, xSpriteSize, ySpriteSize));
        whiteSprites.put(ChessFigure.Type.DAME, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 133, 0, 133, 133, xSpriteSize, ySpriteSize));
        whiteSprites.put(ChessFigure.Type.LAUFER, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 266, 0, 133, 133, xSpriteSize, ySpriteSize));
        whiteSprites.put(ChessFigure.Type.PFERD, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 400, 0, 133, 133, xSpriteSize, ySpriteSize));
        whiteSprites.put(ChessFigure.Type.TURM, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 533, 0, 133, 133, xSpriteSize, ySpriteSize));

        blackSprites.put(ChessFigure.Type.BAUER, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 665, 0, 133, 133, xSpriteSize, ySpriteSize));
        blackSprites.put(ChessFigure.Type.KOENIG, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 0, 0, 133, 133, xSpriteSize, ySpriteSize));
        blackSprites.put(ChessFigure.Type.DAME, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 133, 0, 133, 133, xSpriteSize, ySpriteSize));
        blackSprites.put(ChessFigure.Type.LAUFER, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 266, 0, 133, 133, xSpriteSize, ySpriteSize));
        blackSprites.put(ChessFigure.Type.PFERD, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 400, 0, 133, 133, xSpriteSize, ySpriteSize));
        blackSprites.put(ChessFigure.Type.TURM, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 533, 0, 133, 133, xSpriteSize, ySpriteSize));
    }

    public Sprite getSprite(ChessFigure.Type type, boolean isBlack) {
        if(isBlack)
            return blackSprites.get(type);
        else
            return whiteSprites.get(type);
    }

}
