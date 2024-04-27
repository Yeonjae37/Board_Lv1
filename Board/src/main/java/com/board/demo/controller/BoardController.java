package com.board.demo.controller;

import com.board.demo.dto.BoardDto;
import com.board.demo.entity.Board;
import com.board.demo.repository.BoardRepository;
import com.board.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public List<Board> getBoards(){
        return boardService.findAllBoards();
    }

    @ResponseBody
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getBoard(@PathVariable("id") Long id){
        Board board = boardService.getBoard(id);
        System.out.println("Board data: " + board);
        return ResponseEntity.ok(board);
    }

    @ResponseBody
    @PostMapping("/add")
    public ResponseEntity<?> addBoard(@RequestBody BoardDto boardDto){
        if (boardService.validCondition(boardDto)){
            boardService.addBoard(boardDto);
            Board board = new Board(boardDto);
            return ResponseEntity.ok(board);
        }
        else {
            return ResponseEntity.badRequest().body("필수 입력 값이 누락되었습니다.");
        }
    }

    @ResponseBody
    @PostMapping("/delete")
    public ResponseEntity<?> deleteBoard(int id){
        boardService.deleteBoard(id);
        return ResponseEntity.ok("ok");
    }
}
