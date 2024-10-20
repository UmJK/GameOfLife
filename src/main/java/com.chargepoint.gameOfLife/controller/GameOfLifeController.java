package com.chargepoint.gameOfLife.controller;

import com.chargepoint.gameOfLife.model.GameGrid;
import com.chargepoint.gameOfLife.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game-of-life")
public class GameOfLifeController {
    private final GameService gameService;

    public GameOfLifeController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/start")
    public GameGrid initializeGame(@RequestParam(defaultValue = "25") int size) {
        return gameService.initializeGame(size);
    }

    @GetMapping("/current-state")
    public GameGrid getCurrentState() {
        return gameService.getCurrentGrid();
    }

    @GetMapping("/next-generation")
    public GameGrid nextGeneration() {
        return gameService.nextGeneration();
    }
}