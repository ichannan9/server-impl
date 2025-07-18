package com.koreait.boardservice.controller;

import com.koreait.boardservice.domain.Post;
import com.koreait.boardservice.dto.PostDTO;
import com.koreait.boardservice.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> list() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> detail(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody PostDTO dto) {
        return ResponseEntity.status(201).body(postService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(
            @PathVariable Long id,
            @RequestBody PostDTO dto) {
        dto.setPostId(id.intValue());
        return ResponseEntity.ok(postService.update(dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id,
            @RequestParam Long memberId) {
        postService.delete(id, memberId);
        return ResponseEntity.noContent().build();
    }
}
