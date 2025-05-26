package tobyspring.helloboot;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class HellobootApplication {

    private final JdbcTemplate jdbcTemplate;

    public HellobootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute("CREATE table IF NOT EXISTS hello(name VARCHAR(50) PRIMARY KEY, count INT)");
    }

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }

}
