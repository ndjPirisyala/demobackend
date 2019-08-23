package com.example.demobackend.repository;

import com.example.demobackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    @Query(value = "SELECT employee_sequence.nextval FROM dual", nativeQuery = true)
    Integer getNextSeriesId();
}
