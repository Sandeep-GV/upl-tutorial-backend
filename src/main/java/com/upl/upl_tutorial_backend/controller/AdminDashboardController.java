package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.dto.AdminDashboardDTO;
import com.upl.upl_tutorial_backend.service.AdminDashboardService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/admin/dashboard")
@CrossOrigin("*")
public class AdminDashboardController {



    private final AdminDashboardService adminDashboardService;



    public AdminDashboardController(
            AdminDashboardService adminDashboardService
    ){

        this.adminDashboardService = adminDashboardService;

    }






    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public AdminDashboardDTO getDashboard(){


        return adminDashboardService.getDashboard();


    }


}