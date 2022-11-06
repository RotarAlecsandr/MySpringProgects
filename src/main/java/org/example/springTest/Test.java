package org.example.springTest;

import org.example.configyration.SpringConfig;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class Test {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user1 = new User("Nikolaev", "Nikolay", 40);
        User user2 = new User("Sidorov", "Stepan", 32);
        User user3 = new User("Kravtsov", "Aleksey", 21);
        User user4 = new User("Kyzmich", "Dima", 28);
        User user5 = new User("Petrov", "Nikplay", 12);

        UserService userService = context.getBean(UserService.class);
        List<User> userList = userService.selectAllUsers();
        userList
                .stream()
                .forEach(System.out::println);
        //userService.deleteAllUsers();
        //System.out.println(userService.getById(22));
        //userService.deleteUser(1);
        //userService.updateLastNameById(3, "Gleb");
    }
}
