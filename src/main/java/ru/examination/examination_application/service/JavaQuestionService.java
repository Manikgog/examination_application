package ru.examination.examination_application.service;

import org.springframework.stereotype.Service;
import ru.examination.examination_application.model.Question;
import ru.examination.examination_application.repo.QuestionRepository;
import ru.examination.examination_application.repo.QuestionRepositoryImpl;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository listOfQuestions;
    private final CheckService checkService;

    public JavaQuestionService(QuestionRepositoryImpl listOfQuestions, CheckService checkService) {
        this.listOfQuestions = listOfQuestions;
        this.checkService = checkService;
    }

    public Question add(String question, String answer) {
        checkService.check(question, answer);
        Question q = new Question(question, answer);
        listOfQuestions.add(q);
        return q;
    }

    public Question remove(String q, String answer) {
        checkService.check(q, answer);
        Question question = new Question(q, answer);
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
