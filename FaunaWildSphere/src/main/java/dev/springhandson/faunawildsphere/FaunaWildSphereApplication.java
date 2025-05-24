package dev.springhandson.faunawildsphere;

import dev.springhandson.faunawildsphere.config.Config;
import dev.springhandson.faunawildsphere.entity.Lion;
import dev.springhandson.faunawildsphere.entity.Tiger;
import dev.springhandson.faunawildsphere.repository.LionRepository;
import dev.springhandson.faunawildsphere.repository.TigerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FaunaWildSphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaunaWildSphereApplication.class, args);
    }

@Bean
public CommandLineRunner dataLoader(
            Config config,
            LionRepository lionRepository,
            TigerRepository tigerRepository) {
        return args -> {
            Lion lion = config.lionBean();
            Tiger tiger = config.tigerBean();

            lionRepository.save(lion);
            tigerRepository.save(tiger);
        };
    }

}
