package com.example.RestGet.controller;

import com.example.RestGet.model.Users;
import com.example.RestGet.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List findAll() {
        System.out.println("Controller started...");
        return userService.findAll();
    }

    @PostMapping
    public Users create(@RequestBody Users users) {
        System.out.println("Post methodu çalıştı.Yeni bir kişi eklendi.");
        return userService.create(users);
    }

    public Users update(@RequestBody Users users ) {
        System.out.println("Put methodu çalıştı. Kişi güncelenmesi yapıldı.");
        return userService.update(users);
    }

    @DeleteMapping
    public Users delete(@RequestBody Users users) {
        System.out.println("Delete methodu çalıştı. Kişi silindi.");
        return userService.delete(users);
    }
}