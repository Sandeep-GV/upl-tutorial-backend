package com.upl.upl_tutorial_backend.repository;


import com.upl.upl_tutorial_backend.entity.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;



@Repository
public interface CourseRepository
        extends JpaRepository<Course, Integer> {



    // ==========================
    // GET COURSES BY INSTRUCTOR
    // ==========================

    List<Course> findByInstructorId(
            Integer instructorId
    );




    // ==========================
    // COUNT COURSES BY INSTRUCTOR
    // ==========================

    long countByInstructorId(
            Integer instructorId
    );




    // ==========================
    // COUNT COURSES BY INSTRUCTOR AND STATUS
    // ==========================

    long countByInstructorIdAndStatus(
            Integer instructorId,
            Course.Status status
    );




    // ==========================
    // ADMIN DASHBOARD
    // COUNT ACTIVE / INACTIVE COURSES
    // ==========================

    long countByStatus(
            Course.Status status
    );


}