package com.upl.upl_tutorial_backend.repository;


import com.upl.upl_tutorial_backend.entity.TutorialEditHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TutorialEditHistoryRepository
        extends JpaRepository<TutorialEditHistory, Long> {


    List<TutorialEditHistory> findByTutorialId(Long tutorialId);


    void deleteByTutorialId(Long tutorialId);

}