package com.codingart.mycompta.service.impl.auth;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.auth.User;
import com.codingart.mycompta.repository.auth.UserRepository;
import com.codingart.mycompta.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final String message = "User not found for this id :: ";


    @Override
    public User addUser(User user) {
        return userRepository.save(user);

    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser( Long id, User user) {
        userRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        userRepository.deleteById(id);
    }

}
