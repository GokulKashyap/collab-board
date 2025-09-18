package com.example.trello_clone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Data
@Document(collection = "lists")
public class ListEntity {
    @Id
    private String id;
    private String name;
    private String boardId; // belongs to a specific board
    private List<String> cardIds; // store card IDs

    public ListEntity() {}
    public ListEntity(String name, String boardId) {
        this.name = name;
        this.boardId = boardId;
    }
}
