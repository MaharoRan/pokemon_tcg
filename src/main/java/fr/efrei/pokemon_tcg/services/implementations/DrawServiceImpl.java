package fr.efrei.pokemon_tcg.services.implementations;

import fr.efrei.pokemon_tcg.models.Draw;
import fr.efrei.pokemon_tcg.repositories.DrawRepository;
import fr.efrei.pokemon_tcg.services.IDrawService;

import java.util.List;

public class DrawServiceImpl implements IDrawService {
    private final DrawRepository drawRepository;

    public DrawServiceImpl(DrawRepository drawRepository) {
        this.drawRepository = drawRepository;
    }
     public List<Draw> getAllDraws(){
        return drawRepository.findAll();
     }
}
