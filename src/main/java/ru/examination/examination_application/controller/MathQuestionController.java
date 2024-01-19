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

    /**
     * Метод для добавления вопроса по Java и ответа на него.
     * @param question - вопрос в виде String.
     * @param answer - ответ в виде String.
     * @return объект Question.
     */
    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam(value = "question", required = false) String question,
                              @RequestParam(value = "answer", required = false) String answer){
        return service.add(question, answer);
    }

    /**
     * Метод для получения списка всех вопросов с ответами.
     * @return Set<Question>.
     */
    @GetMapping
    public Set<Question> getQuestions(){
        return service.getAll();
    }

    /**
     * Метод для удаления вопроса и ответа на него.
     * @param question - вопрос в виде String.
     * @param answer - ответ в виде String.
     * @return объект Question.
     */
    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam(value = "question", required = false) String question,
                                 @RequestParam(value = "answer", required = false) String answer){
        return service.remove(question, answer);
    }
}
