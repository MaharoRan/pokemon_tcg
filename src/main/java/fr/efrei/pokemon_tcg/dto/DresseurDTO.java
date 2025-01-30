package fr.efrei.pokemon_tcg.dto;

import fr.efrei.pokemon_tcg.models.Card;

import java.util.List;

public class DresseurDTO {
	private String nom;

	private String prenom;

	private List<Card> cardList;

	private List<Card> secondCardList;

	public List<Card> getCardList() {
		return cardList;
	}

	public List<Card> getSecondCardList() {
		return secondCardList;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
}
