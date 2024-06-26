package org.emp.repository;

import org.emp.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    public Iterable<EmployeeEntity> findAllByFirstName(String fname);
}
