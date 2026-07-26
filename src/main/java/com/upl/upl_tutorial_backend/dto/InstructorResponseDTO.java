package com.upl.upl_tutorial_backend.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class InstructorResponseDTO {


    private Long instructorId;


    private Long userId;


    private String name;


    private String email;


    private String expertise;


    private String qualification;


    private Integer experience;


    private String status;


    private LocalDateTime createdAt;


}