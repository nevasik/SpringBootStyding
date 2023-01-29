package com.example.nevasikspring.service;

import com.example.nevasikspring.entity.UserEntity;
import com.example.nevasikspring.exception.UserAlreadyExistException;
import com.example.nevasikspring.exception.UserNotFoundException;
import com.example.nevasikspring.model.User;
import com.example.nevasikspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // логика по регистрации человека на сервере
    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) { // здесь делаем проверку, что если нам из тела пришло имя и оно проверяется в БД, и если пришло что то отличное от null, то такое имя уже существует
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get(); // получаем пользователя по id, если там нет ничего то будет Exception

        if (user == null) {
            throw new UserNotFoundException("Пользователь не был найден");
        }

        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);

        return id;
    }
}
