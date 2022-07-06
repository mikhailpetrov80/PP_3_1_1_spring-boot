package com.example.PP_3_1_1_springboot.controller;

import com.example.PP_3_1_1_springboot.model.User;
import com.example.PP_3_1_1_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String printUsers(Model userModel) {
        userModel.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/addUser")
    public String newUser(Model userModel) {
        userModel.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/{id}")
    public String getByIdUser(@PathVariable("id") long id, Model userModel) {
        userModel.addAttribute("user", userService.getUserId(id));
        return "user";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserId(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String editUser(Model userModel, @PathVariable("id") long id) {
        userModel.addAttribute("user", userService.getUserId(id));
        return "/update";
    }


    @PatchMapping("/{id}/users")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
