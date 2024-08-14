package vn.edu.likelion.player_manager_2.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.player_manager_2.Entity.PlayerEntity;
import vn.edu.likelion.player_manager_2.Model.PlayerDTO;
import vn.edu.likelion.player_manager_2.Service.Impl.PlayerServiceImpl;
import vn.edu.likelion.player_manager_2.Service.PlayerService;
import vn.edu.likelion.player_manager_2.Util.ResponseHandler;

@RestController
@RequestMapping("/api/player")
@CrossOrigin
public class PlayerController {
    @Autowired
    private PlayerServiceImpl playerService;

    @PostMapping
    private PlayerEntity insertPlayer(@RequestBody PlayerDTO playerDTO){
        return playerService.create(playerDTO);
    }
    @PutMapping("/{id}")
    private PlayerEntity updatePlayer (@PathVariable int id,@RequestBody PlayerDTO playerDTO){

        return playerService.update(id, playerDTO);
    }

    @GetMapping
    private Iterable<PlayerEntity> findAllPlayer(){
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Object> findById(@PathVariable int id){
        try {
             PlayerEntity playerEntity = playerService.findById(id);

             return ResponseHandler.generateResponse(HttpStatus.OK, false, "Find Success !", playerEntity);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true, "Failed !", e.getMessage());

        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deletePlayer(@PathVariable int id){
        playerService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete Succeeded");
    }
}

