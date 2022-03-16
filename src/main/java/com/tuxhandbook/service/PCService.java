package com.tuxhandbook.service;

import com.tuxhandbook.entity.PC;

import java.util.List;
import java.util.Optional;

public interface PCService {

    List<PC> findAll();

    PC save(PC pc);

    PC update(PC pc);

    Optional<PC> findById(Integer pcId);

    void deleteById(Integer pcId);
}
