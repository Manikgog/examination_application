package ru.examination.examination_application.repo;

import ru.examination.examination_application.model.Question;

import java.util.Set;

public interface QuestionRepository {
    void add(Question question);

    void remove(Question question);

    Set<Question> getAll();

    Question getRandom();
}
