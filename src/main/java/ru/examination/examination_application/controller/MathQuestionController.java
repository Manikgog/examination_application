package ru.examination.examination_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.examination.examination_application.model.Question;
import ru.examination.examination_application.service.MathQuestionService;
import ru.examination.examination_application.service.QuestionService;

import java.util.Set;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final QuestionService service;
    public MathQuestionController(MathQuestionService service){
        this.service = service;
    }

    @GetMapping(path = "/add")
    public Object addQuestion(@RequestParam(value = "question", required = false) String question,
                              @RequestParam(value = "answer", required = false) String answer){
        return service.add(question, answer);
    }

    @GetMapping
    public Set<Question> getQuestions(){
        return service.getAll();
    }

    @GetMapping(path = "/remove")
    public Object removeQuestion(@RequestParam(value = "question", required = false) String question,
                                 @RequestParam(value = "answer", required = false) String answer){
        return service.remove(question, answer);
    }
}
