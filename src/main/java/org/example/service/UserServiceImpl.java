package org.example.service;
import org.example.entity.User;
import lombok.RequiredArgsConstructor;
import org.example.exception.MyException;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.example.repository.UserRepository;

import java.util.List;
import java.util.logging.Logger;

@Transactional
@Service
@RequiredArgsConstructor
@EnableTransactionManagement
@SelectBeforeUpdate
public class UserServiceImpl  implements UserService {
    private static final Logger logger = Logger.getLogger("util.UserServiceImpl");
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User getById(int id) {
        logger.info("Показан пользователь: " + id);
        try {
            return userRepository.findById(id).orElseThrow(() -> new MyException("Пользователя с id: " + id + " не существует"));
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addingUsers(User user) {
        userRepository.saveAndFlush(user);
        logger.info("Пользователь добавлен в БД");
        logger.info(user.toString());
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
        logger.info("Пользователь с id: " + id + " удален");
    }

    @Override
    @Transactional(readOnly = true)
    public  List<User> selectAllUsers() {
        logger.info("Показанны все пользрватели ");
        return userRepository.findAll();
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
        logger.info("удалены все пользователи");
    }

    @Override
    @Transactional(readOnly = true)
    public int updateLastNameById(Integer id, String lastName) {
        int i = userRepository.updateLastNameById(id, lastName);
        logger.info("Имя пользователя с id: " + id + " изменено");
        return i;
    }

    @Override
    public List<User> findAllByUserAddress_House(int house) {
        logger.info("Выведены пользователи проживающие в доме №: " + house);
        return userRepository.findAllByUserAddress_House(house);
    }


}

