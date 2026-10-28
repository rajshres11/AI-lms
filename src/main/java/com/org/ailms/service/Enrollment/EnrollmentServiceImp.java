package com.org.ailms.service.Enrollment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.org.ailms.dto.EnrollmentRequest;
import com.org.ailms.dto.EnrollmentResponse;
import com.org.ailms.dto.EnrollmentStatusRequest;
import com.org.ailms.entity.Course;
import com.org.ailms.entity.Enrollment;
import com.org.ailms.entity.User;
import com.org.ailms.enums.Role;
import com.org.ailms.enums.Status;
import com.org.ailms.exception.CourseNotFoundException;
import com.org.ailms.exception.UserNotFoundException;
import com.org.ailms.repository.CourseRepository;
import com.org.ailms.repository.EnrollmentRepository;
import com.org.ailms.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImp implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public EnrollmentResponse newEnrollment(EnrollmentRequest er) {
        Enrollment enrollment = new Enrollment();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User student = userRepository.findByEmail(username).orElseThrow(() -> new UserNotFoundException());

        Course course = courseRepository.findById(er.getCourseId()).orElseThrow(() -> new CourseNotFoundException());
        enrollment.setCourse(course);
        enrollment.setCreatedAt(LocalDateTime.now());
        enrollment.setStatus(Status.ENROLLED);
        enrollment.setEnrolledAt(LocalDateTime.now());

        if (enrollmentRepository.existsByStudent_UserIdAndCourse_CourseId(student.getUserId(),
                course.getCourseId()) == true) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Student already enrolled to this course");
        }

        // User student = userRepository.findById(er.getUserId()).orElseThrow(() -> new
        // UserNotFoundException());

        if (student.getRole().equals(Role.ADMIN)) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Admin cannot enroll in a course");
        }
        enrollment.setStudent(student);
        Enrollment saved = enrollmentRepository.save(enrollment);

        EnrollmentResponse ers = new EnrollmentResponse();
        ers.setEnrollmentId(saved.getEnrollmentId());
        ers.setCourseId(saved.getCourse().getCourseId());
        ers.setStudetnId(saved.getStudent().getUserId());
        ers.setCreatedAt(saved.getCreatedAt());
        ers.setStatus(saved.getStatus());
        ers.setEnrolledAt(saved.getEnrolledAt());
        return ers;
    }

    @Override
    public void deleteEnrollment(Long enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }

    @Override
    public EnrollmentResponse updateStatus(Long enrollmentId, EnrollmentStatusRequest esr) {
        Enrollment saved = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enrollment not found"));

        saved.setStatus(esr.getStatus());
        saved.setUpdatedAt(LocalDateTime.now());
        Enrollment updated = enrollmentRepository.save(saved);

        EnrollmentResponse ers = new EnrollmentResponse();
        ers.setEnrollmentId(enrollmentId);
        ers.setCourseId(updated.getCourse().getCourseId());
        ers.setStudetnId(updated.getStudent().getUserId());
        ers.setUpdatedAt(updated.getUpdatedAt());
        ers.setStatus(updated.getStatus());
        ers.setEnrolledAt(updated.getEnrolledAt());
        return ers;
    }

    @Override
    public List<EnrollmentResponse> getAllEnrollment() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        List<EnrollmentResponse> ersList = new ArrayList<>();
        for (Enrollment e : enrollments) {
            EnrollmentResponse ers = new EnrollmentResponse();
            ers.setEnrollmentId(e.getEnrollmentId());
            ers.setCourseId(e.getCourse().getCourseId());
            ers.setStudetnId(e.getStudent().getUserId());
            ers.setUpdatedAt(e.getUpdatedAt());
            ers.setStatus(e.getStatus());
            ers.setEnrolledAt(e.getEnrolledAt());
            ersList.add(ers);
        }
        return ersList;
    }

    @Override
    public List<EnrollmentResponse> getAllEnrollmentByUserId(Long userId) {
        List<Enrollment> enrollments = enrollmentRepository.findByStudent_UserId(userId);
        if (enrollments == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No enrollment on this user till now");
        }
        List<EnrollmentResponse> ersList = new ArrayList<>();
        for (Enrollment e : enrollments) {
            EnrollmentResponse ers = new EnrollmentResponse();
            ers.setEnrollmentId(e.getEnrollmentId());
            ers.setCourseId(e.getCourse().getCourseId());
            ers.setStudetnId(e.getStudent().getUserId());
            ers.setUpdatedAt(e.getUpdatedAt());
            ers.setStatus(e.getStatus());
            ers.setEnrolledAt(e.getEnrolledAt());
            ersList.add(ers);
        }
        return ersList;
    }
}
