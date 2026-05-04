package autobid.autobid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import autobid.autobid.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);
}