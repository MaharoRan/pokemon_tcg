package fr.efrei.pokemon_tcg.dto;

import fr.efrei.pokemon_tcg.models.Card;

import java.util.Random;

public class CardDTO  {
    private String pokemon_id;
    private String attack1;
    private String attack2;
    private int rarity;

    public CardDTO() {

    }

    public String getPokemon_id() {
        return pokemon_id;
    }

    public void setAttack2(String attack2) {
        this.attack2 = attack2;
    }

    public void setPokemon_id(String pokemon_id) {
        this.pokemon_id = pokemon_id;
    }

    public void setAttack1(String attack1) {
        this.attack1 = attack1;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public String getAttack1() {
        return attack1;
    }

    public String getAttack2() {
        return attack2;
    }
}
