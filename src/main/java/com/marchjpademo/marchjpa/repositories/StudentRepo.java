package com.marchjpademo.marchjpa.repositories;

import com.marchjpademo.marchjpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
