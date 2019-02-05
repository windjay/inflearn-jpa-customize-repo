package com.inflean.springjpa.jpastudy;


import com.inflean.springjpa.jpastudy.post.Post;
import com.inflean.springjpa.jpastudy.post.PostRepository;
import com.inflean.springjpa.jpastudy.post.PostRepositoryTestConfig;
import com.inflean.springjpa.jpastudy.post.QPost;
import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class PostRepositoryTest {

  @Autowired
  PostRepository postRepository;

/*  @Autowired
  ApplicationContext applicationContext;


  @Test
  public void event() {
    Post post = new Post();
    post.setTitle("Event");
    PostPublishedEvent event = new PostPublishedEvent(post);

    applicationContext.publishEvent(event);

  }*/


  @Test
  public void crud() {

    // 1. 일반적 JPA 처리
    Post post = new Post();
    post.setTitle("hibernate");

    assertThat(postRepository.contains(post)).isFalse();

    // PostListenenr 가 이벤트 리스너로 등록되어 있으므로 화면에 추가로 로그 찍히게 됨
    postRepository.save(post.publish());
/*
    assertThat(postRepository.contains(post)).isTrue();

    postRepository.delete(post);
    postRepository.flush();*/


    // 2. querydsl 적용
    Predicate predicate = QPost.post.title.containsIgnoreCase("hibernate");
    Optional<Post> one = postRepository.findOne(predicate);
    assertThat(one).isNotEmpty();

  }
}