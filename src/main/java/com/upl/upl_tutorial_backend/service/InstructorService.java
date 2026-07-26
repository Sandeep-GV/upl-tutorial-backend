package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.dto.ApprovalRequest;
import com.upl.upl_tutorial_backend.dto.InstructorRequestDTO;
import com.upl.upl_tutorial_backend.dto.InstructorResponseDTO;

import com.upl.upl_tutorial_backend.entity.Instructor;
import com.upl.upl_tutorial_backend.entity.InstructorApprovalLog;
import com.upl.upl_tutorial_backend.entity.User;

import com.upl.upl_tutorial_backend.repository.InstructorRepository;
import com.upl.upl_tutorial_backend.repository.InstructorApprovalLogRepository;
import com.upl.upl_tutorial_backend.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InstructorService {


    private final InstructorRepository instructorRepository;

    private final InstructorApprovalLogRepository instructorApprovalLogRepository;

    private final UserRepository userRepository;



    public InstructorService(

            InstructorRepository instructorRepository,

            InstructorApprovalLogRepository instructorApprovalLogRepository,

            UserRepository userRepository

    ){

        this.instructorRepository = instructorRepository;

        this.instructorApprovalLogRepository =
                instructorApprovalLogRepository;

        this.userRepository = userRepository;

    }







    // REGISTER INSTRUCTOR

    public InstructorResponseDTO registerInstructor(
            InstructorRequestDTO request
    ){


        if(request.getUserId() == null){

            throw new RuntimeException(
                    "User ID is required"
            );

        }



        User user =
                userRepository.findById(
                                request.getUserId()
                        )

                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found"
                                )
                        );





        if(request.getExpertise() == null ||
                request.getExpertise().isBlank()){


            throw new RuntimeException(
                    "Expertise is required"
            );

        }




        if(request.getQualification() == null ||
                request.getQualification().isBlank()){


            throw new RuntimeException(
                    "Qualification is required"
            );

        }




        if(request.getExperience() == null ||
                request.getExperience() < 0){


            throw new RuntimeException(
                    "Valid experience is required"
            );

        }







        Instructor instructor =
                new Instructor();


        instructor.setUser(user);


        instructor.setExpertise(
                request.getExpertise()
        );


        instructor.setQualification(
                request.getQualification()
        );


        instructor.setExperience(
                request.getExperience()
        );


        instructor.setStatus(
                "PENDING"
        );





        Instructor saved =
                instructorRepository.save(instructor);




        return convertToDTO(saved);

    }









    // ENTITY TO DTO CONVERSION

    private InstructorResponseDTO convertToDTO(
            Instructor instructor
    ){


        InstructorResponseDTO response =
                new InstructorResponseDTO();



        response.setInstructorId(
                instructor.getInstructorId()
        );



        if(instructor.getUser()!=null){


            response.setUserId(
                    instructor.getUser().getId()
            );


            response.setName(
                    instructor.getUser().getName()
            );


            response.setEmail(
                    instructor.getUser().getEmail()
            );

        }





        response.setExpertise(
                instructor.getExpertise()
        );


        response.setQualification(
                instructor.getQualification()
        );


        response.setExperience(
                instructor.getExperience()
        );


        response.setStatus(
                instructor.getStatus()
        );


        response.setCreatedAt(
                instructor.getCreatedAt()
        );



        return response;

    }









    // GET ALL INSTRUCTORS

    public List<InstructorResponseDTO> getAllInstructors(){


        return instructorRepository.findAll()

                .stream()

                .map(this::convertToDTO)

                .toList();


    }









    // GET INSTRUCTOR BY ID


    public InstructorResponseDTO getInstructorById(
            Long id
    ){


        Instructor instructor =

                instructorRepository.findById(id)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Instructor Not Found"
                                )

                        );



        return convertToDTO(instructor);


    }









    // APPROVE / REJECT INSTRUCTOR


    public InstructorResponseDTO approveInstructor(

            Long id,

            ApprovalRequest request

    ){



        Instructor instructor =

                instructorRepository.findById(id)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Instructor Not Found"
                                )

                        );






        if(request.getAction()==null){


            throw new RuntimeException(
                    "Action is required"
            );

        }





        String action =

                request.getAction()

                        .trim()

                        .toUpperCase();






        switch(action){


            case "APPROVED":

                instructor.setStatus(
                        "APPROVED"
                );

                break;



            case "REJECTED":

                instructor.setStatus(
                        "REJECTED"
                );

                break;



            default:

                throw new RuntimeException(
                        "Invalid action"
                );

        }






        Instructor updated =

                instructorRepository.save(instructor);








        // SAVE APPROVAL HISTORY


        InstructorApprovalLog log =

                new InstructorApprovalLog();





        log.setUser(
                instructor.getUser()
        );



        log.setAction(
                action
        );



        log.setRemarks(
                request.getRemarks()
        );



        // ADMIN ID

        log.setActionBy(
                instructor.getUser()
                        .getId()
        );




        instructorApprovalLogRepository.save(log);





        return convertToDTO(updated);


    }


}