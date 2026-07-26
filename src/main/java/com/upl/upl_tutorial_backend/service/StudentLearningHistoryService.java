package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.dto.StudentLearningHistoryDTO;
import com.upl.upl_tutorial_backend.entity.Course;
import com.upl.upl_tutorial_backend.entity.StudentProgress;
import com.upl.upl_tutorial_backend.entity.Tutorial;

import com.upl.upl_tutorial_backend.repository.CourseRepository;
import com.upl.upl_tutorial_backend.repository.StudentProgressRepository;
import com.upl.upl_tutorial_backend.repository.TutorialRepository;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class StudentLearningHistoryService {



    private final StudentProgressRepository progressRepository;

    private final TutorialRepository tutorialRepository;

    private final CourseRepository courseRepository;




    public StudentLearningHistoryService(

            StudentProgressRepository progressRepository,

            TutorialRepository tutorialRepository,

            CourseRepository courseRepository

    ){

        this.progressRepository = progressRepository;

        this.tutorialRepository = tutorialRepository;

        this.courseRepository = courseRepository;

    }






    public List<StudentLearningHistoryDTO> getHistory(

            Long studentId

    ){


        return progressRepository
                .findByStudentIdAndStatus(
                        studentId,
                        "COMPLETED"
                )
                .stream()

                .map(progress -> {


                    Tutorial tutorial =

                            tutorialRepository
                                    .findById(
                                            progress.getTutorialId()
                                    )
                                    .orElse(null);



                    if(tutorial == null){

                        return null;

                    }



                    Course course =

                            tutorial.getCourse();



                    return new StudentLearningHistoryDTO(

                            course.getCourseId(),

                            course.getTitle(),

                            tutorial.getTutorialId(),

                            tutorial.getTitle(),

                            progress.getStatus(),

                            progress.getCompletedAt()

                    );


                })

                .filter(item -> item != null)

                .collect(Collectors.toList());

    }


}