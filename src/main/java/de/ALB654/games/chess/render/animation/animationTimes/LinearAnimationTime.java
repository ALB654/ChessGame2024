package de.ALB654.games.chess.render.animation.animationTimes;

import de.ALB654.games.chess.render.animation.AnimationTime;

public class LinearAnimationTime implements AnimationTime {
    @Override
    public float getAnimationFulfillmentAt(int timeSinceStart, int duration) {
        return (1f / (float)duration)*((float)timeSinceStart);
    }
}
