package com.koreait.boardservice.service;

import com.koreait.boardservice.domain.Post;
import com.koreait.boardservice.dto.PostDTO;
import com.koreait.boardservice.mapper.PostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    private final PostMapper postMapper;

    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public List<Post> findAll() {
        return postMapper.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postMapper.findById(id.intValue());
    }

    @Override
    @Transactional
    public Post create(PostDTO dto) {
        Post p = new Post();
        p.setMemberId(dto.getMemberId());
        p.setTitle(dto.getTitle());
        p.setContent(dto.getContent());
        postMapper.insertPost(p);
        return p;
    }

    @Override
    @Transactional
    public Post update(PostDTO dto) {
        Post p = new Post();
        p.setId(dto.getPostId());
        p.setMemberId(dto.getMemberId());
        p.setTitle(dto.getTitle());
        p.setContent(dto.getContent());
        postMapper.updatePost(p);
        return postMapper.findById(p.getId().intValue());
    }

    @Override
    @Transactional
    public void delete(Long id, Long memberId) {
        Map<String,Integer> params = new HashMap<>();
        params.put("id", id.intValue());
        params.put("memberId", memberId.intValue());
        postMapper.deletePost(params);
    }
}
