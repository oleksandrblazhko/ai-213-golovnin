package com.lab9.airclearstatechecker.service;

import com.lab9.airclearstatechecker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService extends JpaRepository<User, Integer> {
}
