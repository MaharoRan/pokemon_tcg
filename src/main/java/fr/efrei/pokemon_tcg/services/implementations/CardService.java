package fr.efrei.pokemon_tcg.services.implementations;

import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.repositories.CardRepository; // Assuming you have a repository for Card
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
}

