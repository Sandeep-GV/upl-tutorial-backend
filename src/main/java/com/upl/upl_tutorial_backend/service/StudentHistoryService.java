package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.entity.StudentProgress;
import com.upl.upl_tutorial_backend.repository.StudentProgressRepository;

import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class StudentHistoryService {



    private final StudentProgressRepository progressRepository;



    public StudentHistoryService(
            StudentProgressRepository progressRepository
    ){

        this.progressRepository = progressRepository;

    }





    // ==========================
    // GET STUDENT LEARNING HISTORY
    // ==========================

    public List<StudentProgress> getStudentHistory(
            Long studentId
    ){

        return progressRepository
                .findByStudentId(studentId);

    }



}