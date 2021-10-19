package in.tatsam.priority.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tatsam.priority.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	User findByEmailId(String emailId);
}
