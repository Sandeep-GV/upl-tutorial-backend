package com.upl.upl_tutorial_backend.dto;


import lombok.Data;


@Data
public class InstructorRequestDTO {


    private Long userId;

    private String expertise;

    private String qualification;

    private Integer experience;


}