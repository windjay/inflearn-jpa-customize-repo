package com.inflean.springjpa.jpastudy.post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostRepositoryTestConfig {
  @Bean
  public ApplicationListener<PostPublishedEvent> postListener() {
    return event -> {
      // 이벤트 퍼블리싱...
      System.out.println("------------------------------");
      System.out.println(event.getPost().getTitle() + " is published");
      System.out.println("------------------------------");
    };

//    return new PostListener();
  }
}
