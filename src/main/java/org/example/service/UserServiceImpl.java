package org.example.service;
import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.repository.UserRepository;

import java.util.List;
import java.util.logging.Logger;

@Transactional
@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService {
    private static final Logger logger = Logger.getLogger("util.UserServiceImpl");
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User getById(int id) throws MyException {
        logger.info("Показан пользователь: " + id);
        return userRepository.findById(id).orElseThrow(() -> new MyException("Пользователя с id: " + id + " не существует"));
    }

    @Override
    public void addingUsers(User user) {
        userRepository.saveAndFlush(user);
        logger.info("Пользователь сохранен в БД." );
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
        logger.info("Пользователь с id: " + id + " удален");
    }

    @Override
    @Transactional(readOnly = true)
    public  List<User> selectAllUsers() {
        logger.info("Показанны все пользрватели " );
        return userRepository.findAll();
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
        logger.info("удалены все пользователи");
    }

    @Override
    @Transactional
    public int updateLastNameById(Integer id, String lastName) {
        int i = userRepository.updateLastNameById(id, lastName);
        logger.info("Имя пользователя с id: " + id + " изменено");
        return i;
    }
}

