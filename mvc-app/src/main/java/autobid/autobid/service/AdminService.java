package autobid.autobid.service;

import autobid.autobid.entity.User;
import autobid.autobid.repository.ServiceRepository;
import autobid.autobid.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;

    public AdminService(UserRepository userRepository, ServiceRepository serviceRepository) {
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
    }

    public User createUser(User user) {
        if (userRepository.existsByEmailIgnoreCase(user.getEmail())) {
            throw new RuntimeException("Email already exists.");
        }

        if (user.getAccountStatus() == null || user.getAccountStatus().isBlank()) {
            user.setAccountStatus("ACTIVE");
        }

        if (user.getRole() != null) {
            user.setRole(user.getRole().toUpperCase());
        }

        return userRepository.save(user);
    }

    public User login(User loginRequest) {
        User user = userRepository.findByEmailIgnoreCase(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found."));

        if (user.getPassword() == null || !user.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Invalid password.");
        }

        if (loginRequest.getRole() != null &&
                !user.getRole().equalsIgnoreCase(loginRequest.getRole())) {
            throw new RuntimeException("Invalid role.");
        }

        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setRole(updatedUser.getRole());

        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isBlank()) {
            existingUser.setPassword(updatedUser.getPassword());
        }

        if (updatedUser.getAccountStatus() != null) {
            existingUser.setAccountStatus(updatedUser.getAccountStatus());
        }

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        User existingUser = getUserById(id);

        boolean hasServices = serviceRepository.existsByProviderId(id);

        if (hasServices) {
            throw new RuntimeException("Cannot delete this user because they still own services.");
        }

        userRepository.delete(existingUser);
    }
}