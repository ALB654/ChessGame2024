package de.ALB654.games.chess.logic;

public class LogicBoard {

    private final LogicFigure[][] board;

    private final int xSize;

    private final int ySize;


    public LogicBoard(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;

        board = new LogicFigure[xSize][ySize];
    }

    public BoardPosition createBoardPosition(int x, int y) {
        if(x >= 0 && y >= 0 && x < xSize && y < ySize)
            return new BoardPosition(x, y);

        System.err.println("[createBP] Ungültige Position angefragt: x: " + x + " y: " + y + "\n"
                            + "Größe: x: " + xSize + " y: " + ySize);

        return new BoardPosition(0, 0);
    }

    public boolean moveFigure(BoardPosition startPosition, BoardPosition targetPosition) {
        LogicFigure figure = getFigureOnPos(startPosition);
        if(figure == null) {
            System.err.println("Es wurde versucht eine Figur zu bewegen, aber auf dem angegebenen Feld steht keine Figur!\n" +
                    "Angegebenes Feld: X: " + startPosition.x + " Y: " + startPosition.y);
            return false;
        }

        if(!figure.getPossibleMoves(startPosition.x, startPosition.y).contains(createBoardPosition(targetPosition.x, targetPosition.y))) {
            System.err.println("Es wurde versucht eine Figur zu bewegen, aber die Figur kann sich nicht auf das angegebene Feld bewegen!\n" +
                    "Angegebenes Feld: X: " + startPosition.x + " Y: " + startPosition.y + "\n" +
                    "Zielfeld: X: " + targetPosition.x + " Y: " + targetPosition.y);
            return false;
        }

        board[startPosition.x][startPosition.y] = null;
        board[targetPosition.x][targetPosition.y] = figure;

        return true;
    }

    public void addFigure(LogicFigure figure, BoardPosition boardPosition) {
        board[boardPosition.x][boardPosition.y] = figure;
    }

    public LogicFigure getFigureOnPos(BoardPosition boardPosition) {
        return board[boardPosition.x][boardPosition.y];
    }

    public LogicFigure getFigureOnPos(int x, int y) {
        if(x >= 0 && y >= 0 && x < xSize && y < ySize)
            return board[x][y];

        System.err.println("[figOnPos] Ungültige Position angefragt: x: " + x + " y: " + y + "\n"
                + "Größe: x: " + xSize + " y: " + ySize);
        return null;
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public record BoardPosition(int x, int y) { }
}
