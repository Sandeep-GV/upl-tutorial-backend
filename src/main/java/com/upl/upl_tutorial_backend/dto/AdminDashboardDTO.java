package com.upl.upl_tutorial_backend.dto;


public class AdminDashboardDTO {



    private long totalUsers;

    private long totalStudents;

    private long totalInstructors;

    private long totalCourses;

    private long totalTutorials;

    private long activeCourses;

    private long inactiveCourses;

    private long activeTutorials;

    private long inactiveTutorials;





    public AdminDashboardDTO(

            long totalUsers,

            long totalStudents,

            long totalInstructors,

            long totalCourses,

            long totalTutorials,

            long activeCourses,

            long inactiveCourses,

            long activeTutorials,

            long inactiveTutorials

    ){


        this.totalUsers = totalUsers;

        this.totalStudents = totalStudents;

        this.totalInstructors = totalInstructors;

        this.totalCourses = totalCourses;

        this.totalTutorials = totalTutorials;

        this.activeCourses = activeCourses;

        this.inactiveCourses = inactiveCourses;

        this.activeTutorials = activeTutorials;

        this.inactiveTutorials = inactiveTutorials;


    }






    public long getTotalUsers() {
        return totalUsers;
    }



    public long getTotalStudents() {
        return totalStudents;
    }



    public long getTotalInstructors() {
        return totalInstructors;
    }



    public long getTotalCourses() {
        return totalCourses;
    }



    public long getTotalTutorials() {
        return totalTutorials;
    }



    public long getActiveCourses() {
        return activeCourses;
    }



    public long getInactiveCourses() {
        return inactiveCourses;
    }



    public long getActiveTutorials() {
        return activeTutorials;
    }



    public long getInactiveTutorials() {
        return inactiveTutorials;
    }


}