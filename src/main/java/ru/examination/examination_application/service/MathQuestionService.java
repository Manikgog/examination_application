package ru.examination.examination_application.service;

import org.springframework.stereotype.Service;
import ru.examination.examination_application.model.Question;
import ru.examination.examination_application.repo.MathQuestionRepositoryImpl;
import ru.examination.examination_application.repo.QuestionRepository;

import java.util.Set;

@Service
public class MathQuestionService implements QuestionService {
    private final QuestionRepository listOfQuestions;
    private final CheckService checkService;

    public MathQuestionService(MathQuestionRepositoryImpl listOfQuestions, CheckService checkService) {
        this.listOfQuestions = listOfQuestions;
        this.checkService = checkService;
    }

    /**
     * Метод для добавления вопроса и ответа в список.
     * @param question - вопрос в виде String.
     * @param answer - ответ в виде String.
     * @return Question - объект класса Question.
     */
    public Question add(String question, String answer) {
        checkService.check(question, answer);
        Question q = new Question(question, answer);
        listOfQuestions.add(q);
        return q;
    }

    /**
     * Метод для удаления вопроса и ответа из списка вопросов.
     * @param q - вопрос в виде String.
     * @param answer - ответ в виде String.
     * @return Question - объект класса Question.
     */
    public Question remove(String q, String answer) {
        checkService.check(q, answer);
        Question question = new Question(q, answer);
        listOfQuestions.remove(question);
        return question;
    }

    /**
     * Метод для получения списка всех вопросов с ответами.
     * @return Set<Question>.
     */
    public Set<Question> getAll() {
        return listOfQuestions.getAll();
    }

//    public Question getRandomQuestion() {
//        return listOfQuestions.getRandom();
//    }
}
