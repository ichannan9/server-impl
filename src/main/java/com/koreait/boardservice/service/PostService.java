package com.koreait.boardservice.service;

import com.koreait.boardservice.domain.Post;
import com.koreait.boardservice.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(Long id);
    Post create(PostDTO dto);
    Post update(PostDTO dto);
    void delete(Long id, Long memberId);
}
