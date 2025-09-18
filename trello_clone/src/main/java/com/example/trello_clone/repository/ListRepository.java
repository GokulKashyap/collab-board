package com.example.trello_clone.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.trello_clone.model.ListEntity;

public interface ListRepository extends MongoRepository<ListEntity, String> {
}
