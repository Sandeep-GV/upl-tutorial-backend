package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.entity.StudentProgress;
import com.upl.upl_tutorial_backend.service.StudentProgressService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/student/progress")
@CrossOrigin("*")
public class StudentProgressController {



    private final StudentProgressService studentProgressService;



    public StudentProgressController(

            StudentProgressService studentProgressService

    ){

        this.studentProgressService = studentProgressService;

    }





    // ==========================
    // MARK TUTORIAL COMPLETE
    // ==========================

    @PostMapping
    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")
    public StudentProgress markProgress(

            @RequestBody StudentProgress progress

    ){

        return studentProgressService
                .markProgress(progress);

    }







    // ==========================
    // GET STUDENT PROGRESS
    // ==========================

    @GetMapping("/{studentId}")
    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")
    public List<StudentProgress> getStudentProgress(

            @PathVariable Long studentId

    ){

        return studentProgressService
                .getStudentProgress(studentId);

    }


}