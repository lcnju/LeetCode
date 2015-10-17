// According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

// Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

// Any live cell with fewer than two live neighbors dies, as if caused by under-population.
// Any live cell with two or three live neighbors lives on to the next generation.
// Any live cell with more than three live neighbors dies, as if by over-population..
// Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
// Write a function to compute the next state (after one update) of the board given its current state.

// Follow up: 
// Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
// In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

public class Solution {
    
    private int[][] board;

    public void gameOfLife(int[][] board) {
        this.board = board;
        int[][] nextboard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    if (getNeighbors(i, j) == 3) {
                        nextboard[i][j] = 1;
                    } else {
                        nextboard[i][j] = 0;
                    }
                } else {
                    int neighbors = getNeighbors(i, j);
                    if (neighbors < 2) {
                        nextboard[i][j] = 0;
                    } else if (neighbors >= 2 && neighbors <= 3) {
                        nextboard[i][j] = 1;
                    } else {
                        nextboard[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = nextboard[i][j];
            }
        }
    }

    private int getNeighbors(int i, int j) {
        int neighbors = 0;
        if (isLive(i - 1, j - 1)) {
            neighbors++;
        }
        if (isLive(i - 1, j)) {
            neighbors++;
        }
        if (isLive(i - 1, j + 1)) {
            neighbors++;
        }
        if (isLive(i, j - 1)) {
            neighbors++;
        }
        if (isLive(i, j + 1)) {
            neighbors++;
        }
        if (isLive(i + 1, j - 1)) {
            neighbors++;
        }
        if (isLive(i + 1, j)) {
            neighbors++;
        }
        if (isLive(i + 1, j + 1)) {
            neighbors++;
        }
        return neighbors;
    }

    private boolean isLive(int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            return board[i][j] == 1;
        }
        return false;
    }
}