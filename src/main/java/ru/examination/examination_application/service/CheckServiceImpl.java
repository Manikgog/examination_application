package ru.examination.examination_application.service;

import org.springframework.stereotype.Service;
import ru.examination.examination_application.exception.AddQuestionException;
import ru.examination.examination_application.exception.WrongAmountQuestionsRequestException;
import ru.examination.examination_application.repo.MathQuestionRepositoryImpl;
import ru.examination.examination_application.repo.QuestionRepositoryImpl;


@Service
public class CheckServiceImpl implements CheckService {
    private final QuestionRepositoryImpl listOfJavaQuestions;
    private final MathQuestionRepositoryImpl listOfMathQuestions;

    public CheckServiceImpl(QuestionRepositoryImpl listOfJavaQuestions,
                            MathQuestionRepositoryImpl listOfMathQuestions){
        this.listOfJavaQuestions = listOfJavaQuestions;
        this.listOfMathQuestions = listOfMathQuestions;
    }
    @Override
    public Throwable check(String question, String answer){
        String str = "";
        if(question == null || answer == null) {
            if (question == null && answer == null) {
                str += "Ошибка: необходимо ввести вопрос и ответ.";
            } else if (question == null) {
                str += "Ошибка: необходимо ввести вопрос.";
            } else if (answer == null) {
                str += "Ошибка: необходимо ввести ответ.";
            }
            throw new AddQuestionException(str);
        }

        return null;
    }

    public void checkAmount(int amount){
        if(amount > listOfJavaQuestions.getAll().size() + listOfMathQuestions.getAll().size()){
            throw new WrongAmountQuestionsRequestException("Слишком большое число вопросов.");
        }else if(amount <= 0){
            throw new WrongAmountQuestionsRequestException("Количество запрашиваемых вопросов должно быть больше нуля.");
        }
    }


}
