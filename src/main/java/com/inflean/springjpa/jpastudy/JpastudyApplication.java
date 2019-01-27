package com.inflean.springjpa.jpastudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = SimpleMyRepository.class)
public class JpastudyApplication {

  public static void main(String[] args) {
    SpringApplication.run(JpastudyApplication.class, args);
  }

}

