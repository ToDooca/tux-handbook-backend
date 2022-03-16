package com.tuxhandbook.repository;

import com.tuxhandbook.entity.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PCRepository extends JpaRepository<PC, Integer> {
}
