package com.codingshuttle.prod_ready_feature3.service;

import com.codingshuttle.prod_ready_feature3.dto.PostDTO;
import com.codingshuttle.prod_ready_feature3.entities.PostEntity;
import com.codingshuttle.prod_ready_feature3.exception.ResourceNotFoundException;
import com.codingshuttle.prod_ready_feature3.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.PostDeleteEvent;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts(){
       return postRepository.findAll()
               .stream()
               .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
               .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO newPost) {
        PostEntity postEntity= modelMapper.map(newPost,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity= postRepository
                .findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post id not found with+ "+postId));

        return modelMapper.map(postEntity, PostDTO.class);
    }
}
