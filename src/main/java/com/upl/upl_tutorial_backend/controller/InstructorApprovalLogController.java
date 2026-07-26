package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.entity.InstructorApprovalLog;
import com.upl.upl_tutorial_backend.service.InstructorApprovalLogService;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/approval-history")
public class InstructorApprovalLogController {


    private final InstructorApprovalLogService service;


    public InstructorApprovalLogController(
            InstructorApprovalLogService service
    ){
        this.service = service;
    }



    // GET ALL APPROVAL HISTORY

    @GetMapping
    public List<InstructorApprovalLog> getAllHistory(){

        return service.getAllHistory();

    }

}