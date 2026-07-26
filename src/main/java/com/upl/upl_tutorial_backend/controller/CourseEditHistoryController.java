package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.entity.CourseEditHistory;
import com.upl.upl_tutorial_backend.service.CourseEditHistoryService;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/course-history")
public class CourseEditHistoryController {



    private final CourseEditHistoryService service;



    public CourseEditHistoryController(
            CourseEditHistoryService service
    ){

        this.service = service;

    }





    // Get all course edit history
    @GetMapping
    public List<CourseEditHistory> getAllHistory(){


        return service.getAllHistory();

    }






    // Get history by history id
    @GetMapping("/{id}")
    public CourseEditHistory getHistoryById(
            @PathVariable Long id
    ){


        return service.getHistoryById(id);

    }







    // Get history by course id
    @GetMapping("/course/{courseId}")
    public List<CourseEditHistory> getHistoryByCourseId(
            @PathVariable Integer courseId
    ){


        return service.getHistoryByCourseId(courseId);

    }








    // Save course edit history
    @PostMapping
    public CourseEditHistory saveHistory(
            @RequestBody CourseEditHistory history
    ){


        return service.saveHistory(history);

    }







    // Delete history by course id
    @DeleteMapping("/course/{courseId}")
    public String deleteHistoryByCourseId(
            @PathVariable Integer courseId
    ){


        service.deleteHistoryByCourseId(courseId);


        return "Course history deleted successfully";

    }



}