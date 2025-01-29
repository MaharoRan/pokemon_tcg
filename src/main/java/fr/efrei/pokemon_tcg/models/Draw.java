package fr.efrei.pokemon_tcg.models;

import java.util.Date;

public class Draw {
    private String id;
    private String pokemonUuid;
    private String cardUuid;
    private Date date;

    public Draw(String pokemonUuid, String cardUuid, Date date) {
        this.id = generateId();
        this.pokemonUuid = pokemonUuid;
        this.cardUuid = cardUuid;
        this.date = date;
    }

    private String generateId() {
        return "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPokemonUuid() {
        return pokemonUuid;
    }

    public void setPokemonUuid(String pokemonUuid) {
        this.pokemonUuid = pokemonUuid;
    }

    public String getCardUuid() {
        return cardUuid;
    }

    public void setCardUuid(String cardUuid) {
        this.cardUuid = cardUuid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}