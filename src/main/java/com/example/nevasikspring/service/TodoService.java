package com.example.nevasikspring.service;

import com.example.nevasikspring.entity.TodoEntity;
import com.example.nevasikspring.entity.UserEntity;
import com.example.nevasikspring.model.Todo;
import com.example.nevasikspring.repository.TodoRepo;
import com.example.nevasikspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoRepo todoRepo;
    private final UserRepo userRepo;

    @Autowired
    public TodoService(TodoRepo todoRepo, UserRepo userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }

    public Todo createTodo(TodoEntity todo, Long userId) { // для создания задачи.
        UserEntity user = userRepo.findById(userId).get(); // Перед тем как задачу создавать нам надо найти пользователя
        todo.setUser(user);

        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo complete(Long id) { // для обновления задачи
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());

        return Todo.toModel(todoRepo.save(todo));
    }
}
