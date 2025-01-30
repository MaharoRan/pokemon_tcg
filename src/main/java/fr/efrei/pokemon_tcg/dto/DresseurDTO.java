package fr.efrei.pokemon_tcg.dto;

import java.util.List;

public class DresseurDTO {
	private String nom;

	private String prenom;

	private List<CardDTO> cardList;

	private List<CardDTO> secondCardList;

	private List<DrawDTO> drawList;

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public List<CardDTO> getCardList() {
		return cardList;
	}

	public List<CardDTO> getSecondCardList() {
		return secondCardList;
	}

	public List<DrawDTO> getDrawList() {
		return drawList;
	}
}
