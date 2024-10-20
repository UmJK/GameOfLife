package com.chargepoint.gameOfLife.model;

public class GameGrid {
    private final Cell[][] grid;
    private final int size;

    public GameGrid(int size) {
        this.size = size;
        grid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell(false); // All cells dead initially
            }
        }
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(grid[i][j].isAlive() ? "1 " : "0 ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}