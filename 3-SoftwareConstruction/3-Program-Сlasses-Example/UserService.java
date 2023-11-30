package com.lab9.airclearchecker.service;

import com.lab9.airclearchecker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService extends JpaRepository<User, Integer> {
}
