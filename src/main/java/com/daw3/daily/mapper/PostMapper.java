package com.daw3.daily.mapper;

import com.daw3.daily.dto.PostDTO;
import com.daw3.daily.model.PostModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PostMapper {
    public PostModel from(PostDTO postDTO) {
        PostModel postModel = new PostModel();

        postModel.setDateTime(LocalDateTime.now());
        postModel.setTitle(postDTO.title());
        postModel.setImage(postDTO.image());
        postModel.setText(postDTO.text());

        return postModel;
    }
}
