package fr.efrei.pokemon_tcg.dto;

import fr.efrei.pokemon_tcg.models.Draw;

import java.util.Date;

public class DrawDTO extends Draw {
    private String dresseurId;
    private String card_uuid;
    private Date date;
}
