package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Draw {
    @Id
    @GeneratedValue
    private String uuid;
    private String pokemonUuid;
    private String cardUuid;
    private Date date;

    public Draw(String pokemonUuid, String cardUuid, Date date) {
        this.pokemonUuid = pokemonUuid;
        this.cardUuid = cardUuid;
        this.date = date;
    }

    public Draw() {
        
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
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