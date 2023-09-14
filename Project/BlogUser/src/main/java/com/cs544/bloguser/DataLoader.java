package com.cs544.bloguser;

import com.cs544.bloguser.domain.User;
import com.cs544.bloguser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final UserService userService;

    @Autowired
    public DataLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user =new User("Mahmudul","Hassan","lalinmail@gmail.com",
                generateHashedPassword("123"));
        userService.SaveUser(user);

    }
    String generateHashedPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }
}
