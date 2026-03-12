package com.expensetracker.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void registerUser(String username, String email, String password) {

        String sql = "INSERT INTO users(username,email,password) VALUES(?,?,?)";

        jdbcTemplate.update(sql, username, email, password);
    }

    public boolean validateUser(String username, String password) {

        String sql = "SELECT COUNT(*) FROM users WHERE username=? AND password=?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, username, password);

        return count != null && count > 0;
    }
}