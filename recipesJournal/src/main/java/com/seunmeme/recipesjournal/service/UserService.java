package com.seunmeme.recipesjournal.service;

import com.seunmeme.recipesjournal.model.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface UserService {

    public String register(User user, Model model, HttpSession session);
    public String login(User user, Model model, HttpSession session);
    public User findByEmail(String email);
    public boolean existsByEmail(String email);

}
