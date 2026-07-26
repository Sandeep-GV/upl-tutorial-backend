package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.dto.StudentLearningHistoryDTO;
import com.upl.upl_tutorial_backend.service.StudentLearningHistoryService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/student/history")
@CrossOrigin("*")
public class StudentLearningHistoryController {



    private final StudentLearningHistoryService service;



    public StudentLearningHistoryController(

            StudentLearningHistoryService service

    ){

        this.service = service;

    }






    // ==========================
    // GET STUDENT LEARNING HISTORY
    // ==========================

    @GetMapping("/{studentId}")
    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")
    public List<StudentLearningHistoryDTO> getHistory(

            @PathVariable Long studentId

    ){

        return service.getHistory(studentId);

    }


}