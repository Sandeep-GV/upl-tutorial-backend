package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.entity.Tutorial;
import com.upl.upl_tutorial_backend.repository.TutorialRepository;


import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class InstructorTutorialService {



    private final TutorialRepository tutorialRepository;



    public InstructorTutorialService(

            TutorialRepository tutorialRepository

    ){

        this.tutorialRepository = tutorialRepository;

    }







    // ==========================
    // GET TUTORIALS BY INSTRUCTOR
    // ==========================

    public List<Tutorial> getTutorialsByInstructor(

            Integer instructorId

    ){


        return tutorialRepository
                .findByCourse_InstructorId(instructorId);


    }









    // ==========================
    // CREATE TUTORIAL
    // ==========================

    public Tutorial createTutorial(

            Tutorial tutorial

    ){


        return tutorialRepository
                .save(tutorial);


    }









    // ==========================
    // UPDATE TUTORIAL
    // ==========================

    public Tutorial updateTutorial(

            Long tutorialId,

            Tutorial tutorial

    ){



        Tutorial existingTutorial =

                tutorialRepository
                        .findById(tutorialId)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Tutorial not found"
                                )

                        );




        existingTutorial.setTitle(

                tutorial.getTitle()

        );



        existingTutorial.setContent(

                tutorial.getContent()

        );



        existingTutorial.setYoutubeLink(

                tutorial.getYoutubeLink()

        );



        existingTutorial.setStatus(

                tutorial.getStatus()

        );



        return tutorialRepository.save(
                existingTutorial
        );


    }









    // ==========================
    // DELETE TUTORIAL
    // ==========================

    public void deleteTutorial(

            Long tutorialId

    ){



        Tutorial tutorial =

                tutorialRepository
                        .findById(tutorialId)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Tutorial not found"
                                )

                        );



        tutorialRepository.delete(tutorial);


    }


}