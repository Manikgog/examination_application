package ru.examination.examination_application.repo;

import org.springframework.stereotype.Repository;
import ru.examination.examination_application.ExaminationApplication;
import ru.examination.examination_application.exception.AddQuestionException;
import ru.examination.examination_application.exception.WrongQuestionException;
import ru.examination.examination_application.model.Question;

import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Repository
public class ListOfQuestions {
    private Set<Question> questions;

    public ListOfQuestions(){
        questions = new TreeSet<>(ExaminationApplication.questionsList);
    }

    public void add(Question question){
        if(!questions.add(question)){
            throw new AddQuestionException("Такой вопрос уже есть");
        }
    }

    public void remove(Question question){
        if(!questions.remove(question)) {
            throw new WrongQuestionException("Такой вопрос отсутствует в списке");
        }
    }

    public Set<Question> getAll(){
        return Collections.unmodifiableSet(questions);
    }

    public Question getRandom(){
        Random rnd = new Random();
        return questions
                .stream()
                .collect(Collectors.toList())
                .get(Math.abs(rnd.nextInt() % questions.size()));
    }


}
