package com.example.nevasikspring.controller;

import com.example.nevasikspring.entity.UserEntity;
import com.example.nevasikspring.exception.UserAlreadyExistException;
import com.example.nevasikspring.exception.UserNotFoundException;
import com.example.nevasikspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Это будет REST контроллер, не обычный, т.к. обычный возвращает HTML страницы
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping // регистрация пользователя
    public ResponseEntity registration(@RequestBody UserEntity user) { // данные с клиента будут передаваться в теле запроса и конвертироваться в UserEntity
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранён");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // вернётся ошибка которую мы прописали в Service
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping //
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка"); // если будет ошибка клиенту вернётся ошибка код статуса 400
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка"); // если будет ошибка клиенту вернётся ошибка код статуса 400
        }
    }
}
