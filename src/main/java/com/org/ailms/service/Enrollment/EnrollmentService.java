package com.org.ailms.service.Enrollment;

import java.util.List;

import com.org.ailms.dto.EnrollmentRequest;
import com.org.ailms.dto.EnrollmentResponse;
import com.org.ailms.dto.EnrollmentStatusRequest;

public interface EnrollmentService {
    public EnrollmentResponse newEnrollment(EnrollmentRequest er);
    public void deleteEnrollment(Long enrollmentId);
    public EnrollmentResponse updateStatus(Long enrollmentId,EnrollmentStatusRequest esr);
    public List<EnrollmentResponse> getAllEnrollment();
     public List<EnrollmentResponse> getAllEnrollmentByUserId(Long userId);
}
