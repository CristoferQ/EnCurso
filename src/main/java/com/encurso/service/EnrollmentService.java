package com.encurso.service;

import com.encurso.exception.ValidationException;

public class EnrollmentService {

    public String enroll(Long userId, Long courseId) {
        validateEnrollment(userId, courseId);
        return "Enrollment created successfully";
    }

    private void validateEnrollment(Long userId, Long courseId) {
        if (userId == null) {
            throw new ValidationException("User id must not be null.");
        }
        if (courseId == null) {
            throw new ValidationException("Course id must not be null.");
        }
    }
}