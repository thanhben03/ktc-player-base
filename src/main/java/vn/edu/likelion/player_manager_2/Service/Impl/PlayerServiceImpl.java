package vn.edu.likelion.player_manager_2.Service.Impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.player_manager_2.Entity.PlayerEntity;
import vn.edu.likelion.player_manager_2.Entity.TeamEntity;
import vn.edu.likelion.player_manager_2.Model.PlayerDTO;
import vn.edu.likelion.player_manager_2.Repository.PlayerRepository;
import vn.edu.likelion.player_manager_2.Repository.TeamRepository;
import vn.edu.likelion.player_manager_2.Response.PlayerCompare;
import vn.edu.likelion.player_manager_2.Service.PlayerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    public PlayerEntity create(PlayerDTO playerDTO) {
        TeamEntity teamEntity = teamRepository.findById(playerDTO.getTeam_id()).get();
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(playerDTO.getName());
        playerEntity.setAvatar(playerDTO.getAvatar());
        playerEntity.setYearOfBirth(playerDTO.getYear_of_birth());
        playerEntity.setCountry(playerDTO.getCountry());
        playerEntity.setHeight(playerDTO.getHeight());
        playerEntity.setWeigh(playerDTO.getWeigh());
        playerEntity.setPosition(playerDTO.getPosition());
//        playerEntity.setFavorableFoot(playerDTO.getFavorable_foot());
        playerEntity.setTeam(teamEntity);
        playerEntity.setSalary(playerDTO.getSalary());
        playerEntity.setBc(playerDTO.getBc());
        playerEntity.setLs(playerDTO.getLs());
        playerEntity.setSs(playerDTO.getSs());
        playerEntity.setSp(playerDTO.getSp());
        return playerRepository.save(playerEntity);
    }


    @Override
    public PlayerEntity save(PlayerEntity playerEntity) {
        return playerRepository.save(playerEntity);
    }

    @Override
    public void remove(int id) throws EntityNotFoundException{
        PlayerEntity playerEntity = playerRepository.findById(id).get();
        if (playerEntity.getId() != 0)
            playerRepository.deleteById(id);
        else
            throw new EntityNotFoundException("Player not found");
    }

    @Override
    public Iterable<PlayerEntity> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public PlayerEntity findById(int id) {
        return playerRepository.findById(id).orElseThrow(()-> new RuntimeException("Player not found"));
    }

    @Override
    public PlayerEntity update(int id, PlayerDTO playerDTO) {
        PlayerEntity playerEntity = playerRepository.findById(id).get();
        TeamEntity teamEntity = teamRepository.findById(playerDTO.getTeam_id()).get();

        playerEntity.setName(playerDTO.getName());
        playerEntity.setAvatar(playerDTO.getAvatar());
        playerEntity.setYearOfBirth(playerDTO.getYear_of_birth());
        playerEntity.setCountry(playerDTO.getCountry());
        playerEntity.setHeight(playerDTO.getHeight());
        playerEntity.setWeigh(playerDTO.getWeigh());
        playerEntity.setPosition(playerDTO.getPosition());
//        playerEntity.setFavorableFoot(playerDTO.getFavorable_foot());
        playerEntity.setTeam(teamEntity);
        playerEntity.setBc(playerDTO.getBc());
        playerEntity.setSalary(playerDTO.getSalary());
        playerEntity.setLs(playerDTO.getLs());
        playerEntity.setSs(playerDTO.getSs());
        playerEntity.setSp(playerDTO.getSp());
        return playerRepository.save(playerEntity);
    }

    @Override
    public Map<String, Object> compare(int player_1, int player_2) {
        HashMap<String, Object> player = new HashMap<>();
        HashMap<Integer, Object> infoPlayer = new HashMap<>();
        PlayerEntity player1 = playerRepository.findById(player_1).get();
        PlayerEntity player2 = playerRepository.findById(player_2).get();

        infoPlayer.put(0, player1);
        infoPlayer.put(1, player2);

        PlayerCompare playerCompare1 = new PlayerCompare();
        PlayerCompare playerCompare2 = new PlayerCompare();

        HashMap<Integer, Object> compare = new HashMap<>();

        playerCompare1.setSp(player1.getSp() - player2.getSp());
        playerCompare2.setSp(player2.getSp() - player1.getSp());

        playerCompare1.setSs(player1.getSs() - player2.getSs());
        playerCompare2.setSs(player2.getSs() - player1.getSs());

        playerCompare1.setLs(player1.getLs() - player2.getLs());
        playerCompare2.setLs(player2.getLs() - player1.getLs());

        playerCompare1.setBc(player1.getBc() - player2.getBc());
        playerCompare2.setBc(player2.getBc() - player1.getBc());

        compare.put(0, playerCompare1);
        compare.put(1, playerCompare2);

        player.put("player", infoPlayer);
        player.put("compare", compare);

        return player;
    }

    public Iterable<PlayerEntity> sort(String type, String order) {
        Iterable<PlayerEntity> playerEntities = null;

        switch (type) {
            case "position":
                if (order.equals("desc"))
                    playerEntities = playerRepository.findByOrderByPositionDesc();
                else
                    playerEntities = playerRepository.findByOrderByPositionAsc();
                break;
            case "salary":
                if (order.equals("desc"))
                    playerEntities = playerRepository.findByOrderBySalaryDesc();
                else
                    playerEntities = playerRepository.findByOrderBySalaryAsc();
                break;
        }
        return playerEntities;
    }


    //filter theo position & teamName
    @Override
    public List<PlayerEntity> search(String q) {

        return playerRepository.findByNameContaining(q);
    }


}
