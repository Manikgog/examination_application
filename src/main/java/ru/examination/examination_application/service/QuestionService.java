package ru.examination.examination_application.service;

import ru.examination.examination_application.model.Question;

import java.util.Set;

public interface QuestionService {
    Question add(String question, String answer);
    Question remove(Question question);
    Set<Question> getAll();
    Question getRandomQuestion();
}
