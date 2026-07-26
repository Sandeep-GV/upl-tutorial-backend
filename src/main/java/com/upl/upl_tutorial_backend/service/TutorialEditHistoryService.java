package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.entity.TutorialEditHistory;
import com.upl.upl_tutorial_backend.repository.TutorialEditHistoryRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TutorialEditHistoryService {


    private final TutorialEditHistoryRepository repository;


    public TutorialEditHistoryService(
            TutorialEditHistoryRepository repository
    ) {

        this.repository = repository;

    }


    // Save History
    public TutorialEditHistory saveHistory(
            TutorialEditHistory history
    ) {

        return repository.save(history);

    }


    // Get All History
    public List<TutorialEditHistory> getAllHistory() {

        return repository.findAll();

    }


    // Get History By History ID
    public TutorialEditHistory getHistoryById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Tutorial history not found"));

    }


    // Get History By Tutorial ID
    public List<TutorialEditHistory> getHistoryByTutorialId(
            Long tutorialId
    ) {

        return repository.findByTutorialId(tutorialId);

    }


    // Delete History By Tutorial ID
    @Transactional
    public void deleteHistoryByTutorialId(
            Long tutorialId
    ) {

        repository.deleteByTutorialId(tutorialId);

    }

}