package ru.examination.examination_application.service;

import org.springframework.stereotype.Service;
import ru.examination.examination_application.exception.AddQuestionException;
import ru.examination.examination_application.exception.WrongAmountQuestionsRequestException;
import ru.examination.examination_application.repo.MathQuestionRepositoryImpl;
import ru.examination.examination_application.repo.JavaQuestionRepositoryImpl;

import java.util.ArrayList;
import java.util.List;


@Service
public class CheckServiceImpl implements CheckService {
    private final JavaQuestionRepositoryImpl listOfJavaQuestions;
    private final MathQuestionRepositoryImpl listOfMathQuestions;

    public CheckServiceImpl(JavaQuestionRepositoryImpl listOfJavaQuestions,
                            MathQuestionRepositoryImpl listOfMathQuestions){
        this.listOfJavaQuestions = listOfJavaQuestions;
        this.listOfMathQuestions = listOfMathQuestions;
    }

    /**
     * Метод для проверки параметров на null.
     * В случае наличия null, выбрасывается исключение AddQuestionException()
     * c текстом ошибки.
     * @param question - вопрос в виде String.
     * @param answer - ответ в виде String.
     * @return void
     */
    @Override
    public Throwable check(String question, String answer){
        List<String> strArr = new ArrayList<>();
        if(question == null || question.isEmpty() ||
                answer == null || answer.isEmpty()) {
            if (question == null || question.isEmpty()) {
                strArr.add("вопрос");
            }
            if (answer == null || answer.isEmpty()) {
                strArr.add("ответ");
            }
            StringBuilder str = new StringBuilder("Ошибка необходимо ввести ");
            for (int i = 0; i < strArr.size(); i++) {
                str.append(strArr.get(i));
                if (i != strArr.size() - 1) {
                    str.append(" и ");
                }
            }
            str.append(".");
            throw new AddQuestionException(str.toString());
        }
        return null;
    }

    /**
     * Метод для проверки переданного количества вопросов.
     * Если количество вопросов меньше либо равно нулю,
     * или переданное число больше имеющегося количества
     * вопросов, то выбрасывается ислючение WrongAmountQuestionRequestException()
     * c текстом ошибки.
     * @param amount - запрашиваемое количество вопросов.
     */
    public Throwable checkAmount(int amount){
        if(amount > listOfJavaQuestions.getAll().size() + listOfMathQuestions.getAll().size()){
            throw new WrongAmountQuestionsRequestException("Слишком большое число вопросов.");
        }else if(amount <= 0){
            throw new WrongAmountQuestionsRequestException("Количество запрашиваемых вопросов должно быть больше нуля.");
        }
        return null;
    }


}
