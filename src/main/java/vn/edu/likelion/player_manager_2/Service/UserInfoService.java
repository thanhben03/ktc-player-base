package vn.edu.likelion.player_manager_2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.likelion.player_manager_2.Entity.UserEntity;
import vn.edu.likelion.player_manager_2.Model.UserInfoDetails;
import vn.edu.likelion.player_manager_2.Repository.UserRepository;

import java.util.Optional;


@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userDetail = repository.findByUsername(username);

        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found "));
    }

    public UserEntity addUser(UserEntity userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        return repository.save(userInfo);

    }

    public UserEntity authenticateUser(String username, String password) {
        Optional<UserEntity> user = repository.findByUsername(username);
        if (user.isPresent() && encoder.matches(password, user.get().getPassword())) {
            return user.get();
        }
        return null;
    }


}