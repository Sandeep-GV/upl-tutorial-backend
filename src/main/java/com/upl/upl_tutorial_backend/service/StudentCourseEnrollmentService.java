package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.entity.StudentCourseEnrollment;
import com.upl.upl_tutorial_backend.exception.DuplicateEnrollmentException;
import com.upl.upl_tutorial_backend.repository.StudentCourseEnrollmentRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentCourseEnrollmentService {


    private final StudentCourseEnrollmentRepository repository;


    public StudentCourseEnrollmentService(
            StudentCourseEnrollmentRepository repository
    ){

        this.repository = repository;

    }



    // ==========================
    // CREATE ENROLLMENT
    // ==========================

    public StudentCourseEnrollment createEnrollment(
            StudentCourseEnrollment enrollment
    ){

        boolean exists =
                repository.existsByStudentIdAndCourseId(
                        enrollment.getStudentId(),
                        enrollment.getCourseId()
                );


        if(exists){

            throw new DuplicateEnrollmentException(
                    "Student already enrolled in this course"
            );

        }


        return repository.save(enrollment);

    }





    // ==========================
    // GET ALL ENROLLMENTS
    // ==========================

    public List<StudentCourseEnrollment> getAllEnrollments(){

        return repository.findAll();

    }





    // ==========================
    // GET ENROLLMENT BY ID
    // ==========================

    public StudentCourseEnrollment getEnrollmentById(
            Long id
    ){

        return repository.findById(id)

                .orElseThrow(

                        () -> new RuntimeException(
                                "Enrollment not found"
                        )

                );

    }





    // ==========================
    // GET STUDENT COURSES
    // ==========================

    public List<StudentCourseEnrollment> getStudentCourses(
            Long studentId
    ){

        return repository.findByStudentId(studentId);

    }





    // ==========================
    // GET COURSE STUDENTS
    // ==========================

    public List<StudentCourseEnrollment> getCourseStudents(
            Integer courseId
    ){

        return repository.findByCourseId(courseId);

    }





    // ==========================
    // DELETE ENROLLMENT
    // ==========================

    public void deleteEnrollment(
            Long id
    ){

        repository.deleteById(id);

    }


}