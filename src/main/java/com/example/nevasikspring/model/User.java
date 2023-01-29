package com.example.nevasikspring.model;

import com.example.nevasikspring.entity.TodoEntity;
import com.example.nevasikspring.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

// Этот класс сделан для того, что бы выдавать информацию о пользователе где не будет пароля, и мы сделали такой класс на Основании UserEntity
public class User {
    private Long id;
    private String username;
    private List<Todo> todos;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList())); // эта вся запись преобразует список Entity в список Модели(User'a)

        return model;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
