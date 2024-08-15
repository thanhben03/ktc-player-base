package vn.edu.likelion.player_manager_2.Service;

import vn.edu.likelion.player_manager_2.Entity.PlayerEntity;
import vn.edu.likelion.player_manager_2.Entity.TeamEntity;

public interface UserService extends BaseService<TeamEntity> {
    PlayerEntity save(PlayerEntity playerEntity);
}
