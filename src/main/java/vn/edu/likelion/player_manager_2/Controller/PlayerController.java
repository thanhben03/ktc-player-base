package vn.edu.likelion.player_manager_2.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.player_manager_2.Entity.PlayerEntity;
import vn.edu.likelion.player_manager_2.Model.PlayerDTO;
import vn.edu.likelion.player_manager_2.Service.Impl.PlayerServiceImpl;
import vn.edu.likelion.player_manager_2.Util.ResponseHandler;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
@CrossOrigin
public class PlayerController {
    @Autowired
    private PlayerServiceImpl playerService;

    @PostMapping
    private ResponseEntity<Object> insertPlayer(@RequestBody PlayerDTO playerDTO) {
        try {
            PlayerEntity playerEntity = playerService.create(playerDTO);
            return ResponseHandler.generateResponse(HttpStatus.OK, false,
                    "Insert Success!", playerEntity);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true, "Failed!", e.getMessage());
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<Object> updatePlayer(@PathVariable int id, @RequestBody PlayerDTO playerDTO) {
        try {
            PlayerEntity playerEntity = playerService.update(id, playerDTO);
            return ResponseHandler.generateResponse(HttpStatus.OK, false,
                    "Update Success!", playerEntity);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true, "Failed!", e.getMessage());
        }
    }

    @GetMapping
    private ResponseEntity<Object> findAllPlayer() {
        try {
            Iterable<PlayerEntity> playerEntityList = playerService.findAll();
            return ResponseHandler.generateResponse(HttpStatus.OK, false,
                    "Find Success!", playerEntityList);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true,
                    "Failed!", e.getMessage());
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<Object> findById(@PathVariable int id) {
        try {
            PlayerEntity playerEntity = playerService.findById(id);
            return ResponseHandler.generateResponse(HttpStatus.OK, false,
                    "Find Success!", playerEntity);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true,
                    "Failed!", e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deletePlayer(@PathVariable int id) {
        try {
            playerService.remove(id);
            return ResponseHandler.generateResponse(HttpStatus.OK, false,
                    "Delete Success!", playerService);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true,
                    "Failed!", e.getMessage());
        }
    }

    @GetMapping("/search/{id}")
    private ResponseEntity<Object> search(@PathVariable int id) {
        try {
            PlayerEntity playerEntity = playerService.findById(id);
            return ResponseHandler.generateResponse(HttpStatus.OK, false,
                    "Success!", playerEntity);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true,
                    "Failed!", e.getMessage());
        }
    }

    @GetMapping("/sort")
    private ResponseEntity<Object> sort(@RequestParam String type, @RequestParam String order) {
        try {
            Iterable<PlayerEntity> playerEntities = playerService.sort(type, order);
            return ResponseHandler.generateResponse(HttpStatus.OK, false,
                    "Success!", playerEntities);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true,
                    "Failed!", e.getMessage());
        }
    }


//    @PostMapping("/compare")
//    private ResponseEntity<Object> compare(@RequestParam int player_1, @RequestParam int player_2) {
//
//    }
}

