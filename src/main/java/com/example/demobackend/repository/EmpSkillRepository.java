package com.example.demobackend.repository;

import com.example.demobackend.model.EmpSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface EmpSkillRepository extends JpaRepository<EmpSkill, Long>{
    List<EmpSkill> findByEmployeeId(Integer employeeId);
}
