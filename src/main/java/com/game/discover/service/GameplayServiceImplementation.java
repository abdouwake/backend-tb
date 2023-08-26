package com.game.discover.service;

import com.game.discover.model.Gameplay;
import com.game.discover.repository.GamePlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameplayServiceImplementation implements GameplayService {

    @Autowired
    GamePlayRepository gamePlayRepository;

    @Override
    public Gameplay createGameplay(Gameplay gameplay) {
        return gamePlayRepository.save(gameplay);
    }

    @Override
    public Gameplay updateGameplay(Gameplay gameplay) {
        Optional<Gameplay> gp = gamePlayRepository.findById(String.valueOf(1));
        gp.get().setPlay(gameplay.getPlay());
        gp.get().setEndDate(gameplay.getEndDate());
        gp.get().setEndGame(gameplay.getEndGame());
        return gamePlayRepository.save(gp.get());
    }

    @Override
    public void deleteGameplay(Long id) {
        gamePlayRepository.deleteById(Long.toString(id));
    }

    @Override
    public List<Gameplay> listGameplay() {
        return gamePlayRepository.findAll();
    }

    public Optional<Gameplay> getGameplay() {
        return gamePlayRepository.findAll().stream().findFirst();
    }


    @Override
    public Optional<Gameplay> listGameplayById(String id) {
        return gamePlayRepository.findById(id);
    }
}