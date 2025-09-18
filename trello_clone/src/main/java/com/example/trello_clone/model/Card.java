package com.example.trello_clone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "cards")
public class Card {
    @Id
    private String id;
    private String title;
    private String description;
    private String listId; // belongs to a specific list

    public Card() {}
    public Card(String title, String description, String listId) {
        this.title = title;
        this.description = description;
        this.listId = listId;
    }
}
