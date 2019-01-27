package com.inflean.springjpa.jpastudy.post;

import java.util.List;

public interface PostCommonRepository {
  List<Post> findMyPost();
}

