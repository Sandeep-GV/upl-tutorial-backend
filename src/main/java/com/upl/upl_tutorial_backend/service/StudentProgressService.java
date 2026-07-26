package com.upl.upl_tutorial_backend.service;




import com.upl.upl_tutorial_backend.dto.CourseCompletionResponse;
import com.upl.upl_tutorial_backend.entity.StudentProgress;

import com.upl.upl_tutorial_backend.repository.StudentProgressRepository;
import com.upl.upl_tutorial_backend.repository.TutorialRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentProgressService {


    private final StudentProgressRepository studentProgressRepository;

    private final TutorialRepository tutorialRepository;



    public StudentProgressService(
            StudentProgressRepository studentProgressRepository,
            TutorialRepository tutorialRepository
    ) {

        this.studentProgressRepository = studentProgressRepository;
        this.tutorialRepository = tutorialRepository;

    }



    // CREATE / MARK PROGRESS
    public StudentProgress markProgress(
            StudentProgress progress
    ) {

        return studentProgressRepository.save(progress);

    }



    // GET ALL PROGRESS
    public List<StudentProgress> getAllProgress() {

        return studentProgressRepository.findAll();

    }



    // GET PROGRESS BY ID
    public StudentProgress getProgressById(
            Long id
    ) {

        return studentProgressRepository
                .findById(id)
                .orElse(null);

    }



    // GET STUDENT PROGRESS
    public List<StudentProgress> getStudentProgress(
            Long studentId
    ) {

        return studentProgressRepository
                .findByStudentId(studentId);

    }



    // GET TUTORIAL PROGRESS
    public List<StudentProgress> getTutorialProgress(
            Long tutorialId
    ) {

        return studentProgressRepository
                .findByTutorialId(tutorialId);

    }



    // DELETE PROGRESS
    public void deleteProgress(
            Long id
    ) {

        studentProgressRepository.deleteById(id);

    }




    // COURSE COMPLETION PERCENTAGE
    public CourseCompletionResponse getCourseCompletion(
            Integer courseId,
            Long studentId
    ) {


        // Count total tutorials in course
        long totalTutorials =
                tutorialRepository
                        .countByCourse_CourseId(courseId);



        // Count completed tutorials by student
        long completedTutorials =
                studentProgressRepository
                        .findByStudentIdAndStatus(
                                studentId,
                                "COMPLETED"
                        )
                        .stream()
                        .filter(progress ->
                                progress.getTutorialId() != null
                        )
                        .filter(progress -> {

                            return tutorialRepository
                                    .findById(
                                            progress.getTutorialId()
                                    )
                                    .map(tutorial ->
                                            tutorial.getCourse()
                                                    .getCourseId()
                                                    .equals(courseId)
                                    )
                                    .orElse(false);

                        })
                        .count();



        double completionPercentage = 0;


        if(totalTutorials > 0) {

            completionPercentage =
                    ((double) completedTutorials /
                            totalTutorials) * 100;

        }



        CourseCompletionResponse response =
                new CourseCompletionResponse();


        response.setCourseId(courseId);

        // FIXED: Long -> Long
        response.setStudentId(studentId);

        response.setTotalTutorials(
                totalTutorials
        );

        response.setCompletedTutorials(
                completedTutorials
        );

        response.setCompletionPercentage(
                completionPercentage
        );


        return response;

    }

}