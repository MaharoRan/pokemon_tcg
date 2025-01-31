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
    //request_body in cardDTO
    public ResponseEntity<?> createCard(@RequestBody CardDTO card) {
        card.setRarity(generateRarity());
        return new ResponseEntity<>(cardServiceImpl.saveCard(card),HttpStatus.CREATED);
    }

    private int generateRarity() {
        Random random = new Random();
        int chance = random.nextInt(100);
        if (chance < 50) return 1;
        else if (chance < 80) return 2;
        else if (chance < 90) return 3;
        else if (chance < 98) return 4;
        else return 5;
    }
}
