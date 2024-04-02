package com.api.icabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NotificatorServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(NotificatorServiceApplication.class, args);

    System.out.println("hello test");
  }

}
