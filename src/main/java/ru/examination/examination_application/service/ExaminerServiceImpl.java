package ru.examination.examination_application.service;

import org.springframework.stereotype.Service;
import ru.examination.examination_application.model.Question;
import ru.examination.examination_application.repo.QuestionRepository;

import java.util.Set;
import java.util.TreeSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionRepository listOfQuestions;
    private final CheckService checkService;
    public ExaminerServiceImpl(QuestionRepository listOfQuestions,
                               CheckService checkService){
        this.listOfQuestions = listOfQuestions;
        this.checkService = checkService;
    }
    public Set<Question> getQuestions(int amount){
        checkService.checkAmount(amount);
        Set<Question> questionCollection = new TreeSet<>();
        int count = 0;
        while(count < amount){
            Question q = listOfQuestions.getRandom();
            if(questionCollection.add(q)){
                count++;
            }
        }
        return questionCollection;
    }
}
