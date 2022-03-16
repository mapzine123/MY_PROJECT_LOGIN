package com.firstSpring.app.domain;

import java.util.Date;
import java.util.Objects;

public class BoardDto {
    private int bno;
    private String name;
    private String title;
    private String content;
    private Date reg_date;
    private int viewCnt;

    public BoardDto() {
    }



    public BoardDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public BoardDto(String name, String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
    }

    public BoardDto(int bno, String name, String content, Date reg_date, int viewCnt) {
        this.bno = bno;
        this.name = name;
        this.content = content;
        this.reg_date = reg_date;
        this.viewCnt = viewCnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDto boardDto = (BoardDto) o;
        return bno == boardDto.bno && viewCnt == boardDto.viewCnt && Objects.equals(name, boardDto.name) && Objects.equals(content, boardDto.content) && Objects.equals(reg_date, boardDto.reg_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bno, name, content, reg_date, viewCnt);
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", reg_date=" + reg_date +
                ", viewCnt=" + viewCnt +
                '}';
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }
}
