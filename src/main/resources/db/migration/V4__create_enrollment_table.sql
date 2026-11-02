CREATE TABLE enrollment (
    enrollment_id BIGINT NOT NULL AUTO_INCREMENT,
    enrolled_at DATETIME(6),
    status VARCHAR(255),
    created_at DATETIME(6),
    updated_at DATETIME(6),
    student_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,

    PRIMARY KEY (enrollment_id),

    CONSTRAINT fk_enrollments_student
        FOREIGN KEY (student_id)
        REFERENCES users(user_id),

    CONSTRAINT fk_enrollments_course
        FOREIGN KEY (course_id)
        REFERENCES courses(course_id)
);