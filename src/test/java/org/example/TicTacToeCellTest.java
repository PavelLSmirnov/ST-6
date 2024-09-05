package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeCellTest {

    private TicTacToeCell cell;

    @BeforeEach
    public void setUp() {
        cell = new TicTacToeCell(0, 0, 0);
    }

    @Test
    public void testTicTacToeCell() {
        assertEquals(0, cell.getNum());
        assertEquals(0, cell.getRow());
        assertEquals(0, cell.getCol());
        assertEquals(' ', cell.getMarker());
        assertTrue(cell.isEnabled());

        cell.setMarker("0");
        assertEquals('0', cell.getMarker());
        assertFalse(cell.isEnabled());
    }
}