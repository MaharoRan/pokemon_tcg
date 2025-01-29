package fr.efrei.pokemon_tcg.models;

import java.util.Random;

public class Card {
    private String uuid;
    private String pokemonUuid;
    private String attack1;
    private String attack2;
    private int rarity;

    public Card(String pokemonUuid, String attack1, String attack2) {
        this.uuid = generateId();
        this.pokemonUuid = pokemonUuid;
        this.attack1 = attack1;
        this.attack2 = attack2;
        this.rarity = generateRarity();
    }

    private String generateId() {
        return "";
    }

    private int generateRarity() {
        Random random = new Random();
        return random.nextInt(5) + 1; // Example: Random rarity from 1 to 5
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPokemonUuid() {
        return pokemonUuid;
    }

    public void setPokemonUuid(String pokemonUuid) {
        this.pokemonUuid = pokemonUuid;
    }

    public String getAttack1() {
        return attack1;
    }

    public void setAttack1(String attack1) {
        this.attack1 = attack1;
    }

    public String getAttack2() {
        return attack2;
    }

    public void setAttack2(String attack2) {
        this.attack2 = attack2;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

}
