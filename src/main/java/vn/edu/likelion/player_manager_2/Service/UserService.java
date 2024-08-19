package vn.edu.likelion.player_manager_2.Service;

import vn.edu.likelion.player_manager_2.Entity.PlayerEntity;
import vn.edu.likelion.player_manager_2.Entity.UserEntity;

public interface UserService extends BaseService<UserEntity> {
    UserEntity save(UserEntity userEntity);
}
