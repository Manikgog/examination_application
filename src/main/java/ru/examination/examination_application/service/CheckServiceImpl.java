package ru.examination.examination_application.service;

import org.springframework.stereotype.Service;
import ru.examination.examination_application.exception.AddQuestionException;
import ru.examination.examination_application.exception.WrongAmountQuestionsRequestException;


@Service
public class CheckServiceImpl implements CheckService {
    private JavaQuestionService javaQuestionService;

    public CheckServiceImpl(JavaQuestionService javaQuestionService){
        this.javaQuestionService = javaQuestionService;
    }
    @Override
    public void check(String question, String answer){
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

    }

    public void checkAmount(int amount){
        if(amount > javaQuestionService.getAll().size()){
            throw new WrongAmountQuestionsRequestException("Слишком большое число вопросов.");
        }else if(amount <= 0){
            throw new WrongAmountQuestionsRequestException("Количество запрашиваемых вопросов должно быть больше нуля.");
        }
    }


}
