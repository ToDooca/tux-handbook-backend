package com.tuxhandbook.service.impl;

import com.tuxhandbook.entity.PC;
import com.tuxhandbook.repository.PCRepository;
import com.tuxhandbook.service.PCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PCServiceImpl implements PCService {
    private final PCRepository pcRepository;

    @Override
    public List<PC> findAll() {
        return pcRepository.findAll();
    }

    @Override
    public PC save(PC pc) {
        return pcRepository.save(pc);
    }

    @Override
    public PC update(PC pc) {
        return pcRepository.save(pc);
    }

    @Override
    public Optional<PC> findById(Integer pcId) {
        return pcRepository.findById(pcId);
    }

    @Override
    public void deleteById(Integer pcId) {
        pcRepository.deleteById(pcId);
    }
}
