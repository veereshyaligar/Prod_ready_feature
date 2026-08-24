package com.codingshuttle.prod_ready_feature3.controller;

import com.codingshuttle.prod_ready_feature3.dto.PostDTO;
import com.codingshuttle.prod_ready_feature3.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class postController {

    private final PostService postService;

    @GetMapping
    public List<PostDTO> getAll(){
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostDTO getPostById(@PathVariable Long postId){
         return postService.getPostById(postId);
    }

    @PostMapping
    public PostDTO createNewPost(@RequestBody PostDTO postDTO){
        return postService.createNewPost(postDTO);
    }

    @PutMapping("{postId}")
    public PostDTO updatePost(@RequestBody PostDTO inputPostDTO, @PathVariable Long postId){
        return postService.updatePostDTO(inputPostDTO,postId);
    }
}
