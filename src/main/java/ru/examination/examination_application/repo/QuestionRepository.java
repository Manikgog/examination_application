package ru.examination.examination_application.repo;

import ru.examination.examination_application.model.Question;

import java.util.Set;

public interface QuestionRepository {
    Question add(Question question);

    Question remove(Question question);

    Set<Question> getAll();

    Question getRandom();
}
