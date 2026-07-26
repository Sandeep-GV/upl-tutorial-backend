package com.upl.upl_tutorial_backend.repository;


import com.upl.upl_tutorial_backend.entity.StudentCourseEnrollment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface StudentCourseEnrollmentRepository
        extends JpaRepository<StudentCourseEnrollment, Long> {



    // ==========================
    // GET COURSES BY STUDENT
    // ==========================

    List<StudentCourseEnrollment> findByStudentId(
            Long studentId
    );




    // ==========================
    // COUNT COURSES BY STUDENT
    // ==========================

    long countByStudentId(
            Long studentId
    );




    // ==========================
    // GET STUDENTS BY COURSE
    // ==========================

    List<StudentCourseEnrollment> findByCourseId(
            Integer courseId
    );




    // ==========================
    // CHECK DUPLICATE ENROLLMENT
    // ==========================

    boolean existsByStudentIdAndCourseId(
            Long studentId,
            Integer courseId
    );


}