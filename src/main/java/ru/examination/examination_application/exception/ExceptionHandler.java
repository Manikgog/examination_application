package ru.examination.examination_application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.examination.examination_application.model.ErrorMessage;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(AddQuestionException.class)
    public ResponseEntity<ErrorMessage> addQuestionException(AddQuestionException exception){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(exception.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(WrongQuestionException.class)
    public ResponseEntity<ErrorMessage> wrongQuestionException(WrongQuestionException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(exception.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(WrongAmountQuestionsRequestException.class)
    public ResponseEntity<ErrorMessage> wrongAmountQuestionsRequestException(WrongAmountQuestionsRequestException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(exception.getMessage()));
    }

}