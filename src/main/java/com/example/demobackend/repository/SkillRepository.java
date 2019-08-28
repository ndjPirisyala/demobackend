package com.example.demobackend.repository;

import com.example.demobackend.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    @Query(value = "SELECT nextval('skill_sequence')", nativeQuery = true)
    BigInteger getNextSeriesId();
}
