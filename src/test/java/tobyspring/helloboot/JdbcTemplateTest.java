package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest
public class JdbcTemplateTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("INSERT INTO hello VALUES (?, ?)", "JR", 3);
        jdbcTemplate.update("INSERT INTO hello VALUES (?, ?)", "Spring", 1);

        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM hello", Long.class);
        Assertions.assertThat(count).isEqualTo(2);
    }

}
