package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.dto.StudentProfileDTO;
import com.upl.upl_tutorial_backend.entity.User;

import com.upl.upl_tutorial_backend.repository.UserRepository;
import com.upl.upl_tutorial_backend.repository.StudentCourseEnrollmentRepository;
import com.upl.upl_tutorial_backend.repository.StudentProgressRepository;


import org.springframework.stereotype.Service;



@Service
public class StudentProfileService {



    private final UserRepository userRepository;

    private final StudentCourseEnrollmentRepository enrollmentRepository;

    private final StudentProgressRepository progressRepository;





    public StudentProfileService(

            UserRepository userRepository,

            StudentCourseEnrollmentRepository enrollmentRepository,

            StudentProgressRepository progressRepository

    ){

        this.userRepository = userRepository;

        this.enrollmentRepository = enrollmentRepository;

        this.progressRepository = progressRepository;

    }








    // =====================================
    // GET STUDENT PROFILE
    // =====================================


    public StudentProfileDTO getProfile(

            Long studentId

    ){



        User user =

                userRepository
                        .findById(studentId)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Student not found"
                                )

                        );







        long enrolledCourses =

                enrollmentRepository
                        .countByStudentId(studentId);








        long completedTutorials =

                progressRepository
                        .findByStudentIdAndStatus(
                                studentId,
                                "COMPLETED"
                        )
                        .size();









        return new StudentProfileDTO(

                user.getId(),

                user.getName(),

                user.getEmail(),

                user.getRole(),

                enrolledCourses,

                completedTutorials

        );


    }


}