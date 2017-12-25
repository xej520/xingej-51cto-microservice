package com.itmuch.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itmuch.cloud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
