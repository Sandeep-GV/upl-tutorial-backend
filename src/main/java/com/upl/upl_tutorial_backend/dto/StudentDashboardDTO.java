package com.upl.upl_tutorial_backend.dto;


public class StudentDashboardDTO {


    private Long studentId;

    private long totalCourses;

    private long totalTutorials;

    private long completedTutorials;

    private double completionPercentage;



    public StudentDashboardDTO(){}



    public StudentDashboardDTO(
            Long studentId,
            long totalCourses,
            long totalTutorials,
            long completedTutorials,
            double completionPercentage
    ){

        this.studentId = studentId;
        this.totalCourses = totalCourses;
        this.totalTutorials = totalTutorials;
        this.completedTutorials = completedTutorials;
        this.completionPercentage = completionPercentage;

    }



    public Long getStudentId() {
        return studentId;
    }


    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }



    public long getTotalCourses() {
        return totalCourses;
    }


    public void setTotalCourses(long totalCourses) {
        this.totalCourses = totalCourses;
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