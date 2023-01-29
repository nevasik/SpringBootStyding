package com.example.nevasikspring.repository;

import com.example.nevasikspring.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> { // первым параметром указываем сущность с которым он будет работать, а второй параметр тип его идентификатор(id)
    UserEntity findByUsername(String username);
}
