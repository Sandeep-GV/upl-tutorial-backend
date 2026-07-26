package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.dto.StudentProfileDTO;
import com.upl.upl_tutorial_backend.service.StudentProfileService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/student/profile")
@CrossOrigin("*")
public class StudentProfileController {



    private final StudentProfileService service;




    public StudentProfileController(

            StudentProfileService service

    ){

        this.service = service;

    }






    // =====================================
    // GET STUDENT PROFILE
    // =====================================

    @GetMapping("/{studentId}")

    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")

    public StudentProfileDTO getProfile(

            @PathVariable Long studentId

    ){

        return service.getProfile(studentId);

    }


}