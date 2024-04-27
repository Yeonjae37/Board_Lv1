package com.board.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Getter
@Setter
public class BoardDto {
    private Long id;
    private String type;
    private String title;
    private String content;
    private String writer;
    private int viewcnt;
    private LocalDate date;

    public Long getId() { return id; }
    public String getType() { return type; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getWriter() { return writer; }
    public int getViewcnt() { return viewcnt; }
    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
