package com.upl.upl_tutorial_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="instructor_approval_log")
public class InstructorApprovalLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="log_id")
    private Long logId;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    private String action;


    private String remarks;


    @Column(name="action_by")
    private Long actionBy;


    @Column(name="created_at")
    private LocalDateTime createdAt;


    @PrePersist
    public void createdDate(){
        createdAt = LocalDateTime.now();
    }
}