package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UtilityTest {

    @Test
    void testPrintCharArray() {
        char[] board = {'X', 'O', 'X', 'O', 'O', 'X', 'O', 'X', 'X'};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Utility.print(board);

        String expectedOutput = System.lineSeparator() + "X-O-X-O-O-X-O-X-X-" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    void testPrintIntArray() {
        int[] board = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Utility.print(board);

        String expectedOutput = System.lineSeparator() + "1-2-3-4-5-6-7-8-9-" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    void testPrintArrayList() {
        ArrayList<Integer> moves = new ArrayList<>();
        moves.add(1);
        moves.add(2);
        moves.add(3);
        moves.add(4); // Добавлен элемент
        moves.add(5); // Добавлен элемент

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Utility.print(moves);

        String expectedOutput = System.lineSeparator() + "1-2-3-4-5-" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }
}