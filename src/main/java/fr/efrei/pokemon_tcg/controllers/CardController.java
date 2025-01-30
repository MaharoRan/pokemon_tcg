package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.dto.CardDTO;
import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.services.implementations.CardServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardServiceImpl cardServiceImpl;

    public CardController(CardServiceImpl cardServiceImpl) {
        this.cardServiceImpl = cardServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
         return new ResponseEntity<>(cardServiceImpl.getAllCards(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCard(@RequestBody CardDTO card) {
        card.setRarity(generateRandomRarity());
        return new ResponseEntity<>(cardServiceImpl.saveCard(card),HttpStatus.CREATED);
    }

    private int generateRandomRarity() {
        Random random = new Random();
        return random.nextInt(5) + 1; 
    }
}
