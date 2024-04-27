package com.board.demo.service;

import com.board.demo.dto.BoardDto;
import com.board.demo.entity.Board;
import com.board.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List <Board> findAllBoards() {
        return boardRepository.findAll();
    }

    public Board getBoard(long id){
        return boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found with id " + id));
    }

    public void addBoard(BoardDto boardDto) {
        LocalDate currentDateTime = LocalDate.now();
        boardDto.setDate(currentDateTime);


        Board board = new Board(boardDto);
        boardRepository.save(board);
    }

    public void deleteBoard(int id){

    }

    public boolean validCondition(BoardDto boardDto) {
        if (boardDto.getTitle() == null) {
            System.out.println("타이틀이 비어있습니다.");
            return false;
        } else if (boardDto.getContent() == null) {
            System.out.println("내용이 비어있습니다.");
            return false;
        }
        else if (boardDto.getWriter() == null) {
            System.out.println("작성자가 비어있습니다.");
            return false;
        }
        else if (boardDto.getType() == null) {
            System.out.println("타입이 비어있습니다.");
            return false;
        }
        else {
            return true;
        }
    }

}
