package com.chargepoint.gameOfLife;

import com.chargepoint.gameOfLife.model.GameGrid;
import com.chargepoint.gameOfLife.service.GameService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {
    private final GameService gameService = new GameService(null); // Mocked repository for tests

    @Test
    void testGameInitialization() {
        GameGrid grid = gameService.initializeGame(5);
        assertNotNull(grid);
        assertEquals(5, grid.getSize());
    }

    @Test
    void testNextGeneration() {
        GameGrid grid = gameService.initializeGame(5);
        GameGrid nextGen = gameService.nextGeneration();
        assertNotNull(nextGen);
        assertEquals(grid.getSize(), nextGen.getSize());
    }
}