package com.example.trello_clone.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.trello_clone.model.Board;

public interface BoardRepository extends MongoRepository<Board, String> {
}
