package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.dto.AdminUserDTO;
import com.upl.upl_tutorial_backend.service.AdminUserService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/admin/users")
@CrossOrigin("*")
public class AdminUserController {



    private final AdminUserService adminUserService;



    public AdminUserController(
            AdminUserService adminUserService
    ){

        this.adminUserService = adminUserService;

    }







    // ==========================
    // GET ALL USERS
    // ==========================

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<AdminUserDTO> getAllUsers(){


        return adminUserService.getAllUsers();

    }








    // ==========================
    // GET USER BY ID
    // ==========================

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AdminUserDTO getUserById(

            @PathVariable Long id

    ){


        return adminUserService.getUserById(id);

    }








    // ==========================
    // UPDATE USER STATUS
    // ==========================

    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public AdminUserDTO updateStatus(

            @PathVariable Long id,

            @RequestParam String status

    ){


        return adminUserService.updateStatus(
                id,
                status
        );

    }


}