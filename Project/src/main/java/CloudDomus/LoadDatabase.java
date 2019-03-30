package CloudDomus;

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(WorkerRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Works("A", 2, "a")));
            log.info("Preloading " + repository.save(new Works("B", 3, "b")));
        };
    }
}