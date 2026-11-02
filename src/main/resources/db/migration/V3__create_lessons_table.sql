CREATE TABLE lessons (
    lesson_id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    video_url VARCHAR(255) NOT NULL,
    created_at DATETIME(6),
    updated_at DATETIME(6),
    course_id BIGINT NOT NULL,

    PRIMARY KEY (lesson_id),

    CONSTRAINT uk_lessons_title UNIQUE (title),
    CONSTRAINT uk_lessons_video_url UNIQUE (video_url),

    CONSTRAINT fk_lessons_course
        FOREIGN KEY (course_id)
        REFERENCES courses(course_id)
);