package org.example.service;

import org.example.entity.User;

import java.util.List;

public interface UserService {
    User getById(int id) throws MyException;
    void addingUsers(User user);
    void deleteUser(int id);
    List<User> selectAllUsers();
    void deleteAllUsers();
    public int updateLastNameById(Integer id, String lastName);

}
