package vn.edu.likelion.player_manager_2.Service;

import vn.edu.likelion.player_manager_2.Entity.PlayerEntity;
import vn.edu.likelion.player_manager_2.Entity.UserEntity;
import vn.edu.likelion.player_manager_2.Model.UserDTO;

public interface UserService extends BaseService<UserEntity, UserDTO> {
    UserEntity save(UserEntity userEntity);
}
