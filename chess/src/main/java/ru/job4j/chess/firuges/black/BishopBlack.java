package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.lang.Math.abs;

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
                    String.format("Not diagonal from %s to %s", position, dest)
            );
        }
        int currentPositionX = position.getX();
        int currentPositionY = position.getY();
        int deltaX = (dest.getX() - currentPositionX) < 0 ? -1 : 1;
        int deltaY = (dest.getY() - currentPositionY) < 0 ? -1 : 1;
        int size = abs(currentPositionX - dest.getX());
        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            currentPositionX += deltaX;
            currentPositionY += deltaY;
            steps[index] = Cell.findBy(currentPositionX, currentPositionY);
        }
        return steps;

    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return abs(source.getX() - dest.getX()) == abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
