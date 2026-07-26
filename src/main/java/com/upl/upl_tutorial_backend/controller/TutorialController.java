package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.entity.Tutorial;
import com.upl.upl_tutorial_backend.service.TutorialService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/tutorials")
@CrossOrigin("*")
public class TutorialController {


    private final TutorialService tutorialService;



    public TutorialController(
            TutorialService tutorialService
    ){

        this.tutorialService = tutorialService;

    }







    // CREATE TUTORIAL
    // ADMIN + INSTRUCTOR

    @PostMapping("/course/{courseId}")
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    public Tutorial addTutorial(

            @PathVariable Integer courseId,

            @RequestBody Tutorial tutorial

    ){


        return tutorialService.addTutorial(
                courseId,
                tutorial
        );

    }









    // GET ALL TUTORIALS
    // ADMIN + INSTRUCTOR + STUDENT

    @GetMapping
    @PreAuthorize(
            "hasAnyRole('ADMIN','INSTRUCTOR','STUDENT')"
    )
    public List<Tutorial> getAllTutorials(){

        return tutorialService.getAllTutorials();

    }








    // GET BY ID
    // ADMIN + INSTRUCTOR + STUDENT

    @GetMapping("/{id}")
    @PreAuthorize(
            "hasAnyRole('ADMIN','INSTRUCTOR','STUDENT')"
    )
    public Tutorial getTutorialById(

            @PathVariable Long id

    ){

        return tutorialService.getTutorialById(id);

    }








    // GET BY COURSE
    // ADMIN + INSTRUCTOR + STUDENT

    @GetMapping("/course/{courseId}")
    @PreAuthorize(
            "hasAnyRole('ADMIN','INSTRUCTOR','STUDENT')"
    )
    public List<Tutorial> getTutorialsByCourse(

            @PathVariable Integer courseId

    ){

        return tutorialService
                .getByCourseId(courseId);

    }








    // UPDATE TUTORIAL
    // ADMIN + INSTRUCTOR

    @PutMapping("/{id}")
    @PreAuthorize(
            "hasAnyRole('ADMIN','INSTRUCTOR')"
    )
    public Tutorial updateTutorial(

            @PathVariable Long id,

            @RequestBody Tutorial tutorial

    ){

        return tutorialService.updateTutorial(
                id,
                tutorial
        );

    }








    // DELETE TUTORIAL
    // ADMIN ONLY

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteTutorial(

            @PathVariable Long id

    ){

        return tutorialService.deleteTutorial(id);

    }


}