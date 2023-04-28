package kz.team3.registration.service;

import kz.team3.registration.dto.UserRequestDto;
import kz.team3.registration.entity.User;
import kz.team3.registration.repository.UserRepository;

import java.util.List;

public interface UserService {
    List<User> getUsers() throws IllegalAccessException;

    void createUser(UserRequestDto userRequestDto);

    void addUser(UserRequestDto userRequestDto);



    User registerUserToBed(Long userId, Long bedId);

    void updateBalance(Long id, Double amount);

    User getUserById(Long userId);

    void deleteUser(Long userId);

    User updateUser(Long id, User updatedUser);

    User updateUserPassword(Long id, String newPassword);

}
