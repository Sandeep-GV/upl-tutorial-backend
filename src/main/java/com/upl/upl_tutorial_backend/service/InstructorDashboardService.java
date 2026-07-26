package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.dto.InstructorDashboardDTO;
import com.upl.upl_tutorial_backend.entity.Course;

import com.upl.upl_tutorial_backend.repository.CourseRepository;
import com.upl.upl_tutorial_backend.repository.TutorialRepository;


import org.springframework.stereotype.Service;



@Service
public class InstructorDashboardService {



    private final CourseRepository courseRepository;

    private final TutorialRepository tutorialRepository;





    public InstructorDashboardService(

            CourseRepository courseRepository,

            TutorialRepository tutorialRepository

    ){

        this.courseRepository = courseRepository;

        this.tutorialRepository = tutorialRepository;

    }







    public InstructorDashboardDTO getDashboard(

            Long instructorId

    ){



        Integer id = instructorId.intValue();




        // Total courses created by instructor

        long totalCourses =

                courseRepository
                        .countByInstructorId(id);






        // Total tutorials created by instructor

        long totalTutorials =

                tutorialRepository
                        .countByCourse_InstructorId(id);







        // Active courses

        long activeCourses =

                courseRepository
                        .countByInstructorIdAndStatus(

                                id,

                                Course.Status.ACTIVE

                        );







        // Inactive courses

        long inactiveCourses =

                courseRepository
                        .countByInstructorIdAndStatus(

                                id,

                                Course.Status.INACTIVE

                        );







        return new InstructorDashboardDTO(

                instructorId,

                totalCourses,

                totalTutorials,

                activeCourses,

                inactiveCourses

        );


    }


}