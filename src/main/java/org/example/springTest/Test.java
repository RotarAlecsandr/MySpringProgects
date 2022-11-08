package org.example.springTest;

import org.example.configyration.SpringConfig;
import org.example.entity.User;
import org.example.entity.UserAddress;
import org.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
public class Test {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user1 = new User("Nikolaev", "Nikolay", 40, new UserAddress("Minsk", "Gorkogo", 12));
        User user2 = new User("Sidorov", "Stepan", 32, new UserAddress("Gomel", "Pyshkina", 3));
        User user3 = new User("Kravtsov", "Aleksey", 21, new UserAddress("Brest", "Moskovskaya", 30));
        User user4 = new User("Kyzmich", "Dima", 28, new UserAddress("Bereza", "Lybarscogo", 30));
        User user5 = new User("Petrov", "Nikplay", 12, new UserAddress("Bereza", "Lybarscogo", 35));

        UserService userService = context.getBean(UserService.class);
        //userService.addingUsers(user1);
        //userService.addingUsers(user2);
        //userService.addingUsers(user3);
        //userService.addingUsers(user4);
        //userService.addingUsers(user5);
    }
}
