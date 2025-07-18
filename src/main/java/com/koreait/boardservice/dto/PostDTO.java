package com.koreait.boardservice.dto;

public class PostDTO {
    private Integer postId;
    private Integer memberId;
    private String title;
    private String content;

    public PostDTO() {}

    public Integer getPostId() { return postId; }
    public void setPostId(Integer postId) { this.postId = postId; }

    public Integer getMemberId() { return memberId; }
    public void setMemberId(Integer memberId) { this.memberId = memberId; }

    public String getTitle()    { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent()  { return content; }
    public void setContent(String content) { this.content = content; }
}
