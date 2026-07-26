package com.upl.upl_tutorial_backend.dto;


public class CourseCompletionResponse {


    private Integer courseId;


    private Long studentId;


    private long totalTutorials;


    private long completedTutorials;


    private double completionPercentage;



    public CourseCompletionResponse() {

    }



    public Integer getCourseId() {

        return courseId;

    }



    public void setCourseId(Integer courseId) {

        this.courseId = courseId;

    }



    public Long getStudentId() {

        return studentId;

    }



    public void setStudentId(Long studentId) {

        this.studentId = studentId;

    }



    public long getTotalTutorials() {

        return totalTutorials;

    }



    public void setTotalTutorials(long totalTutorials) {

        this.totalTutorials = totalTutorials;

    }



    public long getCompletedTutorials() {

        return completedTutorials;

    }



    public void setCompletedTutorials(long completedTutorials) {

        this.completedTutorials = completedTutorials;

    }



    public double getCompletionPercentage() {

        return completionPercentage;

    }



    public void setCompletionPercentage(double completionPercentage) {

        this.completionPercentage = completionPercentage;

    }

}