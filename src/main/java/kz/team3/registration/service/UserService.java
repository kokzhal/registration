package kz.team3.registration.service;

import kz.team3.registration.entity.Role;
import kz.team3.registration.entity.User;
import kz.team3.registration.repository.RoleRepository;
import kz.team3.registration.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public List<User> getUsers() throws IllegalAccessException {

//        User user = userRepository.findById(1).orElseThrow(() -> new IllegalStateException("User not found with id: "))
//
//        Role role = roleRepository.findById(user.getRoleId()).get();
//
//        if (role == null || role.getRoleType() == Role.RoleType.USER) {
//            throw new IllegalAccessException("Access denied!");
//        }

        return userRepository.findAll();
    }
/*
    public User getStudentByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }*/

    public void createUser(User user) {
        Optional<Role> optionalRole = roleRepository.findById(user.getRoleId());
        Optional<User> optionalUser = userRepository.findFirstByEmail(user.getEmail());
/*
        if (optionalRole.isEmpty()) {
            throw new IllegalArgumentException("Bad request: role not found!");
        }*/
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("Bad request: email taken!");
        }

        // business logic

        userRepository.save(user);
    }
}
