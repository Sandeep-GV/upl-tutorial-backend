package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.dto.StudentDashboardDTO;
import com.upl.upl_tutorial_backend.repository.StudentCourseEnrollmentRepository;
import com.upl.upl_tutorial_backend.repository.StudentProgressRepository;
import com.upl.upl_tutorial_backend.repository.TutorialRepository;

import org.springframework.stereotype.Service;



@Service
public class StudentDashboardService {



    private final StudentCourseEnrollmentRepository enrollmentRepository;

    private final StudentProgressRepository progressRepository;

    private final TutorialRepository tutorialRepository;




    public StudentDashboardService(

            StudentCourseEnrollmentRepository enrollmentRepository,

            StudentProgressRepository progressRepository,

            TutorialRepository tutorialRepository

    ){

        this.enrollmentRepository = enrollmentRepository;

        this.progressRepository = progressRepository;

        this.tutorialRepository = tutorialRepository;

    }







    public StudentDashboardDTO getDashboard(
            Long studentId
    ){



        // Total enrolled courses

        long totalCourses =

                enrollmentRepository
                        .countByStudentId(studentId);





        // Completed tutorials

        long completedTutorials =

                progressRepository
                        .findByStudentIdAndStatus(
                                studentId,
                                "COMPLETED"
                        )
                        .size();






        // Total tutorials

        long totalTutorials =

                tutorialRepository.count();







        double completionPercentage = 0;



        if(totalTutorials > 0){

            completionPercentage =

                    ((double) completedTutorials /
                            totalTutorials) * 100;

        }








        return new StudentDashboardDTO(

                studentId,

                totalCourses,

                totalTutorials,

                completedTutorials,

                completionPercentage

        );


    }



}