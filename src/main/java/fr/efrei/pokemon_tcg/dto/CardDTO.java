package fr.efrei.pokemon_tcg.dto;

import fr.efrei.pokemon_tcg.models.Card;

import java.util.Random;

public class CardDTO extends Card {
    private String pokemon_id;
    private String attack1;
    private String attack2;
    private int rarity;

    public CardDTO() {

    }

    public String getPokemon_id() {
        return pokemon_id;
    }

    public String getAttack1() {
        return attack1;
    }

    public String getAttack2() {
        return attack2;
    }

}
