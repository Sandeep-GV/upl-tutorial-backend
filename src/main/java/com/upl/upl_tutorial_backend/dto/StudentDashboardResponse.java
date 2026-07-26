package com.upl.upl_tutorial_backend.dto;


import java.util.List;


public class StudentDashboardResponse {


    private Long studentId;

    private long totalCourses;

    private long completedTutorials;

    private long totalTutorials;

    private double overallCompletionPercentage;


    public StudentDashboardResponse() {

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


    public long getCompletedTutorials() {
        return completedTutorials;
    }


    public void setCompletedTutorials(long completedTutorials) {
        this.completedTutorials = completedTutorials;
    }


    public long getTotalTutorials() {
        return totalTutorials;
    }


    public void setTotalTutorials(long totalTutorials) {
        this.totalTutorials = totalTutorials;
    }


    public double getOverallCompletionPercentage() {
        return overallCompletionPercentage;
    }


    public void setOverallCompletionPercentage(
            double overallCompletionPercentage
    ) {

        this.overallCompletionPercentage =
                overallCompletionPercentage;

    }

}