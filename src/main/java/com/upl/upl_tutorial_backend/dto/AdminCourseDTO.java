package com.upl.upl_tutorial_backend.dto;


public class AdminCourseDTO {



    private Integer courseId;


    private String title;


    private String description;


    private String duration;


    private Integer instructorId;


    private String status;





    public AdminCourseDTO(

            Integer courseId,

            String title,

            String description,

            String duration,

            Integer instructorId,

            String status

    ){

        this.courseId = courseId;

        this.title = title;

        this.description = description;

        this.duration = duration;

        this.instructorId = instructorId;

        this.status = status;

    }







    public Integer getCourseId() {

        return courseId;

    }



    public String getTitle() {

        return title;

    }



    public String getDescription() {

        return description;

    }



    public String getDuration() {

        return duration;

    }



    public Integer getInstructorId() {

        return instructorId;

    }



    public String getStatus() {

        return status;

    }


}