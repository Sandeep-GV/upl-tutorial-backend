package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.entity.TutorialEditHistory;
import com.upl.upl_tutorial_backend.service.TutorialEditHistoryService;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tutorial-edit-history")
public class TutorialEditHistoryController {


    private final TutorialEditHistoryService service;


    public TutorialEditHistoryController(
            TutorialEditHistoryService service
    ) {

        this.service = service;

    }



    // Get all tutorial edit history
    @GetMapping
    public List<TutorialEditHistory> getAllHistory(){

        return service.getAllHistory();

    }



    // Get history by tutorial id
    @GetMapping("/tutorial/{tutorialId}")
    public List<TutorialEditHistory> getHistoryByTutorialId(
            @PathVariable Long tutorialId
    ){

        return service.getHistoryByTutorialId(tutorialId);

    }


}