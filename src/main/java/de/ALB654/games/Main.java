package de.ALB654.games;

import de.ALB654.games.chess.Chess;
import de.ALB654.games.engine.Window;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Chess chess = new Chess();
        chess.openGame();
    }
}