package com.tuxhandbook.service;

import com.tuxhandbook.entity.PC;

import java.util.List;

public interface PCService {

    List<PC> findAll();

    PC findById(Integer pcId);

    PC save(PC pc);

    PC update(PC pc);

    void deleteById(Integer pcId);
}
