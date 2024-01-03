package de.ALB654.games.chess.render.animation.animation;

import de.ALB654.games.chess.render.animation.Animation;

public class LinearAnimation implements Animation {

    @Override
    public int[] getPositionAt(float fullfilled, int startX, int startY, int endX, int endY) {
        int x = (int)(((float)endX - (float)startX) * fullfilled) + startX;
        int y = (int)(((float)endY - (float)startY) * fullfilled) + startY;

        return new int[] { x, y };
    }

}
