package fr.efrei.pokemon_tcg.repositories;

import fr.efrei.pokemon_tcg.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
}
