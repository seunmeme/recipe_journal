package com.seunmeme.recipesjournal.service.serviceImpl;

import com.seunmeme.recipesjournal.model.User;
import com.seunmeme.recipesjournal.repository.UserRepository;
import com.seunmeme.recipesjournal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String login(User user, Model model, HttpSession session) {

        try {
            Optional<User> checkUser = Optional.ofNullable(findByEmail(user.getEmail()));
            if(checkUser.get().getPassword().equals(user.getPassword()) ){
                session.setAttribute("user", checkUser.get());
                model.addAttribute("user", checkUser.get());
            }
        }catch(Exception ex){
            return "redirect:/";
        }
        return "redirect:/recipes";
    }



    @Override
    public String register(User user, Model model, HttpSession session ) {
//        if the user already exists, return to home page
        if(existsByEmail(user.getEmail())){
            return "redirect:/";
        }else{
            User theUser = findByEmail(user.getEmail());
            userRepository.save(user);
            session.setAttribute("usee", theUser);
            model.addAttribute("user", theUser);

            return "redirect:/recipes";
        }

    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
}
