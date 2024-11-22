package com.example.airlinerating.service;

import com.example.airlinerating.Entity.Game;

import java.util.List;

public interface GameService {
    void addGameAndUpdateRatings(List<Game> games);
}
