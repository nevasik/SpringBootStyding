package com.example.nevasikspring.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity // указываем, что данный класс является сущностью
@Table(name = "users")
public class UserEntity {
    @Id // указываем что это id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // генерация id(auto increment)
    private Long id;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") // cascade - если мы удаляем пользователя, из БД сразу же удаляются его задачи. mappedBy - указываем user, что бы связать наши таблицы
    private List<TodoEntity> todos;

    public UserEntity() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TodoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoEntity> todos) {
        this.todos = todos;
    }
}
