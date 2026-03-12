package com.expensetracker.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.expensetracker.dao.UserDao;

@Controller
public class LoginController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/registerUser")
    public String register(@RequestParam String username,
                           @RequestParam String email,
                           @RequestParam String password) {

        userDao.registerUser(username, email, password);
        return "redirect:/login";
    }

    // 🔥 FIXED LOGIN METHOD
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpServletRequest request) {

        boolean valid = userDao.validateUser(username, password);

        if(valid) {
            HttpSession session = request.getSession(true); // create session ONLY after success
            session.setAttribute("user", username);
            return "redirect:/dashboard";
        }

        return "login";
    }

    // 🔥 FIXED LOGOUT METHOD
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        // Get correct context path
        String contextPath = request.getContextPath();

        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        cookie.setPath(contextPath);  
        response.addCookie(cookie);

        return "login";   // do not redirect
    }
}