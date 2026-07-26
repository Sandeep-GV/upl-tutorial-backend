package com.upl.upl_tutorial_backend.dto;


public class StudentProfileDTO {


    private Long studentId;

    private String name;

    private String email;

    private String role;

    private long enrolledCourses;

    private long completedTutorials;



    public StudentProfileDTO() {

    }




    public StudentProfileDTO(

            Long studentId,

            String name,

            String email,

            String role,

            long enrolledCourses,

            long completedTutorials

    ){

        this.studentId = studentId;

        this.name = name;

        this.email = email;

        this.role = role;

        this.enrolledCourses = enrolledCourses;

        this.completedTutorials = completedTutorials;

    }





    public Long getStudentId() {

        return studentId;

    }


    public void setStudentId(Long studentId) {

        this.studentId = studentId;

    }



    public String getName() {

        return name;

    }


    public void setName(String name) {

        this.name = name;

    }



    public String getEmail() {

        return email;

    }


    public void setEmail(String email) {

        this.email = email;

    }



    public String getRole() {

        return role;

    }


    public void setRole(String role) {

        this.role = role;

    }



    public long getEnrolledCourses() {

        return enrolledCourses;

    }


    public void setEnrolledCourses(long enrolledCourses) {

        this.enrolledCourses = enrolledCourses;

    }



    public long getCompletedTutorials() {

        return completedTutorials;

    }


    public void setCompletedTutorials(long completedTutorials) {

        this.completedTutorials = completedTutorials;

    }

}