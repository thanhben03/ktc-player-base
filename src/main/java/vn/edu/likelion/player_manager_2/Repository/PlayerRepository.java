package vn.edu.likelion.player_manager_2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.player_manager_2.Entity.PlayerEntity;
import vn.edu.likelion.player_manager_2.Model.FilterRequest;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {

    Iterable<PlayerEntity> findByOrderByPositionDesc();
    Iterable<PlayerEntity> findByOrderByPositionAsc();

    Iterable<PlayerEntity> findByOrderBySalaryDesc();
    Iterable<PlayerEntity> findByOrderBySalaryAsc();

    List<PlayerEntity> findByTeamId(int team_id);
    List<PlayerEntity> findByPosition(String position);

    List<PlayerEntity> findByPositionAndTeamId(String position, int team_id);


//    Iterable<PlayerEntity> findByPositionOrTeamName();

    List<PlayerEntity> findByNameContaining(String name);


}
