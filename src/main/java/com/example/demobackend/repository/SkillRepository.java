package com.example.demobackend.repository;

import com.example.demobackend.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    @Query(value = "SELECT skill_sequence.nextval FROM dual", nativeQuery = true)
    Integer getNextSeriesId();
}
