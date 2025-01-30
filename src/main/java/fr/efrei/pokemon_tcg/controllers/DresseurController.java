package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.dto.CapturePokemon;
import fr.efrei.pokemon_tcg.dto.CardDTO;
import fr.efrei.pokemon_tcg.dto.DrawDTO;
import fr.efrei.pokemon_tcg.dto.DresseurDTO;
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

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/dresseurs")
public class DresseurController {

	private final IDresseurService dresseurService;
	private final CardServiceImpl cardServiceImpl;

	public DresseurController(DresseurServiceImpl dresseurService, CardServiceImpl cardServiceImpl) {
		this.dresseurService = dresseurService;
		this.cardServiceImpl = cardServiceImpl;
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

	/* @PatchMapping("/{uuid}/tirer")
	public ResponseEntity<?> tirerCartes(@RequestBody String uuid) {
		List<CardDTO> cards = cardDTO.
		List<Draw> draws = drawServiceImpl.getAllDraws();
		Random random = new Random();

		for (int i = 0; i < 5; i++) {
			Card card = cards.get(random.nextInt(cards.size()));
			Draw draw = new Draw();
			draws.add(draw);
		}

		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}*/

	@PatchMapping("/{uuid}/createDresseurCards")
	public ResponseEntity<?> createDresseurCards(
			@PathVariable String uuid,
			@RequestBody DresseurDTO dresseurDTO) {
		for (int i = 0; i < 5; i++) {
			CardDTO card = new CardDTO();

			if (dresseurDTO.getCardList().size() < 5) {
				dresseurDTO.getCardList().add(card);
			} else {
				dresseurDTO.getSecondCardList().add(card);
			}
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PatchMapping("/{uuid}/acheter")
	public ResponseEntity<?> acheter() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
