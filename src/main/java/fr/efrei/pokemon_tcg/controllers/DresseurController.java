package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.dto.CapturePokemon;
import fr.efrei.pokemon_tcg.dto.CardDTO;
import fr.efrei.pokemon_tcg.dto.DresseurDTO;
import fr.efrei.pokemon_tcg.dto.CardExchangeDTO;
import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.models.Draw;
import fr.efrei.pokemon_tcg.models.Dresseur;
import fr.efrei.pokemon_tcg.services.IDresseurService;
import fr.efrei.pokemon_tcg.services.implementations.CardServiceImpl;
import fr.efrei.pokemon_tcg.services.implementations.DrawServiceImpl;
import fr.efrei.pokemon_tcg.services.implementations.DresseurServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/dresseurs")
public class DresseurController {

    private final IDresseurService dresseurService;
    private final CardServiceImpl cardServiceImpl;
    private final DresseurServiceImpl dresseurServiceImpl;
    private DrawServiceImpl drawServiceImpl;

    public DresseurController(DresseurServiceImpl dresseurService, CardServiceImpl cardServiceImpl, DresseurServiceImpl dresseurServiceImpl) {
        this.dresseurService = dresseurService;
        this.cardServiceImpl = cardServiceImpl;
        this.drawServiceImpl = drawServiceImpl;
        this.dresseurServiceImpl = dresseurServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<Dresseur>> findAll() {
        return new ResponseEntity<>(dresseurService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody DresseurDTO dresseurDTO) {
        dresseurService.create(dresseurDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> delete(@PathVariable String uuid) {
        dresseurService.delete(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{uuid}/capturer")
    public ResponseEntity<?> capturer(
            @PathVariable String uuid,
            @RequestBody CapturePokemon capturePokemon
    ) {
        dresseurService.capturerPokemon(uuid, capturePokemon);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{uuid}/acheter")
    public ResponseEntity<?> acheter() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{uuid}/tirerCartes")
    public ResponseEntity<List<Card>> tirerCartes(@PathVariable String uuid) {
        Dresseur dresseur = dresseurService.findById(uuid);

        if (dresseur.getLastDrawDate() != null && dresseur.getLastDrawDate().isEqual(LocalDateTime.now())) {
            return new ResponseEntity<>(List.of(), HttpStatus.FORBIDDEN);
        }else {
			List<Card> newCards = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				Card card = generateRandomCard();
				newCards.add(card);
			}

			dresseur.setLastDrawDate(LocalDateTime.now());
			DresseurDTO dresseurDTO = new DresseurDTO();
			dresseurService.create(dresseurDTO);

			return new ResponseEntity<>(newCards, HttpStatus.OK);
		}
    }

    private Card generateRandomCard() {
        Card card = new Card();
		card.setAttack1("Attaque1");
		card.setAttack2("Attaque2");
        card.setRarity(generateRarity());
        return card;
    }

	private int generateRarity() {
		Random random = new Random();
		int chance = random.nextInt(100);
		if (chance < 50) return 1;
		else if (chance < 80) return 2;
		else if (chance < 90) return 3;
		else if (chance < 98) return 4;
		else return 5;
	}

	@PatchMapping("/{uuid}/echangerCartes")
	public ResponseEntity<?> echangerCartes(@PathVariable String uuid, @RequestBody CardExchangeDTO exchangeDTO, @RequestBody DresseurDTO dresseurDTO) {
		Dresseur dresseur = dresseurService.findById(uuid);
		if (dresseur.getLastExchangeDate() != null && dresseur.getLastExchangeDate().isEqual(LocalDateTime.now())) {
			return new ResponseEntity<>("Vous ne pouvez échanger des cartes qu'une fois par jour.", HttpStatus.FORBIDDEN);    
		} 
		LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
		dresseur.setLastExchangeDate(startOfDay);
		dresseurService.create(dresseurDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
