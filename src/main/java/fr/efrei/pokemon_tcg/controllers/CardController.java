package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.services.implementations.CardService;
import fr.efrei.pokemon_tcg.services.implementations.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards(); 
    }

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        card.setRarity(generateRandomRarity());
        return cardService.saveCard(card);
    }

    private int generateRandomRarity() {
        Random random = new Random();
        return random.nextInt(5) + 1; 
    }
}
