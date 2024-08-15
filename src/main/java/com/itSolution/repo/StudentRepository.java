package com.itSolution.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itSolution.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {

}
