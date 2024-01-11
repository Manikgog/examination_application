package ru.examination.examination_application.service;

import ru.examination.examination_application.model.Question;

import java.util.Set;

public interface QuestionService {
    Question add(String question, String answer);
    Question remove(String q, String answer);
    Set<Question> getAll();
    Question getRandomQuestion();
}
