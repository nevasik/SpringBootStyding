package com.example.nevasikspring.repository;

import com.example.nevasikspring.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {

}
