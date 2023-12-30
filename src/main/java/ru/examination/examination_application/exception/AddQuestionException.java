package ru.examination.examination_application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AddQuestionException extends RuntimeException {
    public AddQuestionException(){
        super();
    }

    public AddQuestionException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}