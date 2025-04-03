package com.daw3.daily.controller;

import com.daw3.daily.dto.PostDTO;
import com.daw3.daily.mapper.PostMapper;
import com.daw3.daily.model.PostModel;
import com.daw3.daily.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;

    @GetMapping
    public ResponseEntity<List<PostModel>> findAllPosts() {
        try {
            List<PostModel> posts = postService.findAllPosts();

            return ResponseEntity.status(HttpStatus.OK).body(posts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostModel> findPostById(@PathVariable Long id) {
        try {
            PostModel post = postService.findPostById(id);

            return ResponseEntity.status(HttpStatus.OK).body(post);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<PostModel> addPost(@RequestBody PostDTO postDTO) {
        try {
            PostModel post = postMapper.from(postDTO);

            postService.addPost(post);

            return ResponseEntity.status(HttpStatus.CREATED).body(post);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
