package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.dto.StudentCompletedCourseDTO;
import com.upl.upl_tutorial_backend.service.StudentCompletedCourseService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/student/completed-courses")
@CrossOrigin("*")
public class StudentCompletedCourseController {



    private final StudentCompletedCourseService service;



    public StudentCompletedCourseController(
            StudentCompletedCourseService service
    ){

        this.service = service;

    }






    // =====================================
    // GET STUDENT COMPLETED COURSES
    // =====================================

    @GetMapping("/{studentId}")

    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")

    public List<StudentCompletedCourseDTO> getCompletedCourses(

            @PathVariable Long studentId

    ){

        return service.getCompletedCourses(studentId);

    }


}