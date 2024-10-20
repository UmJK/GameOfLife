package com.chargepoint.gameOfLife.service;

import com.chargepoint.gameOfLife.exception.GameNotFoundException;
import com.chargepoint.gameOfLife.model.Cell;
import com.chargepoint.gameOfLife.model.GameGrid;
import com.chargepoint.gameOfLife.repository.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameGrid initializeGame(int size) {
        GameGrid grid = gameRepository.initializeGrid(size);

        // Initialize the Glider pattern in the middle of the grid
        int middle = size / 2;
        grid.getGrid()[middle][middle].setAlive(true);
        grid.getGrid()[middle + 1][middle + 1].setAlive(true);
        grid.getGrid()[middle + 1][middle + 2].setAlive(true);
        grid.getGrid()[middle][middle + 2].setAlive(true);
        grid.getGrid()[middle - 1][middle + 1].setAlive(true);

        gameRepository.saveGrid(grid);
        return grid;
    }

    public GameGrid getCurrentGrid() {
        GameGrid grid = gameRepository.getGrid();
        if (grid == null) {
            throw new GameNotFoundException("Game grid not initialized");
        }
        return grid;
    }

    public GameGrid nextGeneration() {
        GameGrid currentGrid = gameRepository.getGrid();
        if (currentGrid == null) {
            throw new GameNotFoundException("Game grid not initialized");
        }

        GameGrid newGrid = new GameGrid(currentGrid.getSize());

        for (int i = 0; i < currentGrid.getSize(); i++) {
            for (int j = 0; j < currentGrid.getSize(); j++) {
                int aliveNeighbors = countAliveNeighbors(currentGrid, i, j);
                boolean isAlive = currentGrid.getGrid()[i][j].isAlive();

                // Apply Game of Life rules
                if (isAlive && (aliveNeighbors < 2 || aliveNeighbors > 3)) {
                    newGrid.getGrid()[i][j].setAlive(false);
                } else if (!isAlive && aliveNeighbors == 3) {
                    newGrid.getGrid()[i][j].setAlive(true);
                } else {
                    newGrid.getGrid()[i][j].setAlive(isAlive);
                }
            }
        }
        gameRepository.saveGrid(newGrid);
        return newGrid;
    }

    private int countAliveNeighbors(GameGrid grid, int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == row && j == col) continue; // Skip the cell itself
                if (i >= 0 && i < grid.getSize() && j >= 0 && j < grid.getSize() && grid.getGrid()[i][j].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }
}