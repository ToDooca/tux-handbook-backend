package com.tuxhandbook.service;

import com.tuxhandbook.entity.PC;

import java.util.List;

public interface PCService {

    List<PC> findAll();

    PC save(PC pc);

    PC update(PC pc);

    PC findById(Integer pcId);

    void deleteById(Integer pcId);
}
