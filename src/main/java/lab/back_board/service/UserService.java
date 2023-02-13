package lab.back_board.service;

import lab.back_board.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(String userId);

    public User addUser(User user);

    public void updateUser(User user);
}
