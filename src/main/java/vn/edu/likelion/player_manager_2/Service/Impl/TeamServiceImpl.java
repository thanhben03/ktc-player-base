package vn.edu.likelion.player_manager_2.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.player_manager_2.Entity.TeamEntity;
import vn.edu.likelion.player_manager_2.Model.TeamDTO;
import vn.edu.likelion.player_manager_2.Repository.TeamRepository;
import vn.edu.likelion.player_manager_2.Service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public TeamEntity create(TeamDTO teamDTO) {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setName(teamDTO.getName());
        teamEntity.setCity(teamDTO.getCity());

        return teamRepository.save(teamEntity);
    }

    @Override
    public TeamEntity save(TeamEntity teamEntity) {
        return teamRepository.save(teamEntity);
    }

    @Override
    public void remove(int id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Iterable<TeamEntity> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public TeamEntity findById(int id) {
        return teamRepository.findById(id).orElseThrow(()-> new RuntimeException("Team not found"));
    }

    public TeamEntity update(int id, TeamDTO teamDTO) {
        TeamEntity teamEntity = teamRepository.findById(id).get();

        teamEntity.setName(teamDTO.getName());
        teamEntity.setCity(teamDTO.getCity());

        return teamRepository.save(teamEntity);
    }
}