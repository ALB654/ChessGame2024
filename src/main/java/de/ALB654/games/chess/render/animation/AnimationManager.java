package de.ALB654.games.chess.render.animation;

import de.ALB654.games.chess.render.GamePanel;

import java.util.ArrayList;

public class AnimationManager {

    private boolean isAnimationRunning;
    private final ArrayList<AnimationBundle> animatables = new ArrayList<>();
    private final ArrayList<AnimationBundle> finishedAnimatables = new ArrayList<>();
    private Thread animationThread = null;

    private GamePanel gamePanel;

    public void playAnimation(Moveable moveable, Animation animation, int duration, AnimationTime animationTime, int startX, int startY, int endX, int endY) {
        animatables.add(new AnimationBundle(moveable, animation, duration, animationTime, System.currentTimeMillis(), startX, startY, endX, endY));

        startAnimation();
    }

    private void startAnimation() {
        if(!isAnimationRunning) {
            isAnimationRunning = true;
            animationThread = new Thread(() -> {
                try {
                    startAnimationLoop();
                } catch (InterruptedException e) {
                    System.err.println("Fehler im Animationsloop: ");
                    e.printStackTrace();
                }
            });

            animationThread.start();
        }
    }

    private void processAnimation(AnimationBundle animationBundle) {
        float fullfillment = animationBundle.animationTime.getAnimationFulfillmentAt((int)(System.currentTimeMillis() - animationBundle.startingTime),
                animationBundle.duration);


        int[] pos = animationBundle.animation.getPositionAt(fullfillment, animationBundle.startX, animationBundle.startY, animationBundle.endX, animationBundle.endY);

        animationBundle.animatable.moveToPosition(pos[0], pos[1]);

        if((int)(System.currentTimeMillis() - (animationBundle.startingTime + animationBundle.duration)) > 0) {
            finishedAnimatables.add(animationBundle);
            animationBundle.animatable.moveToPosition(animationBundle.endX, animationBundle.endY);
        }


    }

    private void startAnimationLoop() throws InterruptedException {
        do {
            synchronized (animatables) {
                if(animatables.isEmpty())
                    isAnimationRunning = false;
                else {
                    animatables.forEach(this::processAnimation);
                }
            }

            finishedAnimatables.forEach(animatables::remove);
            finishedAnimatables.clear();

            gamePanel.repaint();

            Thread.sleep(1000/60);

        } while(isAnimationRunning);
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    private record AnimationBundle(Moveable animatable, Animation animation, int duration, AnimationTime animationTime, long startingTime, int startX, int startY, int endX, int endY) { }
}
