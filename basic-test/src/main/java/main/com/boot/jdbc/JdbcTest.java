package main.com.boot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("jdbc")
public class JdbcTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("test")
    public List<Map<String, Object>> findAll() {
        String sql = "select * from student";
        return jdbcTemplate.queryForList(sql);
    }
}
