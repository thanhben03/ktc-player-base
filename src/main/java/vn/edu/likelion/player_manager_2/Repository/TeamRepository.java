package vn.edu.likelion.player_manager_2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.likelion.player_manager_2.Entity.TeamEntity;

public interface TeamRepository extends JpaRepository<TeamEntity, Integer> {
}
