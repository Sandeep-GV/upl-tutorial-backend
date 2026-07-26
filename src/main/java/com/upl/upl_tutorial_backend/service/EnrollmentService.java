package com.upl.upl_tutorial_backend.service;

import com.upl.upl_tutorial_backend.dto.EnrollmentRequest;
import com.upl.upl_tutorial_backend.entity.Enrollment;
import com.upl.upl_tutorial_backend.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public Enrollment enrollStudent(EnrollmentRequest request) {

        enrollmentRepository.findByStudentIdAndCourseId(
                request.getStudentId(),
                request.getCourseId()
        ).ifPresent(enrollment -> {
            throw new RuntimeException("Student is already enrolled in this course.");
        });

        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(request.getStudentId());
        enrollment.setCourseId(request.getCourseId());

        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByStudent(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourse(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    public void removeEnrollment(Long enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }
}