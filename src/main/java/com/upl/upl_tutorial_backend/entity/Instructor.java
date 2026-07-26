package com.upl.upl_tutorial_backend.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;



@Entity
@Data
@Table(name = "instructors")
public class Instructor {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private Long instructorId;





    // Every instructor belongs to a user

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "user_id",
            nullable = false
    )
    private User user;






    @Column(nullable = false)
    private String expertise;





    @Column(nullable = false)
    private String qualification;





    @Column(nullable = false)
    private Integer experience;





    @Column(nullable = false)
    private String status;





    @Column(name = "created_at")
    private LocalDateTime createdAt;






    @PrePersist
    public void beforeSave(){


        createdAt = LocalDateTime.now();


        if(status == null){

            status = "PENDING";

        }

    }


}