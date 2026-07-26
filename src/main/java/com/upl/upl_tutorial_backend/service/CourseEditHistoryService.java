package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.entity.CourseEditHistory;
import com.upl.upl_tutorial_backend.repository.CourseEditHistoryRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
public class CourseEditHistoryService {


    private final CourseEditHistoryRepository repository;



    public CourseEditHistoryService(
            CourseEditHistoryRepository repository
    ){

        this.repository = repository;

    }




    // Save History
    public CourseEditHistory saveHistory(
            CourseEditHistory history
    ){

        return repository.save(history);

    }




    // Get All History
    public List<CourseEditHistory> getAllHistory(){

        return repository.findAll();

    }




    // Get History By ID
    public CourseEditHistory getHistoryById(
            Long id
    ){

        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Course history not found"
                        )
                );

    }




    // Get History By Course ID
    public List<CourseEditHistory> getHistoryByCourseId(
            Integer courseId
    ){

        return repository.findByCourseId(courseId);

    }




    // Delete History By Course ID
    @Transactional
    public void deleteHistoryByCourseId(
            Integer courseId
    ){

        repository.deleteByCourseId(courseId);

    }

}