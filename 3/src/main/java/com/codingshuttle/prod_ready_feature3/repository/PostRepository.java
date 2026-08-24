package com.codingshuttle.prod_ready_feature3.repository;

import com.codingshuttle.prod_ready_feature3.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
