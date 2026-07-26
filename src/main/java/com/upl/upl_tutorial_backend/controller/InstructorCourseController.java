package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.entity.Course;
import com.upl.upl_tutorial_backend.service.InstructorCourseService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/instructor/courses")
@CrossOrigin("*")
public class InstructorCourseController {



    private final InstructorCourseService instructorCourseService;



    public InstructorCourseController(

            InstructorCourseService instructorCourseService

    ){

        this.instructorCourseService = instructorCourseService;

    }






    // ==========================
    // GET INSTRUCTOR COURSES
    // ==========================

    @GetMapping("/{instructorId}")
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    public List<Course> getCourses(

            @PathVariable Integer instructorId

    ){

        return instructorCourseService
                .getCoursesByInstructor(instructorId);

    }








    // ==========================
    // CREATE COURSE
    // ==========================

    @PostMapping
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public Course createCourse(

            @RequestBody Course course

    ){

        return instructorCourseService
                .createCourse(course);

    }








    // ==========================
    // UPDATE COURSE
    // ==========================

    @PutMapping("/{courseId}")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public Course updateCourse(

            @PathVariable Integer courseId,

            @RequestBody Course course

    ){

        return instructorCourseService
                .updateCourse(courseId, course);

    }








    // ==========================
    // DELETE COURSE
    // ==========================

    @DeleteMapping("/{courseId}")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public String deleteCourse(

            @PathVariable Integer courseId

    ){

        instructorCourseService
                .deleteCourse(courseId);


        return "Course deleted successfully";

    }


}