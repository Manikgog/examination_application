package ru.examination.examination_application.service;

import org.springframework.stereotype.Service;
import ru.examination.examination_application.model.Question;
import ru.examination.examination_application.repo.MathQuestionRepositoryImpl;
import ru.examination.examination_application.repo.JavaQuestionRepositoryImpl;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionRepositoryImpl listOfJavaQuestions;
    private final MathQuestionRepositoryImpl listOfMathQuestions;
    private final CheckService checkService;
    public ExaminerServiceImpl(JavaQuestionRepositoryImpl listOfJavaQuestions,
                               MathQuestionRepositoryImpl listOfMathQuestions,
                               CheckService checkService){
        this.listOfJavaQuestions = listOfJavaQuestions;
        this.listOfMathQuestions = listOfMathQuestions;
        this.checkService = checkService;
    }

    /**
     * Метод для получения списка вопросов
     * в соответствии с числом переданным
     * в параметр метода. Вопросы попадают
     * в список случайным образом.
     * @param amount - запрашиваемое количество вопросов.
     * @return Set<Question> - список вопросов.
     */
    public Set<Question> getQuestions(int amount){
        checkService.checkAmount(amount);
        Set<Question> questionCollection = new TreeSet<>();
        int count = 0;
        Random rnd = new Random();
        while(count < amount){
            Question q;
            if(rnd.nextInt()%2 == 0) {
                q = listOfJavaQuestions.getRandom();
                if (questionCollection.add(q)) {
                    count++;
                }
            }else {
                q = listOfMathQuestions.getRandom();
                if (questionCollection.add(q)) {
                    count++;
                }
            }
        }
        return questionCollection;
    }
}
