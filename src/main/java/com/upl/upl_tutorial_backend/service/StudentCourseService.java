package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.dto.StudentCourseDTO;
import com.upl.upl_tutorial_backend.entity.Course;
import com.upl.upl_tutorial_backend.entity.StudentCourseEnrollment;

import com.upl.upl_tutorial_backend.repository.CourseRepository;
import com.upl.upl_tutorial_backend.repository.StudentCourseEnrollmentRepository;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class StudentCourseService {



    private final StudentCourseEnrollmentRepository enrollmentRepository;

    private final CourseRepository courseRepository;




    public StudentCourseService(

            StudentCourseEnrollmentRepository enrollmentRepository,

            CourseRepository courseRepository

    ){

        this.enrollmentRepository = enrollmentRepository;

        this.courseRepository = courseRepository;

    }






    // ===================================
    // GET STUDENT ENROLLED COURSES
    // ===================================

    public List<StudentCourseDTO> getStudentCourses(

            Long studentId

    ){



        List<StudentCourseEnrollment> enrollments =

                enrollmentRepository
                        .findByStudentId(studentId);





        return enrollments.stream()

                .map(enrollment -> {



                    Course course =

                            courseRepository
                                    .findById(
                                            enrollment.getCourseId()
                                    )
                                    .orElse(null);




                    if(course == null){

                        return null;

                    }




                    return new StudentCourseDTO(

                            course.getCourseId(),

                            course.getTitle(),

                            course.getDescription(),

                            course.getDuration(),

                            course.getLevel(),

                            course.getStatus()
                                    .name(),

                            enrollment.getEnrolledAt()

                    );


                })

                .filter(dto -> dto != null)

                .collect(Collectors.toList());


    }


}