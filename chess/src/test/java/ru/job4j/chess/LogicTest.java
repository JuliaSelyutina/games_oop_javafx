package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenOccupiedCellException()
        throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        final Cell position = Cell.C1;
        final Cell dest = Cell.E3;
        BishopBlack firstBlackBishop = new BishopBlack(position);
        BishopBlack secondBlackBishop = new BishopBlack(dest);
        logic.add(firstBlackBishop);
        logic.add(secondBlackBishop);
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(position, dest);
        });
        assertThat(exception.getMessage()).isEqualTo("There is a figure on the way. Movement is not possible.");
    }
}