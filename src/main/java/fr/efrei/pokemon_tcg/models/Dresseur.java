package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Dresseur {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	private String nom;

	private String prenom;

	private LocalDateTime deletedAt;

	private LocalDateTime lastDrawDate;

	@OneToMany
	List<Pokemon> pokemonList;

	@OneToMany
	private List<Card> cardList;

	@OneToMany
	private List<Card> secondCardList;

	@OneToMany
	private List<Draw> drawList;

	private LocalDateTime lastExchangeDate;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	public List<Pokemon> getPokemonList() {
		return pokemonList;
	}

	public void setPokemonList(List<Pokemon> pokemonList) {
		this.pokemonList = pokemonList;
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

	public List<Card> getSecondCardList() {
		return secondCardList;
	}

	public void setSecondCardList(List<Card> secondCardList) {
		this.secondCardList = secondCardList;
	}

	public List<Draw> getDrawList() {
		return drawList;
	}

	public void setDrawList(List<Draw> drawList) {
		this.drawList = drawList;
	}

	public LocalDateTime getLastDrawDate() {
		return lastDrawDate;
	}

	public void setLastDrawDate(LocalDateTime lastDrawDate) {
		this.lastDrawDate = lastDrawDate;
	}

	public LocalDateTime getLastExchangeDate() {
		return lastExchangeDate;
	}

	public void setLastExchangeDate(LocalDateTime lastExchangeDate) {
		this.lastExchangeDate = lastExchangeDate;
	}
}
