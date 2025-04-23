package com.daw3.daily.mapper;

import com.daw3.daily.dto.PostDTO;
import com.daw3.daily.model.PostModel;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class PostMapper {
    public PostModel from(PostDTO postDTO, MultipartFile image) {
        PostModel postModel = new PostModel();

        postModel.setDateTime(LocalDateTime.now());
        postModel.setTitle(postDTO.title());
        postModel.setText(postDTO.text());

        try {
            postModel.setImage(image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return postModel;
    }
}
