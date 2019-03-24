package com.marchjpademo.marchjpa.repositories;

import com.marchjpademo.marchjpa.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepo extends JpaRepository<Department,Integer> {
}
