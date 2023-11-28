package com.lab9.airclearstatechecker.service;

import com.lab9.airclearstatechecker.entity.EFreshAir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AirClearService extends JpaRepository<AirClear, Integer> {
}
