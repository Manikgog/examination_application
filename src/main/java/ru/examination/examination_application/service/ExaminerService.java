package ru.examination.examination_application.service;

import ru.examination.examination_application.model.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}
