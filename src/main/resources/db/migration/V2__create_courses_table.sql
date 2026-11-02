CREATE TABLE courses (
    course_id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description LONGTEXT,
    price DOUBLE,
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6),

    PRIMARY KEY (course_id),
    CONSTRAINT uk_courses_title UNIQUE (title)
);