package br.com.washington.stress_test_tomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class StressTestTomcatApplication {

    public static void main(String[] args) {
        SpringApplication.run(StressTestTomcatApplication.class, args);
    }

}
