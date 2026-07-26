package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.entity.Course;
import com.upl.upl_tutorial_backend.repository.CourseRepository;


import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class InstructorCourseService {



    private final CourseRepository courseRepository;




    public InstructorCourseService(

            CourseRepository courseRepository

    ){

        this.courseRepository = courseRepository;

    }







    // ==========================
    // GET COURSES BY INSTRUCTOR
    // ==========================

    public List<Course> getCoursesByInstructor(

            Integer instructorId

    ){


        return courseRepository
                .findByInstructorId(instructorId);


    }









    // ==========================
    // CREATE COURSE
    // ==========================

    public Course createCourse(

            Course course

    ){


        return courseRepository.save(course);


    }









    // ==========================
    // UPDATE COURSE
    // ==========================

    public Course updateCourse(

            Integer courseId,

            Course course

    ){



        Course existingCourse =

                courseRepository
                        .findById(courseId)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Course not found"
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



        existingCourse.setStatus(

                course.getStatus()

        );




        return courseRepository.save(
                existingCourse
        );


    }









    // ==========================
    // DELETE COURSE
    // ==========================

    public void deleteCourse(

            Integer courseId

    ){


        Course course =

                courseRepository
                        .findById(courseId)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Course not found"
                                )

                        );



        courseRepository.delete(course);


    }


}