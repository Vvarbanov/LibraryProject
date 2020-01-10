package com.uni.library.dto;

public class ArticleDTO {

    private String title;
    private String content;
    private Long newspaper_id;

    public ArticleDTO(String title, String content, Long newspaper_id) {
        this.title = title;
        this.content = content;
        this.newspaper_id = newspaper_id;
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

    public Long getNewspaper_id() {
        return newspaper_id;
    }

    public void setNewspaper_id(Long newspaper_id) {
        this.newspaper_id = newspaper_id;
    }
}
