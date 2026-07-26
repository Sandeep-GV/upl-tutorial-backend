package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.entity.Course;
import com.upl.upl_tutorial_backend.entity.Tutorial;
import com.upl.upl_tutorial_backend.entity.TutorialEditHistory;

import com.upl.upl_tutorial_backend.repository.CourseRepository;
import com.upl.upl_tutorial_backend.repository.TutorialRepository;

import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class TutorialService {


    private final TutorialRepository tutorialRepository;

    private final CourseRepository courseRepository;

    private final TutorialEditHistoryService tutorialEditHistoryService;

    private final CurrentUserService currentUserService;





    public TutorialService(

            TutorialRepository tutorialRepository,

            CourseRepository courseRepository,

            TutorialEditHistoryService tutorialEditHistoryService,

            CurrentUserService currentUserService

    ){

        this.tutorialRepository = tutorialRepository;

        this.courseRepository = courseRepository;

        this.tutorialEditHistoryService =
                tutorialEditHistoryService;

        this.currentUserService =
                currentUserService;

    }







    // ================================
    // ADD TUTORIAL
    // ================================

    public Tutorial addTutorial(

            Integer courseId,

            Tutorial tutorial

    ){


        Course course =

                courseRepository.findById(courseId)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Course Not Found"
                                )

                        );


        tutorial.setCourse(course);


        return tutorialRepository.save(tutorial);

    }







    // ================================
    // GET ALL TUTORIALS
    // ================================

    public List<Tutorial> getAllTutorials(){

        return tutorialRepository.findAll();

    }








    // ================================
    // GET TUTORIAL BY ID
    // ================================

    public Tutorial getTutorialById(

            Long id

    ){


        return tutorialRepository.findById(id)

                .orElseThrow(

                        () -> new RuntimeException(
                                "Tutorial Not Found"
                        )

                );

    }








    // ================================
    // GET TUTORIALS BY COURSE
    // ================================

    public List<Tutorial> getByCourseId(

            Integer courseId

    ){


        return tutorialRepository
                .findByCourse_CourseId(courseId);

    }








    // ================================
    // UPDATE TUTORIAL + HISTORY
    // ================================

    public Tutorial updateTutorial(

            Long id,

            Tutorial updatedTutorial

    ){


        Tutorial existing =

                getTutorialById(id);





        TutorialEditHistory history =

                new TutorialEditHistory();




        history.setTutorialId(
                existing.getTutorialId()
        );



        if(existing.getCourse()!=null){


            history.setCourseId(

                    existing.getCourse()
                            .getCourseId()

            );

        }





        history.setOldTitle(
                existing.getTitle()
        );


        history.setNewTitle(
                updatedTutorial.getTitle()
        );




        history.setOldContent(
                existing.getContent()
        );


        history.setNewContent(
                updatedTutorial.getContent()
        );




        history.setOldYoutubeLink(
                existing.getYoutubeLink()
        );


        history.setNewYoutubeLink(
                updatedTutorial.getYoutubeLink()
        );





        history.setChangedBy(

                currentUserService
                        .getCurrentUserId()
                        .intValue()

        );





        tutorialEditHistoryService
                .saveHistory(history);






        existing.setTitle(
                updatedTutorial.getTitle()
        );


        existing.setContent(
                updatedTutorial.getContent()
        );


        existing.setYoutubeLink(
                updatedTutorial.getYoutubeLink()
        );



        if(updatedTutorial.getStatus()!=null){

            existing.setStatus(
                    updatedTutorial.getStatus()
            );

        }



        return tutorialRepository.save(existing);

    }









    // ================================
    // DELETE TUTORIAL
    // ================================

    public String deleteTutorial(

            Long id

    ){


        tutorialEditHistoryService
                .deleteHistoryByTutorialId(id);



        tutorialRepository.deleteById(id);



        return "Tutorial deleted successfully";

    }


}