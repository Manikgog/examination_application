package ru.examination.examination_application.service;

import org.springframework.stereotype.Service;
import ru.examination.examination_application.model.Question;
import ru.examination.examination_application.repo.QuestionRepository;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository listOfQuestions;

    public JavaQuestionService(QuestionRepository listOfQuestions) {
        this.listOfQuestions = listOfQuestions;
    }

    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        listOfQuestions.add(q);
        return q;
    }

    public Question remove(Question question) {
        listOfQuestions.remove(question);
        return question;
    }

    public Set<Question> getAll() {
        return listOfQuestions.getAll();
    }

    public Question getRandomQuestion() {
        return listOfQuestions.getRandom();
    }
}
