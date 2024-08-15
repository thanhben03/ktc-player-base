package vn.edu.likelion.player_manager_2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.likelion.player_manager_2.Entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsernameAndPassword(String username, String password);
    Optional<UserEntity> findByUsername(String username);
}
