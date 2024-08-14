package vn.edu.likelion.player_manager_2.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.player_manager_2.Entity.PlayerEntity;
import vn.edu.likelion.player_manager_2.Model.PlayerDTO;
import vn.edu.likelion.player_manager_2.Repository.PlayerRepository;
import vn.edu.likelion.player_manager_2.Service.PlayerService;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerEntity create(PlayerDTO playerDTO) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(playerDTO.getName());
        playerEntity.setYearOfBirth(playerDTO.getYear_of_birth());
        playerEntity.setCountry(playerDTO.getCountry());
        playerEntity.setHeight(playerDTO.getHeight());
        playerEntity.setWeigh(playerDTO.getWeigh());
        playerEntity.setPosition(playerDTO.getPosition());
        playerEntity.setFavorableFoot(playerDTO.getFavorable_foot());
        playerEntity.setTeamId(playerDTO.getTeam_id());

        return playerRepository.save(playerEntity);
    }


    @Override
    public PlayerEntity save(PlayerEntity playerEntity) {
        return playerRepository.save(playerEntity);
    }

    @Override
    public void remove(int id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Iterable<PlayerEntity> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public PlayerEntity findById(int id) {
        return playerRepository.findById(id).orElseThrow(()-> new RuntimeException("Player not found"));
    }

    public PlayerEntity update(int id, PlayerDTO playerDTO) {
        PlayerEntity playerEntity = playerRepository.findById(id).get();

        playerEntity.setName(playerDTO.getName());
        playerEntity.setYearOfBirth(playerDTO.getYear_of_birth());
        playerEntity.setCountry(playerDTO.getCountry());
        playerEntity.setHeight(playerDTO.getHeight());
        playerEntity.setWeigh(playerDTO.getWeigh());
        playerEntity.setPosition(playerDTO.getPosition());
        playerEntity.setFavorableFoot(playerDTO.getFavorable_foot());
        playerEntity.setTeamId(playerDTO.getTeam_id());

        return playerEntity;
    }

}
