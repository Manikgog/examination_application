package ru.examination.examination_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.examination.examination_application.model.Question;
import ru.examination.examination_application.service.ExaminerService;
import ru.examination.examination_application.service.ExaminerServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/exam")
public class ExaminerController {
    private final ExaminerService questionService;
    public ExaminerController(ExaminerServiceImpl service){
        this.questionService = service;
    }

    @GetMapping(path = "/getQuestions")
    public Set<Question> getQuestions(@RequestParam(value = "amount", required = false) Integer amount){
        return questionService.getQuestions(amount);
    }

}
