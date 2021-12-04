package com.example.bootdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Slf4j
@SpringBootTest
class BootdemoApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
        List<Long> longs = jdbcTemplate.queryForList("select count(*) from book", long.class);
        log.info("记录数{}",longs);

    }

}
