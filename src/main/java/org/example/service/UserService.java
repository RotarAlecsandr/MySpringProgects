package org.example.service;

import org.example.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService {
    User getById(int id);
    void addingUsers(User user);
    void deleteUser(int id);
    List<User> selectAllUsers();
    void deleteAllUsers();
    public int updateLastNameById(Integer id, String lastName);
    List<User> findAllByUserAddress_House(int house);
}
