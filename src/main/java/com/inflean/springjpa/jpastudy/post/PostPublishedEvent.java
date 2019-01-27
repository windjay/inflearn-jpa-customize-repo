package com.inflean.springjpa.jpastudy.post;

import org.springframework.context.ApplicationEvent;

public class PostPublishedEvent  extends ApplicationEvent {

  private Post post;

  public PostPublishedEvent(Object source) {
    super(source);
    this.post = (Post) source;
  }

  public Post getPost() {
    return post;
  }
}
