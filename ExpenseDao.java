package com.expensetracker.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.expensetracker.model.Expense;

@Repository
public class ExpenseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // ADD EXPENSE
    public void addExpense(Expense e) {

        String sql = "INSERT INTO expenses(username,title,amount,category,expense_date) VALUES(?,?,?,?,?)";

        jdbcTemplate.update(sql,
                e.getUsername(),
                e.getTitle(),
                e.getAmount(),
                e.getCategory(),
                e.getExpenseDate());
    }

    // GET ALL EXPENSES FOR USER
    public List<Expense> getExpenses(String username) {

        String sql = "SELECT * FROM expenses WHERE username=?";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Expense.class),
                username);
    }

    // DELETE EXPENSE
    public void deleteExpense(int id) {

        String sql = "DELETE FROM expenses WHERE id=?";

        jdbcTemplate.update(sql, id);
    }

    // UPDATE EXPENSE
    public void updateExpense(Expense e) {

        String sql = "UPDATE expenses SET title=?, amount=?, category=?, expense_date=? WHERE id=?";

        jdbcTemplate.update(sql,
                e.getTitle(),
                e.getAmount(),
                e.getCategory(),
                e.getExpenseDate(),
                e.getId());
    }

    // GET SINGLE EXPENSE BY ID (FOR EDIT PAGE)
    public Expense getExpenseById(int id) {

        String sql = "SELECT * FROM expenses WHERE id=?";

        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Expense.class),
                id);
    }
}