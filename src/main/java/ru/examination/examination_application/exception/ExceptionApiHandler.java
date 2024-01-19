package ru.examination.examination_application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.examination.examination_application.model.ErrorMessage;

@ControllerAdvice
public class ExceptionApiHandler {

    @ExceptionHandler(AddQuestionException.class)
    public ResponseEntity<ErrorMessage> addQuestionException(AddQuestionException exception){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(exception.getMessage()));
    }

    @ExceptionHandler(WrongQuestionException.class)
    public ResponseEntity<ErrorMessage> wrongQuestionException(WrongQuestionException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(exception.getMessage()));
    }

    @ExceptionHandler(WrongAmountQuestionsRequestException.class)
    public ResponseEntity<ErrorMessage> wrongAmountQuestionsRequestException(WrongAmountQuestionsRequestException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(exception.getMessage()));
    }

}