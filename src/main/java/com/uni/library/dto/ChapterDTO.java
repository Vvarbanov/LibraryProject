package com.uni.library.dto;

public class ChapterDTO {

    private String title;
    private String content;
    private Long book_id;

    public ChapterDTO(String title, String content, Long book_id) {
        this.title = title;
        this.content = content;
        this.book_id = book_id;
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

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }
}
