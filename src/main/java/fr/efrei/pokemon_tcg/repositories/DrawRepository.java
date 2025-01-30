package fr.efrei.pokemon_tcg.repositories;

import fr.efrei.pokemon_tcg.models.Draw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrawRepository extends JpaRepository<Draw, String> {
    List<Draw> findAll();
}
