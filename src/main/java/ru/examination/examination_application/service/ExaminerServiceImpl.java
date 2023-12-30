package ru.examination.examination_application.service;

import org.springframework.stereotype.Service;
import ru.examination.examination_application.model.Question;

import java.util.Set;
import java.util.TreeSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questions;
    private CheckService checkService;
    public ExaminerServiceImpl(QuestionService questions, CheckService checkService){
        this.questions = questions;
        this.checkService = checkService;
    }
    public Set<Question> getQuestions(int amount){
        checkService.checkAmount(amount);
        Set<Question> questionCollection = new TreeSet<>();
        int count = 0;
        while(count < amount){
            Question q = questions.getRandomQuestion();
            if(questionCollection.add(q)){
                count++;
            }
        }
        return questionCollection;
    }
}
