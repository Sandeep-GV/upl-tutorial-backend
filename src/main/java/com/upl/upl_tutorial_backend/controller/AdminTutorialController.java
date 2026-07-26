package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.dto.AdminTutorialDTO;
import com.upl.upl_tutorial_backend.service.AdminTutorialService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/admin/tutorials")
@CrossOrigin("*")
public class AdminTutorialController {



    private final AdminTutorialService adminTutorialService;



    public AdminTutorialController(
            AdminTutorialService adminTutorialService
    ){

        this.adminTutorialService = adminTutorialService;

    }







    // ==========================
    // GET ALL TUTORIALS
    // ==========================

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<AdminTutorialDTO> getAllTutorials(){


        return adminTutorialService.getAllTutorials();

    }







    // ==========================
    // GET TUTORIAL BY ID
    // ==========================

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AdminTutorialDTO getTutorialById(

            @PathVariable Long id

    ){


        return adminTutorialService.getTutorialById(id);

    }







    // ==========================
    // UPDATE STATUS
    // ==========================

    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public AdminTutorialDTO updateStatus(

            @PathVariable Long id,

            @RequestParam String status

    ){


        return adminTutorialService.updateStatus(
                id,
                status
        );

    }


}