package org.sid.coursservice;

import org.sid.coursservice.entities.Cour;
import org.sid.coursservice.repository.CourRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CoursServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CourRepository courRepository, RepositoryRestConfiguration restConfiguration) {
        return args -> {
            restConfiguration.exposeIdsFor(Cour.class);
            courRepository.saveAll(
                    List.of(
                            Cour.builder().name("SOA").section("DSI").image("link1").niveau(1).build(),
                            Cour.builder().name("Flutter").section("SEM").image("link2").niveau(2).build(),
                            Cour.builder().name("Mobile").section("RSI").image("link3").niveau(3).build()
                            )
            );
            courRepository.findAll().forEach(p -> {
                System.out.println(p);
            });

        };
    }
}

