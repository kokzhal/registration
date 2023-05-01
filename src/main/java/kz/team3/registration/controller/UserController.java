package kz.team3.registration.controller;

import kz.team3.registration.dto.UserRequestDto;
import kz.team3.registration.entity.Bed;
import kz.team3.registration.entity.User;
import kz.team3.registration.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("api/v1/user/list")
    public List<User> getUsers() throws IllegalAccessException {
        return userService.getUsers();
    }

    @PostMapping("api/v1/user/create")
    public void createUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        userService.createUser(userRequestDto);
    }

    @PostMapping("api/v1/user/addUser")
    public void addUser(@RequestBody @Valid UserRequestDto userRequestDto) {

        userService.addUser(userRequestDto);
    }

    @PutMapping("api/v1/users/{userId}/beds")
    public ResponseEntity<User> giveBedToUser(@PathVariable Long userId, @RequestBody Bed bed) {
        User updatedUser = userService.registerUserToBed(userId, bed.getId());
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("api/v1/{id}/balance")
    public void updateBalance(@PathVariable Long id, @RequestParam Double amount) {
        userService.updateBalance(id, amount);
    }

    @GetMapping("api/v1/get/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("api/v1/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("api/v1/update/{id}/password")
    public User updateUserPassword(@PathVariable Long id, @RequestBody String newPassword) {
        return userService.updateUserPassword(id, newPassword);
    }

    @PutMapping("api/v1/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
}
