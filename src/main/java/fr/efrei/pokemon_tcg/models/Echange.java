package fr.efrei.pokemon_tcg.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import fr.efrei.pokemon_tcg.models.Dresseur;
import fr.efrei.pokemon_tcg.models.Card;

@Entity
@Table(name = "ECHANGE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"dresseur1_id", "dresseur2_id", "date_echange"})
})
public class Echange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "dresseur1_id", nullable = false)
    private Dresseur dresseur1;

    @ManyToOne
    @JoinColumn(name = "dresseur2_id", nullable = false)
    private Dresseur dresseur2;

    @ManyToOne
    @JoinColumn(name = "carte1_id", nullable = false)
    private Card carte1;

    @ManyToOne
    @JoinColumn(name = "carte2_id", nullable = false)
    private Card carte2;

    @Column(name = "date_echange", nullable = false)
    private java.time.LocalDateTime dateEchange;

    private List<Card> cards;
    private String participant1;
    private String participant2;

    // Default constructor
    public Echange() {
        this.cards = new ArrayList<>();
    }

    // Parameterized constructor
    public Echange(List<Card> cards, String participant1, String participant2) {
        this.cards = cards;
        this.participant1 = participant1;
        this.participant2 = participant2;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Dresseur getDresseur1() {
        return dresseur1;
    }

    public void setDresseur1(Dresseur dresseur1) {
        this.dresseur1 = dresseur1;
    }

    public Dresseur getDresseur2() {
        return dresseur2;
    }

    public void setDresseur2(Dresseur dresseur2) {
        this.dresseur2 = dresseur2;
    }

    public Card getCarte1() {
        return carte1;
    }

    public void setCarte1(Card carte1) {
        this.carte1 = carte1;
    }

    public Card getCarte2() {
        return carte2;
    }

    public void setCarte2(Card carte2) {
        this.carte2 = carte2;
    }

    public java.time.LocalDateTime getDateEchange() {
        return dateEchange;
    }

    public void setDateEchange(java.time.LocalDateTime dateEchange) {
        this.dateEchange = dateEchange;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getParticipant1() {
        return participant1;
    }

    public void setParticipant1(String participant1) {
        this.participant1 = participant1;
    }

    public String getParticipant2() {
        return participant2;
    }

    public void setParticipant2(String participant2) {
        this.participant2 = participant2;
    }

    // Method to display exchange details
    public void displayExchangeDetails() {
        System.out.println("Exchange between " + participant1 + " and " + participant2);
        System.out.println("Cards involved:");
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
