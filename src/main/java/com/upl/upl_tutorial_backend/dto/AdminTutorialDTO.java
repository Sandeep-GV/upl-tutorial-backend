package com.upl.upl_tutorial_backend.dto;


public class AdminTutorialDTO {



    private Long tutorialId;


    private String title;


    private String description;


    private Integer courseId;


    private String status;





    public AdminTutorialDTO(

            Long tutorialId,

            String title,

            String description,

            Integer courseId,

            String status

    ){

        this.tutorialId = tutorialId;

        this.title = title;

        this.description = description;

        this.courseId = courseId;

        this.status = status;

    }







    public Long getTutorialId() {

        return tutorialId;

    }



    public String getTitle() {

        return title;

    }



    public String getDescription() {

        return description;

    }



    public Integer getCourseId() {

        return courseId;

    }



    public String getStatus() {

        return status;

    }


}