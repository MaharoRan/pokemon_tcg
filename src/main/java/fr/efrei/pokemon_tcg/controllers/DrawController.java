package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.models.Draw;
import fr.efrei.pokemon_tcg.services.implementations.CardServiceImpl;
import fr.efrei.pokemon_tcg.services.implementations.DrawServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/draws")
public class DrawController {
    private final DrawServiceImpl drawServiceImpl;

    public DrawController(DrawServiceImpl drawServiceImpl) {
        this.drawServiceImpl = drawServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<Draw>> getAllDraws() {
        return new ResponseEntity<>(drawServiceImpl.getAllDraws(), HttpStatus.OK);
    }
}
