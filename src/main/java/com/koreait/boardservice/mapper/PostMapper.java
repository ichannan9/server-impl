package com.koreait.boardservice.mapper;

import com.koreait.boardservice.domain.Post;
import java.util.List;
import java.util.Map;

public interface PostMapper {
    List<Post> findAll();
    Post findById(int id);
    void insertPost(Post post);
    void updatePost(Post post);
    void deletePost(Map<String,Integer> params);
}
