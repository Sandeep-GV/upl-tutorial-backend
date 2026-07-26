package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.entity.StudentCourseEnrollment;
import com.upl.upl_tutorial_backend.service.StudentCourseEnrollmentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/enrollments")
public class StudentCourseEnrollmentController {



    private final StudentCourseEnrollmentService service;



    public StudentCourseEnrollmentController(
            StudentCourseEnrollmentService service
    ){

        this.service = service;

    }




    // GET STUDENT COURSES
    @GetMapping("/student/{studentId}")
    public List<StudentCourseEnrollment> getStudentCourses(
            @PathVariable Long studentId
    ){

        return service.getStudentCourses(studentId);

    }






    // GET COURSE STUDENTS
    @GetMapping("/course/{courseId}")
    public List<StudentCourseEnrollment> getCourseStudents(
            @PathVariable Integer courseId
    ){

        return service.getCourseStudents(courseId);

    }






    // CREATE ENROLLMENT
    @PostMapping
    public StudentCourseEnrollment createEnrollment(
            @RequestBody StudentCourseEnrollment enrollment
    ){

        return service.createEnrollment(enrollment);

    }




    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEnrollment(
            @PathVariable Long id
    ){

        service.deleteEnrollment(id);

        return "Enrollment deleted successfully";

    }


}