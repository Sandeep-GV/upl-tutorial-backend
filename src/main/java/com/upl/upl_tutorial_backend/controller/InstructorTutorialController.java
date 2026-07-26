package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.entity.Tutorial;
import com.upl.upl_tutorial_backend.service.InstructorTutorialService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/instructor/tutorials")
@CrossOrigin("*")
public class InstructorTutorialController {



    private final InstructorTutorialService instructorTutorialService;



    public InstructorTutorialController(

            InstructorTutorialService instructorTutorialService

    ){

        this.instructorTutorialService = instructorTutorialService;

    }








    // ==========================
    // GET INSTRUCTOR TUTORIALS
    // ==========================

    @GetMapping("/{instructorId}")
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    public List<Tutorial> getInstructorTutorials(

            @PathVariable Integer instructorId

    ){


        return instructorTutorialService
                .getTutorialsByInstructor(instructorId);


    }









    // ==========================
    // CREATE TUTORIAL
    // ==========================

    @PostMapping
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public Tutorial createTutorial(

            @RequestBody Tutorial tutorial

    ){


        return instructorTutorialService
                .createTutorial(tutorial);


    }









    // ==========================
    // UPDATE TUTORIAL
    // ==========================

    @PutMapping("/{tutorialId}")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public Tutorial updateTutorial(

            @PathVariable Long tutorialId,

            @RequestBody Tutorial tutorial

    ){


        return instructorTutorialService
                .updateTutorial(
                        tutorialId,
                        tutorial
                );


    }









    // ==========================
    // DELETE TUTORIAL
    // ==========================

    @DeleteMapping("/{tutorialId}")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public String deleteTutorial(

            @PathVariable Long tutorialId

    ){


        instructorTutorialService
                .deleteTutorial(tutorialId);



        return "Tutorial deleted successfully";


    }



}