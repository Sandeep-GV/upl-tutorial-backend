package com.upl.upl_tutorial_backend.repository;


import com.upl.upl_tutorial_backend.entity.CourseEditHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseEditHistoryRepository
        extends JpaRepository<CourseEditHistory, Long> {


    List<CourseEditHistory> findByCourseId(Integer courseId);



    void deleteByCourseId(Integer courseId);


}