package com.upl.upl_tutorial_backend.dto;


public class InstructorDashboardDTO {


    private Long instructorId;

    private long totalCourses;

    private long totalTutorials;

    private long activeCourses;

    private long inactiveCourses;



    public InstructorDashboardDTO(){

    }



    public InstructorDashboardDTO(

            Long instructorId,

            long totalCourses,

            long totalTutorials,

            long activeCourses,

            long inactiveCourses

    ){

        this.instructorId = instructorId;

        this.totalCourses = totalCourses;

        this.totalTutorials = totalTutorials;

        this.activeCourses = activeCourses;

        this.inactiveCourses = inactiveCourses;

    }





    public Long getInstructorId() {

        return instructorId;

    }


    public void setInstructorId(Long instructorId) {

        this.instructorId = instructorId;

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





    public long getActiveCourses() {

        return activeCourses;

    }


    public void setActiveCourses(long activeCourses) {

        this.activeCourses = activeCourses;

    }





    public long getInactiveCourses() {

        return inactiveCourses;

    }


    public void setInactiveCourses(long inactiveCourses) {

        this.inactiveCourses = inactiveCourses;

    }


}