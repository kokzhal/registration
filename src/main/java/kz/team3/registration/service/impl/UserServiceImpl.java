package kz.team3.registration.service.impl;

import kz.team3.registration.ResourceNotFoundException;
import kz.team3.registration.dto.UserRequestDto;
import kz.team3.registration.entity.Bed;
import kz.team3.registration.entity.User;
import kz.team3.registration.entity.UserRole;
import kz.team3.registration.repository.BedRepository;
import kz.team3.registration.repository.UserRepository;
import kz.team3.registration.service.BedService;
import kz.team3.registration.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BedRepository bedRepository;
    private final BedService bedService;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(UserRequestDto userRequestDto) {
        userRequestDto.setUserRole(UserRole.ROLE_USER);
        addUser(userRequestDto);
    }

    @Override
    public void addUser(UserRequestDto userRequestDto) {
        userRepository.findFirstByEmail(userRequestDto.getEmail()).ifPresent(
                user -> {
                    throw new IllegalStateException("Bad request: email taken!");
                }
        );

        User user = userRequestDtoToUser(userRequestDto);
        userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities()
        );
    }

    public void updateBalance(Long userId, Double amount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Double newBalance = user.getBalance() + amount;
        if (newBalance < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        user.setBalance(newBalance);
        userRepository.save(user);
    }

    public User userRequestDtoToUser(UserRequestDto userRequestDto){
        User user = new User();
        user.setStudentId(userRequestDto.getStudentId());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setFirstname(userRequestDto.getFirstname());
        user.setLastname(userRequestDto.getLastname());
        user.setEmail(userRequestDto.getEmail());
        user.setPhone(userRequestDto.getPhone());
        user.setProgram(userRequestDto.getProgram());
        user.setCourse(userRequestDto.getCourse());
        user.setRole(userRequestDto.getUserRole());

        return user;
    }

    @Override
    public User registerUserToBed(Long userId, String bedId) {
        log.info("Registering user, userId: {}, bedId {}", userId, bedId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        Bed bed = bedRepository.findById(bedId)
                .orElseThrow(() -> new ResourceNotFoundException("Bed not found with id: " + bedId));

        if (!bed.getStatus().equals("available")) {
            throw new RuntimeException("Bed is not available for registration");
        }

        user.setBedId(bedId);
        userRepository.save(user);

        bed.setStatus("unavailable");
        bedRepository.save(bed);

        log.info("Successfully saved user, userId: {}, bedId {}", userId, bedId);

        return user;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User not found with id: " + id));

        user.setFirstname(updatedUser.getFirstname());
        user.setLastname(updatedUser.getFirstname());


        return userRepository.save(user);
    }

    public User updateUserPassword(Long id, String newPassword) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User not found with id: " + id));

        user.setPassword(passwordEncoder.encode(newPassword));

        return userRepository.save(user);
    }

    public User updateUserBed(Long userId, String bedId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        Bed bed = bedRepository.findById(bedId)
                .orElseThrow(() -> new ResourceNotFoundException("Bed not found with id: " + bedId));

        int cost = bedService.getBedCost();

        if (user.getBalance() < cost) {
            throw new RuntimeException("Insufficient balance to take bed");
        }

        user.setAssignedBed(bed);

        user.setBalance(user.getBalance() - cost);

        return userRepository.save(user);
    }

}


