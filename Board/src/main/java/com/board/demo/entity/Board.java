package com.board.demo.entity;

import com.board.demo.dto.BoardDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Board {
    protected Board() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String writer;

    @ColumnDefault("0")
    private int viewcnt;

    @Column
    private LocalDate date;

    public Board(BoardDto boardDto){
        this.id = boardDto.getId();
        this.type = boardDto.getType();
        this.title = boardDto.getTitle();
        this.writer = boardDto.getWriter();
        this.content = boardDto.getContent();
        this.viewcnt = boardDto.getViewcnt();
        this.date = boardDto.getDate();
    }
}
