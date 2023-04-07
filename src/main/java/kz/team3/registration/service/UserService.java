package kz.team3.registration.service;

import kz.team3.registration.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers() throws IllegalAccessException;

    void createUser(User user);
}
