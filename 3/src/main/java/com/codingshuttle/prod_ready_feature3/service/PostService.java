package com.codingshuttle.prod_ready_feature3.service;

import com.codingshuttle.prod_ready_feature3.dto.PostDTO;
import com.codingshuttle.prod_ready_feature3.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO  createNewPost(PostDTO newPost);

    PostDTO getPostById(Long postId);
}
