package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.dto.StudentCompletedCourseDTO;

import com.upl.upl_tutorial_backend.entity.Course;
import com.upl.upl_tutorial_backend.entity.StudentProgress;
import com.upl.upl_tutorial_backend.entity.Tutorial;

import com.upl.upl_tutorial_backend.repository.CourseRepository;
import com.upl.upl_tutorial_backend.repository.StudentCourseEnrollmentRepository;
import com.upl.upl_tutorial_backend.repository.StudentProgressRepository;
import com.upl.upl_tutorial_backend.repository.TutorialRepository;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class StudentCompletedCourseService {



    private final StudentCourseEnrollmentRepository enrollmentRepository;

    private final CourseRepository courseRepository;

    private final TutorialRepository tutorialRepository;

    private final StudentProgressRepository progressRepository;





    public StudentCompletedCourseService(

            StudentCourseEnrollmentRepository enrollmentRepository,

            CourseRepository courseRepository,

            TutorialRepository tutorialRepository,

            StudentProgressRepository progressRepository

    ){

        this.enrollmentRepository = enrollmentRepository;

        this.courseRepository = courseRepository;

        this.tutorialRepository = tutorialRepository;

        this.progressRepository = progressRepository;

    }









    // =====================================
    // GET STUDENT COMPLETED COURSES
    // =====================================


    public List<StudentCompletedCourseDTO> getCompletedCourses(

            Long studentId

    ){



        // Get completed tutorial progress once

        List<StudentProgress> completedProgress =

                progressRepository
                        .findByStudentIdAndStatus(
                                studentId,
                                "COMPLETED"
                        );







        return enrollmentRepository

                .findByStudentId(studentId)

                .stream()

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







                    long totalTutorials =

                            tutorialRepository
                                    .countByCourse_CourseId(
                                            course.getCourseId()
                                    );







                    long completedTutorials = 0;







                    for(StudentProgress progress : completedProgress){



                        Tutorial tutorial =

                                tutorialRepository
                                        .findById(
                                                progress.getTutorialId()
                                        )
                                        .orElse(null);




                        if(tutorial != null

                                && tutorial.getCourse()
                                .getCourseId()
                                .equals(course.getCourseId())){


                            completedTutorials++;

                        }

                    }








                    double completionPercentage = 0;




                    if(totalTutorials > 0){


                        completionPercentage =

                                ((double) completedTutorials /
                                        totalTutorials) * 100;


                    }







                    return new StudentCompletedCourseDTO(


                            course.getCourseId(),


                            course.getTitle(),


                            totalTutorials,


                            completedTutorials,


                            completionPercentage


                    );



                })



                .filter(course -> course != null)



                .collect(Collectors.toList());



    }



}