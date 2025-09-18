package com.example.trello_clone.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.trello_clone.model.Card;

public interface CardRepository extends MongoRepository<Card, String> {
}
