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
        } else {
            int posX = position.getX();
            int posY = position.getY();
            int destX = dest.getX();
            int destY = dest.getY();
            int size = Math.abs(destX - posX);
            Cell[] steps = new Cell[size];

            int deltaX = (posX > destX) ? -1 : 1;
            int deltaY = (posY > destY) ? -1 : 1;

            int x = posX + deltaX;
            int y = posY + deltaY;

            for (int index = 0; index < size; index++) {
                steps[index] = Cell.findBy(x, y);
                x += deltaX;
                y += deltaY;
            }
            return steps;
        }
    }

    public static boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
