package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.entity.InstructorApprovalLog;
import com.upl.upl_tutorial_backend.repository.InstructorApprovalLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InstructorApprovalLogService {


    @Autowired
    private InstructorApprovalLogRepository repository;



    // GET ALL APPROVAL LOGS
    public List<InstructorApprovalLog> getAllLogs() {

        return repository.findAll();

    }



    // GET ALL HISTORY (Controller uses this method)
    public List<InstructorApprovalLog> getAllHistory() {

        return repository.findAll();

    }



    // SAVE APPROVAL LOG
    public InstructorApprovalLog saveLog(
            InstructorApprovalLog log
    ) {

        return repository.save(log);

    }

}