package lab.back_board.service.impl;

import org.springframework.stereotype.Service;
import lab.back_board.service.UserService;
import lab.back_board.entity.User;
import lab.back_board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    };

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    };

    @Override
    public void updateUser(User user) {
        try {
            userRepository.save(user);

        } catch(Exception e) {
            System.out.println(e);
        }
    };
}
