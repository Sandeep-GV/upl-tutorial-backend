package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.dto.AdminTutorialDTO;
import com.upl.upl_tutorial_backend.entity.Tutorial;
import com.upl.upl_tutorial_backend.repository.TutorialRepository;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class AdminTutorialService {



    private final TutorialRepository tutorialRepository;



    public AdminTutorialService(
            TutorialRepository tutorialRepository
    ){

        this.tutorialRepository = tutorialRepository;

    }







    // ==========================
    // GET ALL TUTORIALS
    // ==========================

    public List<AdminTutorialDTO> getAllTutorials(){


        return tutorialRepository.findAll()

                .stream()

                .map(tutorial -> new AdminTutorialDTO(

                        tutorial.getTutorialId(),

                        tutorial.getTitle(),

                        null,   // Tutorial has no description field

                        tutorial.getCourse()
                                .getCourseId(),

                        tutorial.getStatus().name()

                ))

                .collect(Collectors.toList());

    }








    // ==========================
    // GET TUTORIAL BY ID
    // ==========================

    public AdminTutorialDTO getTutorialById(
            Long id
    ){


        Tutorial tutorial =

                tutorialRepository.findById(id)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Tutorial not found"
                                )

                        );



        return new AdminTutorialDTO(

                tutorial.getTutorialId(),

                tutorial.getTitle(),

                null,   // Tutorial has no description field

                tutorial.getCourse()
                        .getCourseId(),

                tutorial.getStatus().name()

        );

    }








    // ==========================
    // UPDATE TUTORIAL STATUS
    // ==========================

    public AdminTutorialDTO updateStatus(

            Long id,

            String status

    ){


        Tutorial tutorial =

                tutorialRepository.findById(id)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Tutorial not found"
                                )

                        );




        tutorial.setStatus(

                Tutorial.Status.valueOf(status)

        );



        Tutorial updatedTutorial =

                tutorialRepository.save(tutorial);







        return new AdminTutorialDTO(

                updatedTutorial.getTutorialId(),

                updatedTutorial.getTitle(),

                null,   // Tutorial has no description field

                updatedTutorial.getCourse()
                        .getCourseId(),

                updatedTutorial.getStatus().name()

        );


    }


}