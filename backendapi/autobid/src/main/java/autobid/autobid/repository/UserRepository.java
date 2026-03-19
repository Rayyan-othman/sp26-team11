package autobid.autobid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import autobid.autobid.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}