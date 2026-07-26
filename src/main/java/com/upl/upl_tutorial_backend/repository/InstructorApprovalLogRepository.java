package com.upl.upl_tutorial_backend.repository;

import com.upl.upl_tutorial_backend.entity.InstructorApprovalLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InstructorApprovalLogRepository
        extends JpaRepository<InstructorApprovalLog, Long>{

}