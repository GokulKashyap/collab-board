package com.example.trello_clone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Data
@Document(collection = "boards")
public class Board {
    @Id
    private String id;
    private String name;
    
    // Reference to multiple lists
    private List<String> listIds;  // store list IDs instead of embedding whole objects

    public Board() {}
    public Board(String name) {
        this.name = name;
    }
}
