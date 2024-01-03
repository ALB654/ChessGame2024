package de.ALB654.games.chess.utils;

public class Vector2i {

    private int x;
    private int y;

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addOwn(Vector2i other) {
        this.x += other.getX();
        this.y += other.getY();
    }

    public Vector2i add(Vector2i other) {
        return new Vector2i(this.x + other.getX(), this.y + other.getY());
    }

    public Vector2i multiply(int scalar) {
        return new Vector2i(this.x * scalar, this.y * scalar);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
