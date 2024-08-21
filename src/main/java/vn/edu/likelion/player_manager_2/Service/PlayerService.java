package vn.edu.likelion.player_manager_2.Service;


import vn.edu.likelion.player_manager_2.Entity.PlayerEntity;
import vn.edu.likelion.player_manager_2.Model.PlayerDTO;

import java.util.List;
import java.util.Map;

public interface PlayerService extends BaseService<PlayerEntity, PlayerDTO> {
    Map<String, Object> compare(int player_1, int player_2);
    Iterable<PlayerEntity> sort(String type, String order);
    List<PlayerEntity> search(String q);
}
