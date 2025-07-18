package com.koreait.boardservice.domain;

import java.time.LocalDateTime;

public class Post {
    private Integer id;
    private Integer memberId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Post() {}
    public Post(Integer id, Integer memberId, String title, String content) {
        this.id = id;
        this.memberId = memberId;
        this.title = title;
        this.content = content;
    }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getMemberId() { return memberId; }
    public void setMemberId(Integer memberId) { this.memberId = memberId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
