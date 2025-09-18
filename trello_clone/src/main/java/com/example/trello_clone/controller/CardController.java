package com.example.trello_clone.controller;

import com.example.trello_clone.model.Card;
import com.example.trello_clone.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    // Create a card
    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardRepository.save(card);
    }

    // Get all cards
    @GetMapping
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    // Get a card by id
    @GetMapping("/{id}")
    public Card getCardById(@PathVariable String id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found with id " + id));
    }

    // Update a card
    @PutMapping("/{id}")
    public Card updateCard(@PathVariable String id, @RequestBody Card updatedCard) {
        return cardRepository.findById(id)
                .map(card -> {
                    card.setTitle(updatedCard.getTitle());
                    card.setDescription(updatedCard.getDescription());
                    card.setListId(updatedCard.getListId());
                    return cardRepository.save(card);
                })
                .orElseThrow(() -> new RuntimeException("Card not found with id " + id));
    }

    // Delete a card
    @DeleteMapping("/{id}")
    public String deleteCard(@PathVariable String id) {
        cardRepository.deleteById(id);
        return "Card deleted with id " + id;
    }
}
