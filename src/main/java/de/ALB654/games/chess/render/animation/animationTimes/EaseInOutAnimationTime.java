package de.ALB654.games.chess.render.animation.animationTimes;

import de.ALB654.games.chess.render.animation.AnimationTime;

public class EaseInOutAnimationTime implements AnimationTime {
    @Override
    public float getAnimationFulfillmentAt(int timeSinceStart, int duration) {
        return 1.05f / (1f + (1.05f / 0.001f) * (float)Math.pow(Math.E, (-9.21034f/(float)duration)*(float)timeSinceStart));
    }
}
