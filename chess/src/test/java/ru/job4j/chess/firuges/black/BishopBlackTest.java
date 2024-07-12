package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.job4j.chess.firuges.Cell;


class BishopBlackTest {
    @Test
    public void whenBishopBlackCreatedPositionShouldBeTheSame() {
        final Cell position = Cell.C8;
        BishopBlack firstBlackBishop = new BishopBlack(position);
        assertThat(firstBlackBishop.position()).isEqualTo(position);
    }

    @Test
    void copy() {
        final Cell position = Cell.F8;
        final Cell newPosition = Cell.D6;
        BishopBlack secondBlackBishop = new BishopBlack(position);
        secondBlackBishop = (BishopBlack) secondBlackBishop.copy(newPosition);
        assertThat(secondBlackBishop.position()).isEqualTo(newPosition);
    }

    @Test
    void WhenTheWayIsCorrect() {
        final Cell position = Cell.C1;
        final Cell dest = Cell.G5;
        final Cell[] expectedCells = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        BishopBlack newBlackBishop = new BishopBlack(position);
        final Cell[] resultCells = newBlackBishop.way(dest);
        assertThat(expectedCells).isEqualTo(resultCells);
    }

    @Test
    void WhenWayIsNotDiagonalThenShouldBeException() {
        final Cell start = Cell.D2;
        final Cell dest = Cell.F4;
        BishopBlack newBishopBlack = new BishopBlack(start);
        assertThat(newBishopBlack.way(start)).overridingErrorMessage(String.format("Could not move by diagonal from %s to %s", start, dest));
    }
}
