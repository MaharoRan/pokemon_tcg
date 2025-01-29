package fr.efrei.pokemon_tcg.services;

import fr.efrei.pokemon_tcg.models.Card;

import java.util.List;

public interface ICardService {
    List<Card> getAllCards();
}
