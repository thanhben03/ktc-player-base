package vn.edu.likelion.player_manager_2.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.player_manager_2.Entity.PlayerEntity;
import vn.edu.likelion.player_manager_2.Entity.TeamEntity;
import vn.edu.likelion.player_manager_2.Entity.UserEntity;
import vn.edu.likelion.player_manager_2.Model.PlayerDTO;
import vn.edu.likelion.player_manager_2.Model.UserDTO;
import vn.edu.likelion.player_manager_2.Repository.PlayerRepository;
import vn.edu.likelion.player_manager_2.Repository.UserRepository;
import vn.edu.likelion.player_manager_2.Service.UserService;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;



}
