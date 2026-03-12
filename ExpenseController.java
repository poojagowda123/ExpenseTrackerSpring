package com.expensetracker.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.expensetracker.dao.ExpenseDao;
import com.expensetracker.model.Expense;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseDao expenseDao;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        String username = (String) session.getAttribute("user");

        if(username == null)
            return "redirect:/login";

        List<Expense> list = expenseDao.getExpenses(username);

        double total = 0;
        for(Expense e : list) {
            total += e.getAmount();
        }

        model.addAttribute("expenses", list);
        model.addAttribute("totalExpense", total);
        model.addAttribute("expenseCount", list.size());

        return "dashboard";
    }

    @GetMapping("/addExpense")
    public String addExpense(HttpSession session) {

        if(session.getAttribute("user") == null)
            return "redirect:/login";

        return "addExpense";
    }

    @PostMapping("/saveExpense")
    public String saveExpense(@RequestParam String title,
                              @RequestParam double amount,
                              @RequestParam String category,
                              @RequestParam String expense_date,
                              HttpSession session) {

        String username = (String) session.getAttribute("user");

        if(username == null)
            return "redirect:/login";

        Expense e = new Expense();
        e.setUsername(username);
        e.setTitle(title);
        e.setAmount(amount);
        e.setCategory(category);
        e.setExpenseDate(expense_date);

        expenseDao.addExpense(e);

        return "redirect:/dashboard";
    }
    
    @PostMapping("/updateExpense")
    public String updateExpense(@RequestParam int id,
                                @RequestParam String title,
                                @RequestParam double amount,
                                @RequestParam String category,
                                @RequestParam String expense_date,
                                HttpSession session) {

        if(session.getAttribute("user") == null)
            return "redirect:/login";

        Expense e = new Expense();
        e.setId(id);
        e.setTitle(title);
        e.setAmount(amount);
        e.setCategory(category);
        e.setExpenseDate(expense_date);

        expenseDao.updateExpense(e);

        return "redirect:/viewExpenses";
    }

    @GetMapping("/deleteExpense/{id}")
    public String deleteExpense(@PathVariable int id,
                                HttpSession session) {

        if(session.getAttribute("user") == null)
            return "redirect:/login";

        expenseDao.deleteExpense(id);

        return "redirect:/dashboard";
    }
    @GetMapping("/editExpense/{id}")
    public String editExpense(@PathVariable int id,
                              Model model,
                              HttpSession session) {

        if(session.getAttribute("user") == null)
            return "redirect:/login";

        String sqlUser = (String) session.getAttribute("user");

        Expense e = expenseDao.getExpenses(sqlUser)
                              .stream()
                              .filter(exp -> exp.getId() == id)
                              .findFirst()
                              .orElse(null);

        model.addAttribute("expense", e);

        return "editExpense";
    }
    @GetMapping("/viewExpenses")
    public String viewExpenses(Model model, HttpSession session) {

        String username = (String) session.getAttribute("user");

        if(username == null)
            return "redirect:/login";

        List<Expense> list = expenseDao.getExpenses(username);
        model.addAttribute("expenses", list);

        return "viewExpenses";
    }
}