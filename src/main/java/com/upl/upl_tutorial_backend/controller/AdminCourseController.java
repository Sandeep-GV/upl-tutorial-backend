package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.dto.AdminCourseDTO;
import com.upl.upl_tutorial_backend.service.AdminCourseService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/admin/courses")
@CrossOrigin("*")
public class AdminCourseController {



    private final AdminCourseService adminCourseService;



    public AdminCourseController(
            AdminCourseService adminCourseService
    ){

        this.adminCourseService = adminCourseService;

    }








    // ==========================
    // GET ALL COURSES
    // ==========================

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<AdminCourseDTO> getAllCourses(){


        return adminCourseService.getAllCourses();

    }








    // ==========================
    // GET COURSE BY ID
    // ==========================

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AdminCourseDTO getCourseById(

            @PathVariable Integer id

    ){


        return adminCourseService.getCourseById(id);

    }








    // ==========================
    // UPDATE COURSE STATUS
    // ==========================

    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public AdminCourseDTO updateStatus(

            @PathVariable Integer id,

            @RequestParam String status

    ){


        return adminCourseService.updateStatus(

                id,

                status

        );

    }


}