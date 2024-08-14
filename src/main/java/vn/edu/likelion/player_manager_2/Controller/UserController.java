package vn.edu.likelion.player_manager_2.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.player_manager_2.Entity.UserEntity;
import vn.edu.likelion.player_manager_2.JWT.JwtUtil;
import vn.edu.likelion.player_manager_2.Model.UserDTO;
import vn.edu.likelion.player_manager_2.Service.UserInfoService;
import vn.edu.likelion.player_manager_2.Util.ResponseHandler;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtService;

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok("ahihi");
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserEntity userEntity) {
        try {
            UserEntity user = userInfoService.addUser(userEntity);
            return ResponseHandler
                    .generateResponse(HttpStatus.OK, false, "Register Success !", userEntity);
        } catch (Exception e) {
            return ResponseHandler
                    .generateResponse(HttpStatus.OK, true, e.getMessage(), "");
        }
    }

    @PostMapping("/login")
    public  ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = userInfoService.authenticateUser(userDTO.getUsername(), userDTO.getPassword());
        if(userEntity != null) {
            String token = jwtService.generateToken(userEntity.getUsername());
            return ResponseHandler
                    .generateResponse(HttpStatus.OK, false, "Login success !", token);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


}
