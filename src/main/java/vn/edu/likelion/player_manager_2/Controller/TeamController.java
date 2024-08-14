package vn.edu.likelion.player_manager_2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.player_manager_2.Entity.TeamEntity;
import vn.edu.likelion.player_manager_2.Model.TeamDTO;
import vn.edu.likelion.player_manager_2.Service.Impl.TeamServiceImpl;
import vn.edu.likelion.player_manager_2.Util.ResponseHandler;

@RestController
@RequestMapping("/api/v1/team")
@CrossOrigin
public class TeamController {

    @Autowired
    private TeamServiceImpl teamServiceImpl;
    @PostMapping
    private ResponseEntity<Object> insertTeam(@RequestBody TeamDTO teamDTO) {
        try {
            TeamEntity teamEntity = teamServiceImpl.create(teamDTO);
            return ResponseHandler.generateResponse(HttpStatus.OK, false,
                    "Insert Success!", teamEntity);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true, "Failed!", e.getMessage());
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<Object> updateTeam(@PathVariable int id, @RequestBody TeamDTO teamDTO) {
        try {
            TeamEntity teamEntity = teamServiceImpl.update(id, teamDTO);
            return ResponseHandler.generateResponse(HttpStatus.OK, false,
                    "Update Success!", teamEntity);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true, "Failed!", e.getMessage());
        }
    }

    @GetMapping
    private ResponseEntity<Object> findAllTeam() {
        try {
            Iterable<TeamEntity> teamEntityList = teamServiceImpl.findAll();
            return ResponseHandler.generateResponse(HttpStatus.OK, false,
                    "Find Success!", teamEntityList);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true,
                    "Failed!", e.getMessage());
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<Object> findById(@PathVariable int id) {
        try {
            TeamEntity teamEntity = teamServiceImpl.findById(id);
            return ResponseHandler.generateResponse(HttpStatus.OK, false,
                    "Find Success!", teamEntity);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true,
                    "Failed!", e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deletePlayer(@PathVariable int id) {
        try {
            teamServiceImpl.remove(id);
            return ResponseHandler.generateResponse(HttpStatus.OK, false,
                    "Delete Success!", teamServiceImpl);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true,
                    "Failed!", e.getMessage());
        }
    }
}