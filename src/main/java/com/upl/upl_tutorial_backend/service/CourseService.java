package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.entity.Course;
import com.upl.upl_tutorial_backend.repository.CourseRepository;

import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CourseService {



    private final CourseRepository courseRepository;



    public CourseService(
            CourseRepository courseRepository
    ){

        this.courseRepository = courseRepository;

    }






    // ==========================
    // CREATE COURSE
    // ==========================

    public Course addCourse(
            Course course
    ){

        return courseRepository.save(course);

    }








    // ==========================
    // GET ALL COURSES
    // ==========================

    public List<Course> getAllCourses(){

        return courseRepository.findAll();

    }








    // ==========================
    // GET COURSE BY ID
    // ==========================

    public Course getCourseById(
            Integer id
    ){


        return courseRepository.findById(id)

                .orElseThrow(

                        () -> new RuntimeException(
                                "Course Not Found"
                        )

                );

    }








    // ==========================
    // UPDATE COURSE
    // ==========================

    public Course updateCourse(

            Integer id,

            Course course

    ){


        Course existingCourse =

                courseRepository.findById(id)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Course Not Found"
                                )

                        );



        existingCourse.setTitle(
                course.getTitle()
        );


        existingCourse.setDescription(
                course.getDescription()
        );


        existingCourse.setDuration(
                course.getDuration()
        );


        existingCourse.setLevel(
                course.getLevel()
        );



        return courseRepository.save(existingCourse);

    }








    // ==========================
    // DELETE COURSE
    // ==========================

    public void deleteCourse(

            Integer id

    ){


        Course course =

                courseRepository.findById(id)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Course Not Found"
                                )

                        );


        courseRepository.delete(course);

    }








    // ==========================
    // GET COURSES BY INSTRUCTOR
    // ==========================

    public List<Course> getCoursesByInstructor(

            Integer instructorId

    ){


        return courseRepository.findByInstructorId(
                instructorId
        );


    }


}