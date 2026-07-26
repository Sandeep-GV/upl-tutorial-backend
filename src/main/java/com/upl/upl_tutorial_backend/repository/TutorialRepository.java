package com.upl.upl_tutorial_backend.repository;


import com.upl.upl_tutorial_backend.entity.Tutorial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;



@Repository
public interface TutorialRepository
        extends JpaRepository<Tutorial, Long> {



    // ==========================
    // COUNT TUTORIALS BY COURSE
    // ==========================

    long countByCourse_CourseId(
            Integer courseId
    );





    // ==========================
    // GET TUTORIALS BY COURSE
    // ==========================

    List<Tutorial> findByCourse_CourseId(
            Integer courseId
    );





    // ==========================
    // GET TUTORIALS BY INSTRUCTOR
    // ==========================

    List<Tutorial> findByCourse_InstructorId(
            Integer instructorId
    );





    // ==========================
    // COUNT TUTORIALS BY INSTRUCTOR
    // ==========================

    long countByCourse_InstructorId(
            Integer instructorId
    );





    // ==========================
    // COUNT TUTORIALS BY STATUS
    // ==========================

    long countByStatus(
            Tutorial.Status status
    );


}