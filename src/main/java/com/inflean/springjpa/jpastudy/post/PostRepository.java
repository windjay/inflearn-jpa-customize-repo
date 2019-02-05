package com.inflean.springjpa.jpastudy.post;

import com.inflean.springjpa.jpastudy.MyRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository  extends MyRepository<Post, Long>, QuerydslPredicateExecutor<Post> {
  // querydsl 인터페이스 상속함
}
