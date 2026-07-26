package com.upl.upl_tutorial_backend.dto;


public class StudentCourseProgressDTO {


    private Integer courseId;

    private String courseName;

    private long totalTutorials;

    private long completedTutorials;

    private long remainingTutorials;

    private double completionPercentage;



    public StudentCourseProgressDTO(){}



    public StudentCourseProgressDTO(

            Integer courseId,
            String courseName,
            long totalTutorials,
            long completedTutorials,
            long remainingTutorials,
            double completionPercentage

    ){

        this.courseId = courseId;
        this.courseName = courseName;
        this.totalTutorials = totalTutorials;
        this.completedTutorials = completedTutorials;
        this.remainingTutorials = remainingTutorials;
        this.completionPercentage = completionPercentage;

    }




    public Integer getCourseId() {
        return courseId;
    }


    public String getCourseName() {
        return courseName;
    }


    public long getTotalTutorials() {
        return totalTutorials;
    }


    public long getCompletedTutorials() {
        return completedTutorials;
    }


    public long getRemainingTutorials() {
        return remainingTutorials;
    }


    public double getCompletionPercentage() {
        return completionPercentage;
    }

}