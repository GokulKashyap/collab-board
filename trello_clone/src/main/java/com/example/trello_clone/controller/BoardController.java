package com.example.trello_clone.controller;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trello_clone.model.Board;
import com.example.trello_clone.repository.BoardRepository;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardRepository boardRepository;
    public BoardController(BoardRepository boardRepository)
    {
        this.boardRepository=boardRepository;
    }
    @PostMapping
    public Board createBoard(@RequestBody Board board)
    {
        return boardRepository.save(board);
    }
    @GetMapping
    public List<Board> getAllBoards()
    {
        return boardRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Board> getBoardById(@PathVariable String id)
    {
        return boardRepository.findById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteBoard(@PathVariable String id)
    {
        boardRepository.deleteById(id);
        return "Board deleted with id"+id;
    }
    @PutMapping("/{id}")
    public Board updateBoard(@PathVariable String id,@RequestBody Board updatedBoard)
    {
         return boardRepository.findById(id)
                .map(board -> {
                    board.setName(updatedBoard.getName());
                    board.setListIds(updatedBoard.getListIds());
                    return boardRepository.save(board);
                })
                .orElseThrow(() -> new RuntimeException("Board not found with id " + id));
    }
}
