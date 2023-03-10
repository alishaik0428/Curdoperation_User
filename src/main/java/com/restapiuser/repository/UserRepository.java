package com.restapiuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapiuser.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
