package com.upl.upl_tutorial_backend.dto;


import lombok.Data;


@Data
public class CourseRequestDTO {


    private String title;


    private String description;


    private String category;


    private Long instructorId;


}