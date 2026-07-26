package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.dto.ApprovalRequest;
import com.upl.upl_tutorial_backend.dto.InstructorRequestDTO;
import com.upl.upl_tutorial_backend.dto.InstructorResponseDTO;

import com.upl.upl_tutorial_backend.service.InstructorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/instructors")
@CrossOrigin("*")
public class InstructorController {



    private final InstructorService instructorService;



    public InstructorController(
            InstructorService instructorService
    ){

        this.instructorService = instructorService;

    }






    // =====================================
    // REGISTER INSTRUCTOR
    // Only INSTRUCTOR role
    // =====================================

    @PostMapping
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public ResponseEntity<InstructorResponseDTO> registerInstructor(

            @RequestBody InstructorRequestDTO request

    ){


        InstructorResponseDTO response =

                instructorService.registerInstructor(request);



        return new ResponseEntity<>(

                response,

                HttpStatus.CREATED

        );

    }








    // =====================================
    // GET ALL INSTRUCTORS
    // ADMIN + INSTRUCTOR + STUDENT
    // =====================================

    @GetMapping
    @PreAuthorize(
            "hasAnyRole('ADMIN','INSTRUCTOR','STUDENT')"
    )
    public ResponseEntity<List<InstructorResponseDTO>> getAllInstructors(){


        return ResponseEntity.ok(

                instructorService.getAllInstructors()

        );

    }









    // =====================================
    // GET INSTRUCTOR BY ID
    // ADMIN + INSTRUCTOR + STUDENT
    // =====================================

    @GetMapping("/{id}")
    @PreAuthorize(
            "hasAnyRole('ADMIN','INSTRUCTOR','STUDENT')"
    )
    public ResponseEntity<InstructorResponseDTO> getInstructorById(

            @PathVariable Long id

    ){


        return ResponseEntity.ok(

                instructorService.getInstructorById(id)

        );

    }









    // =====================================
    // APPROVE / REJECT INSTRUCTOR
    // ADMIN ONLY
    // =====================================

    @PutMapping("/approve/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<InstructorResponseDTO> approveInstructor(

            @PathVariable Long id,


            @RequestBody ApprovalRequest request

    ){


        InstructorResponseDTO response =

                instructorService.approveInstructor(
                        id,
                        request
                );



        return ResponseEntity.ok(

                response

        );

    }



}