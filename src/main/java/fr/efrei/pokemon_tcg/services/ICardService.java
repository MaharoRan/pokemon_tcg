package fr.efrei.pokemon_tcg.services;

import fr.efrei.pokemon_tcg.dto.CardDTO;
import fr.efrei.pokemon_tcg.models.Card;

import java.util.List;

public interface ICardService {
    List<Card> getAllCards();

    Card saveCard(CardDTO card);
}
