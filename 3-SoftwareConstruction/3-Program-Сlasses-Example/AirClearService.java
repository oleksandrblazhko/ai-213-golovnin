package com.lab9.airclearchecker.service;

import com.lab9.airclearchecker.entity.EFreshAir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AirClearService extends JpaRepository<AirClear, Integer> {
}
