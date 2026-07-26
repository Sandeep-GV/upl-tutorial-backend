package com.upl.upl_tutorial_backend.repository;


import com.upl.upl_tutorial_backend.entity.Instructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InstructorRepository
        extends JpaRepository<Instructor, Long> {


    long countByStatus(String status);


}