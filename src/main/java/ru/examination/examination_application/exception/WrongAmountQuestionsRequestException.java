package ru.examination.examination_application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WrongAmountQuestionsRequestException extends RuntimeException{
    public WrongAmountQuestionsRequestException() {
        super();
    }

    public WrongAmountQuestionsRequestException(String str) {
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
