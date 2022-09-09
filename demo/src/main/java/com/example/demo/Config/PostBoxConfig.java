package com.example.demo.Config;

import com.example.demo.Repositories.PostBoxRepo;
import com.example.demo.modells.PostBox;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PostBoxConfig {

    @Bean
    CommandLineRunner commandLineRunner(PostBoxRepo postBoxRepo) {
        return args -> {
                    PostBox A = new PostBox("A", 10, 10, 0, 0);
                    PostBox B = new PostBox("B", 5, 5, 0, 0);

                    postBoxRepo.saveAll(List.of(A,B));
        };
    }
}
