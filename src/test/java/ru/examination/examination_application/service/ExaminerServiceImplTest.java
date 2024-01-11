package ru.examination.examination_application.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.examination.examination_application.exception.WrongAmountQuestionsRequestException;
import ru.examination.examination_application.model.Question;
import ru.examination.examination_application.repo.QuestionRepository;
import ru.examination.examination_application.repo.QuestionRepositoryImpl;


public class ExaminerServiceImplTest {

    private final ExaminerServiceImpl examinerService;
    private final QuestionRepository questionRepository;
    private final CheckService checkService;

    public ExaminerServiceImplTest(){
        questionRepository = new QuestionRepositoryImpl();
        this.checkService = new CheckServiceImpl(questionRepository);
        this.examinerService = new ExaminerServiceImpl(questionRepository, checkService);

        questionRepository.add(new Question("Первое название языка Java?", "Oak"));
        questionRepository.add(new Question("Размер типа int в байтах?", "4 байта"));
        questionRepository.add(new Question("Размер типа float в байтах?", "4 байта"));
        questionRepository.add(new Question("Размер типа double в байтах?", "8 байта"));
        questionRepository.add(new Question("Размер типа char в байтах?", "2 байта"));
        questionRepository.add(new Question("Сколько примитивных типов существует в Java?", "8"));
        questionRepository.add(new Question("От какого класса наследуются все классы в Java?", "Object"));
        questionRepository.add(new Question("В чём разница между char и Character?", "char является примитивным типом, а Character классом"));
        questionRepository.add(new Question("Параметры в Java передаются по ссылке или по значению?", "В Java все аргументы передаются по значению"));
        questionRepository.add(new Question("Перечислите принципы ООП?", "Инкапсуляция, наследование, , полиморфизм"));
        questionRepository.add(new Question("Какие два класса не наследуются от Object?", "Таких классов нет, все классы наследуются от Object"));
        questionRepository.add(new Question("В каком году началась разработка языка Java?", "1991"));
        questionRepository.add(new Question("Сколько целочисленных примитивных типов существует в Java?", "4"));
        questionRepository.add(new Question("Сколько примитивных типов с плавающей точкой существует в Java?", "2"));

    }

    @Test
    public void testGetQuestions() {
        Assertions.assertThrows(WrongAmountQuestionsRequestException.class,
                () -> examinerService.getQuestions(questionRepository.getAll().size() + 1));
        Assertions.assertThrows(WrongAmountQuestionsRequestException.class,
                () -> examinerService.getQuestions(0));
        Assertions.assertThrows(WrongAmountQuestionsRequestException.class,
                () -> examinerService.getQuestions(-1));
        Assertions.assertTrue(
                () -> examinerService.getQuestions(5).size() == 5);
    }

}
