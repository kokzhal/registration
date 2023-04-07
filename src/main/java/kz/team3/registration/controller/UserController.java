package kz.team3.registration.controller;

import kz.team3.registration.entity.User;
import kz.team3.registration.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
/*
    @GetMapping("/list")
    public List<User> getStudents() throws IllegalAccessException {
        return userService.getUsers();
    }*/
    @GetMapping()
    public List<User>  getStudents() throws IllegalAccessException{
        return userService.getUsers();
    }
/*
    @GetMapping("/{email}")
    public User getStudent(@PathVariable("email") String email) {
        return userService.getStudentByEmail(email);
    }*/

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
}
