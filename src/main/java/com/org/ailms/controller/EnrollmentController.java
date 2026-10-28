package com.org.ailms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.ailms.dto.ApiResponse;
import com.org.ailms.dto.EnrollmentRequest;
import com.org.ailms.dto.EnrollmentResponse;
import com.org.ailms.dto.EnrollmentStatusRequest;
import com.org.ailms.service.Enrollment.EnrollmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    // Create Enrollment
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<EnrollmentResponse>> newEnrollment(
          @Valid @RequestBody EnrollmentRequest req) {

        EnrollmentResponse res = enrollmentService.newEnrollment(req);

        return new ResponseEntity<>(
                new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "Enrollment created",
                        res),
                HttpStatus.CREATED);
    }

    // Delete Enrollment
    @DeleteMapping("/delete/{enrollmentId}")
    public ResponseEntity<ApiResponse<String>> deleteEnrollment(
            @PathVariable Long enrollmentId) {

        enrollmentService.deleteEnrollment(enrollmentId);

        return new ResponseEntity<>(
                new ApiResponse<>(
                        HttpStatus.NO_CONTENT.value(),
                        "Enrollment deleted",
                        null),
                HttpStatus.NO_CONTENT);
    }

    // Update Enrollment Status
    @PutMapping("/changestatus/{enrollmentId}")
    public ResponseEntity<ApiResponse<EnrollmentResponse>> updateStatus(
            @PathVariable Long enrollmentId,
            @RequestBody EnrollmentStatusRequest req) {

        EnrollmentResponse res =
                enrollmentService.updateStatus(enrollmentId, req);

        return new ResponseEntity<>(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Enrollment status updated",
                        res),
                HttpStatus.OK);
    }

    // Get All Enrollments
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<EnrollmentResponse>>> getAllEnrollment() {

        List<EnrollmentResponse> res =
                enrollmentService.getAllEnrollment();

        return new ResponseEntity<>(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "All enrollments fetched",
                        res),
                HttpStatus.OK);
    }

    // Get Enrollments By User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<EnrollmentResponse>>> getAllEnrollmentByUserId(
            @PathVariable Long userId) {

        List<EnrollmentResponse> res =
                enrollmentService.getAllEnrollmentByUserId(userId);

        return new ResponseEntity<>(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "User enrollments fetched",
                        res),
                HttpStatus.OK);
    }
}