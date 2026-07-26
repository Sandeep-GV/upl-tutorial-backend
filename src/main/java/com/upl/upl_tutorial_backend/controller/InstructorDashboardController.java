package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.dto.InstructorDashboardDTO;
import com.upl.upl_tutorial_backend.service.InstructorDashboardService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/instructor/dashboard")
@CrossOrigin("*")
public class InstructorDashboardController {



    private final InstructorDashboardService instructorDashboardService;





    public InstructorDashboardController(

            InstructorDashboardService instructorDashboardService

    ){

        this.instructorDashboardService = instructorDashboardService;

    }








    @GetMapping("/{instructorId}")
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    public InstructorDashboardDTO getDashboard(

            @PathVariable Long instructorId

    ){


        return instructorDashboardService
                .getDashboard(instructorId);


    }


}