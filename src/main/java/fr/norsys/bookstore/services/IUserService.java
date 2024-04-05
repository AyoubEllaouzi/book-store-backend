package fr.norsys.bookstore.services;

import fr.norsys.bookstore.entities.User;

import java.util.List;

public interface IUserService {
    void saveUser(User user);
    void updateUser(Long id , User user);
    void deleteUser(Long id);
    User getUser(Long id);
    List<User> getAllUser();
    public List<User> searchUsersByUsername(String query);
}
