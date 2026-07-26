package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.entity.Course;
import com.upl.upl_tutorial_backend.service.CourseService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/courses")
@CrossOrigin("*")
public class CourseController {


    private final CourseService courseService;


    public CourseController(
            CourseService courseService
    ){

        this.courseService = courseService;

    }



    // CREATE COURSE
    // ADMIN + INSTRUCTOR

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    public Course addCourse(
            @RequestBody Course course
    ){

        return courseService.addCourse(course);

    }




    // GET ALL COURSES
    // ADMIN + INSTRUCTOR + STUDENT

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR','STUDENT')")
    public List<Course> getAllCourses(){

        return courseService.getAllCourses();

    }




    // GET COURSE BY ID
    // ADMIN + INSTRUCTOR + STUDENT

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR','STUDENT')")
    public Course getCourseById(
            @PathVariable Integer id
    ){

        return courseService.getCourseById(id);

    }




    // UPDATE COURSE
    // ADMIN + INSTRUCTOR

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    public Course updateCourse(
            @PathVariable Integer id,
            @RequestBody Course course
    ){

        return courseService.updateCourse(id,course);

    }




    // DELETE COURSE
    // ADMIN ONLY

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteCourse(
            @PathVariable Integer id
    ){

        courseService.deleteCourse(id);

        return "Course deleted successfully";

    }

}