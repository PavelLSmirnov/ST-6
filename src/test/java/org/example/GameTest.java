package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    void testCheckState() {
        char[] board = {'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '};
        game.symbol = 'X';
        assertEquals(State.XWIN, game.checkState(board));

        board = new char[]{'O', 'O', 'O', ' ', ' ', ' ', ' ', ' ', ' '};
        game.symbol = 'O';
        assertEquals(State.OWIN, game.checkState(board));

        board = new char[]{'X', 'O', 'X', 'O', 'O', 'X', 'X', 'X', 'O'};
        assertEquals(State.DRAW, game.checkState(board));

        board = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        assertEquals(State.PLAYING, game.checkState(board));
    }

    @Test
    void testGenerateMoves() {
        char[] board1 = {'X', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'X'};
        ArrayList<Integer> moveList1 = new ArrayList<>();
        game.generateMoves(board1, moveList1);
        assertEquals(0, moveList1.size());

        char[] board2 = {' ', 'X', ' ', 'O', ' ', 'X', ' ', 'O', ' '};
        ArrayList<Integer> moveList2 = new ArrayList<>();
        game.generateMoves(board2, moveList2);
        assertEquals(5, moveList2.size());
        assertTrue(moveList2.contains(0));
        assertTrue(moveList2.contains(2));
        assertTrue(moveList2.contains(4));
        assertTrue(moveList2.contains(6));
        assertTrue(moveList2.contains(8));

        char[] board3 = {'X', 'O', 'X', 'O', 'X', 'O', 'O', 'X', ' '};
        ArrayList<Integer> moveList3 = new ArrayList<>();
        game.generateMoves(board3, moveList3);
        assertEquals(1, moveList3.size());
        assertTrue(moveList3.contains(8));
    }

    @Test
    void testMiniMax() {
        char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        game.symbol = 'X';
        int move = game.MiniMax(board, game.player1);
        assertTrue(move >= 1 && move <= 9);
    }


    @Test
    public void testMinMove() {
        Player player1 = new Player();
        Player player2 = new Player();

        player1.symbol = 'X';
        player2.symbol = 'O';

        char[] board = new char[9];
        Arrays.fill(board, ' ');
        int value = game.MinMove(board, player1);
        assertEquals(0, value);

        board = new char[]{'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        value = game.MinMove(board, player1);
        assertEquals(100, value);
    }

    @Test
    public void testMaxMove() {
        Player player1 = new Player();
        Player player2 = new Player();

        player1.symbol = 'X';
        player2.symbol = 'O';


        char[] board = new char[9];
        Arrays.fill(board, ' ');
        int value = game.MaxMove(board, player1);
        assertEquals(0, value);

        board = new char[]{' ', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'O'};
        value = game.MaxMove(board, player2);
        assertEquals(100, value);
    }
}