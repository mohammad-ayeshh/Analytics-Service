package com.example.Analytics.Service.grade;

import org.springframework.context.ApplicationEvent;

public class GradeChangeEvent extends ApplicationEvent {
    private final Long gradeId;

    public GradeChangeEvent(Object source, Long gradeId) {
        super(source);
        this.gradeId = gradeId;
    }

    public Long getGradeId() {
        return gradeId;
    }
}