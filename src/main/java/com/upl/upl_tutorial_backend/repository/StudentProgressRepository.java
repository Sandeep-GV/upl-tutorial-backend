package com.upl.upl_tutorial_backend.repository;


import com.upl.upl_tutorial_backend.entity.StudentProgress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface StudentProgressRepository
        extends JpaRepository<StudentProgress, Long> {



    List<StudentProgress> findByStudentId(
            Long studentId
    );



    List<StudentProgress> findByTutorialId(
            Long tutorialId
    );



    List<StudentProgress> findByStudentIdAndStatus(
            Long studentId,
            String status
    );


}