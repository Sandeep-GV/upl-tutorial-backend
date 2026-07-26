package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.dto.StudentCourseDTO;
import com.upl.upl_tutorial_backend.entity.Tutorial;
import com.upl.upl_tutorial_backend.repository.TutorialRepository;
import com.upl.upl_tutorial_backend.service.StudentCourseService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/student/courses")
@CrossOrigin("*")
public class StudentCourseController {



    private final StudentCourseService studentCourseService;

    private final TutorialRepository tutorialRepository;




    public StudentCourseController(

            StudentCourseService studentCourseService,

            TutorialRepository tutorialRepository

    ){

        this.studentCourseService = studentCourseService;

        this.tutorialRepository = tutorialRepository;

    }







    // =====================================
    // GET STUDENT ENROLLED COURSES
    // =====================================

    @GetMapping("/{studentId}")

    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")

    public List<StudentCourseDTO> getStudentCourses(

            @PathVariable Long studentId

    ){

        return studentCourseService
                .getStudentCourses(studentId);

    }








    // =====================================
    // VIEW COURSE TUTORIALS
    // =====================================

    @GetMapping("/{courseId}/tutorials")

    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")

    public List<Tutorial> getCourseTutorials(

            @PathVariable Integer courseId

    ){

        return tutorialRepository
                .findByCourse_CourseId(courseId);

    }



}