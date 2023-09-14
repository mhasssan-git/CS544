package com.cs544.bloguser.service;

import com.cs544.bloguser.domain.User;
import com.cs544.bloguser.dto.UserRequest;
import com.cs544.bloguser.dto.UserResponse;
import com.cs544.bloguser.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAll() {

        List<User> userList = userRepository.findAll();
        return userList.stream().map(p->modelMapper.map(p,UserResponse.class)).collect(Collectors.toList());
    }

    public UserResponse getById(Long id) {
        Optional<User> oUser = userRepository.findById(id);
        User user= oUser.isPresent() ? oUser.get() : null;
       UserResponse userResponse= modelMapper.map(user,UserResponse.class);
        return userResponse;
    }

    public Long SaveUser(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        user.setPassword(generateHashedPassword(user.getPassword()));
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
    public Long UpdatePassword(Long id ,String password) {
        User user=userRepository.getById(id);
        user.setPassword(generateHashedPassword(password));
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
    public Long SaveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    public void DeleteUser(Long id) {
        userRepository.deleteById(id);
    }
    String generateHashedPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }

}
