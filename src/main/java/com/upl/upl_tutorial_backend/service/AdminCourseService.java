package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.dto.AdminCourseDTO;
import com.upl.upl_tutorial_backend.entity.Course;
import com.upl.upl_tutorial_backend.repository.CourseRepository;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class AdminCourseService {



    private final CourseRepository courseRepository;



    public AdminCourseService(
            CourseRepository courseRepository
    ){

        this.courseRepository = courseRepository;

    }








    // ==========================
    // GET ALL COURSES
    // ==========================

    public List<AdminCourseDTO> getAllCourses(){


        return courseRepository.findAll()

                .stream()

                .map(course -> new AdminCourseDTO(

                        course.getCourseId(),

                        course.getTitle(),

                        course.getDescription(),

                        course.getDuration(),

                        course.getInstructorId(),

                        course.getStatus().name()

                ))

                .collect(Collectors.toList());

    }








    // ==========================
    // GET COURSE BY ID
    // ==========================

    public AdminCourseDTO getCourseById(

            Integer id

    ){


        Course course =

                courseRepository.findById(id)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Course not found"
                                )

                        );



        return new AdminCourseDTO(

                course.getCourseId(),

                course.getTitle(),

                course.getDescription(),

                course.getDuration(),

                course.getInstructorId(),

                course.getStatus().name()

        );

    }








    // ==========================
    // UPDATE COURSE STATUS
    // ==========================

    public AdminCourseDTO updateStatus(

            Integer id,

            String status

    ){



        Course course =

                courseRepository.findById(id)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Course not found"
                                )

                        );




        course.setStatus(

                Course.Status.valueOf(status)

        );



        Course updatedCourse =

                courseRepository.save(course);





        return new AdminCourseDTO(

                updatedCourse.getCourseId(),

                updatedCourse.getTitle(),

                updatedCourse.getDescription(),

                updatedCourse.getDuration(),

                updatedCourse.getInstructorId(),

                updatedCourse.getStatus().name()

        );


    }


}