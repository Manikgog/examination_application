package ru.examination.examination_application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WrongQuestionException extends RuntimeException {
    public WrongQuestionException(){
        super();
    }

    public WrongQuestionException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }

}
