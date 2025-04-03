package com.daw3.daily.service;

import com.daw3.daily.model.PostModel;
import com.daw3.daily.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<PostModel> findAllPosts() {
        return postRepository.findAll();
    }

    public PostModel findPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public void addPost(PostModel post) {
        postRepository.save(post);
    }
}
