package com.upl.upl_tutorial_backend.dto;


public class StudentCompletedCourseDTO {


    private Integer courseId;

    private String courseName;

    private long totalTutorials;

    private long completedTutorials;

    private double completionPercentage;



    public StudentCompletedCourseDTO(){}



    public StudentCompletedCourseDTO(

            Integer courseId,
            String courseName,
            long totalTutorials,
            long completedTutorials,
            double completionPercentage

    ){

        this.courseId = courseId;
        this.courseName = courseName;
        this.totalTutorials = totalTutorials;
        this.completedTutorials = completedTutorials;
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


    public double getCompletionPercentage() {
        return completionPercentage;
    }

}