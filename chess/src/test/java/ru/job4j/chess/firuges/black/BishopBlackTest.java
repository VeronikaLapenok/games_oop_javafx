package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void positionC8ForBishopBlack() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell expectedPosition = bishopBlack.position();
        assertThat(expectedPosition, is(Cell.C8));
    }

    @Test
    public void positionG3ForBishopBlack() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G3);
        Cell expectedPosition = bishopBlack.position();
        assertThat(expectedPosition, is(Cell.G3));
    }

    @Test
    public void wayIfBishopBlackGoesFromC1ToG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = bishopBlack.way(Cell.G5);
        Cell[] actual = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void wayIfBishopBlackGoesFromH1ToB7() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H1);
        Cell[] expected = bishopBlack.way(Cell.B7);
        Cell[] actual = {
                Cell.G2, Cell.F3, Cell.E4, Cell.D5, Cell.C6, Cell.B7
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void wayIfBishopBlackGoesFromE5ToH2() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E5);
        Cell[] expected = bishopBlack.way(Cell.H2);
        Cell[] actual = {Cell.F4, Cell.G3, Cell.H2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void wayIfBishopBlackGoesFromF8ToC5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell[] expected = bishopBlack.way(Cell.C5);
        Cell[] actual = {Cell.E7, Cell.D6, Cell.C5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void isDiagonalTrue() {
        boolean expected = BishopBlack.isDiagonal(Cell.E5, Cell.A1);
        assertThat(expected, is(true));
    }

    @Test
    public void isDiagonalFalse() {
        boolean expected = BishopBlack.isDiagonal(Cell.C7, Cell.D3);
        assertThat(expected, is(false));
    }


    @Test
    public void copyBishopBlackOnPositionC8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Figure copiedBishopBlack = bishopBlack.copy(Cell.C8);
        Cell actualPosition = bishopBlack.position();
        Cell expectedPosition = copiedBishopBlack.position();
        assertThat(expectedPosition, is(actualPosition));
    }

    @Test
    public void copyBishopBlackOnPositionA3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A3);
        Figure copiedBishopBlack = bishopBlack.copy(Cell.A3);
        Cell actualPosition = bishopBlack.position();
        Cell expectedPosition = copiedBishopBlack.position();
        assertThat(expectedPosition, is(actualPosition));
    }
}