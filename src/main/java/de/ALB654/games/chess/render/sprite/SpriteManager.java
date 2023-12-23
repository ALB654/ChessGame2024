package de.ALB654.games.chess.render.sprite;

import de.ALB654.games.chess.FigureType;

import java.util.HashMap;

public class SpriteManager {

    private HashMap<FigureType, Sprite> blackSprites = new HashMap<>();
    private HashMap<FigureType, Sprite> whiteSprites = new HashMap<>();

    public SpriteManager(int xSpriteSize, int ySpriteSize) {
        loadSprites(xSpriteSize, ySpriteSize);
    }

    private void loadSprites(int xSpriteSize, int ySpriteSize) {
        whiteSprites.put(FigureType.BAUER, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 665, 0, 133, 133, xSpriteSize, ySpriteSize));
        whiteSprites.put(FigureType.KOENIG, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 0, 0, 133, 133, xSpriteSize, ySpriteSize));
        whiteSprites.put(FigureType.DAME, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 133, 0, 133, 133, xSpriteSize, ySpriteSize));
        whiteSprites.put(FigureType.LAEUFER, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 266, 0, 133, 133, xSpriteSize, ySpriteSize));
        whiteSprites.put(FigureType.SPRINGER, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 400, 0, 133, 133, xSpriteSize, ySpriteSize));
        whiteSprites.put(FigureType.TURM, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 533, 0, 133, 133, xSpriteSize, ySpriteSize));

        blackSprites.put(FigureType.BAUER, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 665, 133, 133, 133, xSpriteSize, ySpriteSize));
        blackSprites.put(FigureType.KOENIG, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 0, 133, 133, 133, xSpriteSize, ySpriteSize));
        blackSprites.put(FigureType.DAME, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 133, 133, 133, 133, xSpriteSize, ySpriteSize));
        blackSprites.put(FigureType.LAEUFER, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 266, 133, 133, 133, xSpriteSize, ySpriteSize));
        blackSprites.put(FigureType.SPRINGER, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 400, 133, 133, 133, xSpriteSize, ySpriteSize));
        blackSprites.put(FigureType.TURM, new Sprite("src/main/resources/Chess_Pieces_Sprite.png", 533, 133, 133, 133, xSpriteSize, ySpriteSize));
    }

    public Sprite getSprite(FigureType type, boolean isBlack) {
        if(isBlack)
            return blackSprites.get(type);
        else
            return whiteSprites.get(type);
    }

}
