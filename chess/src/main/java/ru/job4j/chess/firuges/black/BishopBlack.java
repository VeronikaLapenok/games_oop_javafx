package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }

        int posX = position.getX();
        int posY = position.getY();
        int destX = dest.getX();
        int destY = dest.getY();
        int size = Math.abs(destX - posX);
        Cell[] steps = new Cell[size];
        int deltaX = (posX > destX) ? -1 : 1;
        int deltaY = (posY > destY) ? -1 : 1;

        for (int index = 0; index < size; index++) {
            posX += deltaX;
            posY += deltaY;
            steps[index] = Cell.findBy(posX, posY);
        }
        return steps;

    }

    public static boolean isDiagonal(Cell source, Cell dest) {
        return (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY()));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
