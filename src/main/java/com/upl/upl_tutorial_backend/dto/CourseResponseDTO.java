package com.upl.upl_tutorial_backend.dto;


import lombok.Data;

import java.time.LocalDateTime;


@Data
public class CourseResponseDTO {


    private Long courseId;


    private String title;


    private String description;


    private String category;


    private String status;


    private Long instructorId;


    private String instructorName;


    private LocalDateTime createdAt;


}