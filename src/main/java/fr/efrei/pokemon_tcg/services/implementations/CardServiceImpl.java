package fr.efrei.pokemon_tcg.services.implementations;

import fr.efrei.pokemon_tcg.dto.CardDTO;
import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.repositories.CardRepository;
import fr.efrei.pokemon_tcg.repositories.DresseurRepository;
import fr.efrei.pokemon_tcg.services.ICardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements ICardService {

    private final CardRepository cardRepository;
    private final DresseurRepository dresseurRepository;

    public CardServiceImpl(CardRepository cardRepository, DresseurRepository dresseurRepository) {
        this.cardRepository = cardRepository;
        this.dresseurRepository = dresseurRepository;
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card saveCard(CardDTO cardDTO) {
        Card card = new Card();
        card.setPokemonUuid(cardDTO.getPokemon_id());
        card.setAttack1(cardDTO.getAttack1());
        card.setAttack2(cardDTO.getAttack2());
        return cardRepository.save(card);
    }

}

