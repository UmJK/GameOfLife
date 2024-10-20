package com.chargepoint.gameOfLife.repository;

import com.chargepoint.gameOfLife.model.GameGrid;
import org.springframework.stereotype.Repository; // Correct import

@Repository
public class GameRepository {
    private GameGrid gameGrid;

    public GameGrid initializeGrid(int size) {
        gameGrid = new GameGrid(size);
        return gameGrid;
    }

    public GameGrid getGrid() {
        return gameGrid;
    }

    public void saveGrid(GameGrid updatedGrid) {
        this.gameGrid = updatedGrid;
    }
}