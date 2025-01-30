package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.services.implementations.CardServiceImpl;
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
    public List<Card> getAllCards() {
        return cardServiceImpl.getAllCards();
    }

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        card.setRarity(generateRandomRarity());
        return cardServiceImpl.saveCard(card);
    }

    private int generateRandomRarity() {
        Random random = new Random();
        return random.nextInt(5) + 1; 
    }
}
