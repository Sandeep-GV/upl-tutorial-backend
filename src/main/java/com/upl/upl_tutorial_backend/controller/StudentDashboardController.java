package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.dto.StudentDashboardDTO;
import com.upl.upl_tutorial_backend.service.StudentDashboardService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/student/dashboard")
@CrossOrigin("*")
public class StudentDashboardController {



    private final StudentDashboardService studentDashboardService;




    public StudentDashboardController(

            StudentDashboardService studentDashboardService

    ){

        this.studentDashboardService = studentDashboardService;

    }







    @GetMapping("/{studentId}")
    @PreAuthorize("hasAnyRole('ADMIN','STUDENT')")
    public StudentDashboardDTO getDashboard(

            @PathVariable Long studentId

    ){


        return studentDashboardService
                .getDashboard(studentId);


    }


}