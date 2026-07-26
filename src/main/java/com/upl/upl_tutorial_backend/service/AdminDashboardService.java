package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.dto.AdminDashboardDTO;

import com.upl.upl_tutorial_backend.entity.Course;
import com.upl.upl_tutorial_backend.entity.Tutorial;

import com.upl.upl_tutorial_backend.repository.UserRepository;
import com.upl.upl_tutorial_backend.repository.CourseRepository;
import com.upl.upl_tutorial_backend.repository.TutorialRepository;


import org.springframework.stereotype.Service;



@Service
public class AdminDashboardService {



    private final UserRepository userRepository;

    private final CourseRepository courseRepository;

    private final TutorialRepository tutorialRepository;




    public AdminDashboardService(

            UserRepository userRepository,

            CourseRepository courseRepository,

            TutorialRepository tutorialRepository

    ){

        this.userRepository = userRepository;

        this.courseRepository = courseRepository;

        this.tutorialRepository = tutorialRepository;

    }







    public AdminDashboardDTO getDashboard(){



        long totalUsers =
                userRepository.count();



        long totalStudents =
                userRepository.countByRole(
                        "STUDENT"
                );



        long totalInstructors =
                userRepository.countByRole(
                        "INSTRUCTOR"
                );



        long totalCourses =
                courseRepository.count();



        long totalTutorials =
                tutorialRepository.count();




        long activeCourses =
                courseRepository.countByStatus(
                        Course.Status.ACTIVE
                );



        long inactiveCourses =
                courseRepository.countByStatus(
                        Course.Status.INACTIVE
                );



        long activeTutorials =
                tutorialRepository.countByStatus(
                        Tutorial.Status.ACTIVE
                );



        long inactiveTutorials =
                tutorialRepository.countByStatus(
                        Tutorial.Status.INACTIVE
                );






        return new AdminDashboardDTO(

                totalUsers,

                totalStudents,

                totalInstructors,

                totalCourses,

                totalTutorials,

                activeCourses,

                inactiveCourses,

                activeTutorials,

                inactiveTutorials

        );


    }


}