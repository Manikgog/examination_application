package ru.examination.examination_application.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.examination.examination_application.exception.WrongAmountQuestionsRequestException;
import ru.examination.examination_application.model.Question;
import ru.examination.examination_application.repo.MathQuestionRepositoryImpl;
import ru.examination.examination_application.repo.JavaQuestionRepositoryImpl;


public class ExaminerServiceImplTest {

    private final ExaminerServiceImpl examinerService;
    private final JavaQuestionRepositoryImpl javaQuestionRepository;
    private final MathQuestionRepositoryImpl mathQuestionRepository;
    private final CheckService checkService;

    public ExaminerServiceImplTest(){
        javaQuestionRepository = new JavaQuestionRepositoryImpl();
        mathQuestionRepository = new MathQuestionRepositoryImpl();
        this.checkService = new CheckServiceImpl(javaQuestionRepository, mathQuestionRepository);
        this.examinerService = new ExaminerServiceImpl(javaQuestionRepository, mathQuestionRepository, checkService);
    }

    @BeforeEach
    void initRepo(){
        javaQuestionRepository.add(new Question("Первое название языка Java?", "Oak"));
        javaQuestionRepository.add(new Question("Размер типа int в байтах?", "4 байта"));
        javaQuestionRepository.add(new Question("Размер типа float в байтах?", "4 байта"));
        javaQuestionRepository.add(new Question("Размер типа double в байтах?", "8 байта"));
        javaQuestionRepository.add(new Question("Размер типа char в байтах?", "2 байта"));
        javaQuestionRepository.add(new Question("Сколько примитивных типов существует в Java?", "8"));
        javaQuestionRepository.add(new Question("От какого класса наследуются все классы в Java?", "Object"));
        javaQuestionRepository.add(new Question("В чём разница между char и Character?", "char является примитивным типом, а Character классом"));
        javaQuestionRepository.add(new Question("Параметры в Java передаются по ссылке или по значению?", "В Java все аргументы передаются по значению"));
        javaQuestionRepository.add(new Question("Перечислите принципы ООП?", "Инкапсуляция, наследование, , полиморфизм"));
        javaQuestionRepository.add(new Question("Какие два класса не наследуются от Object?", "Таких классов нет, все классы наследуются от Object"));
        javaQuestionRepository.add(new Question("В каком году началась разработка языка Java?", "1991"));
        javaQuestionRepository.add(new Question("Сколько целочисленных примитивных типов существует в Java?", "4"));
        javaQuestionRepository.add(new Question("Сколько примитивных типов с плавающей точкой существует в Java?", "2"));

        mathQuestionRepository.add(new Question("Назовите единственное чётное простое число?", "Два"));
        mathQuestionRepository.add(new Question("Как ещё называют периметр круга?", "Окружность"));
        mathQuestionRepository.add(new Question("Что такое Пи, рациональное и иррациональное число?", "Пи - иррациональное число"));
        mathQuestionRepository.add(new Question("Сколько секунд в одном дне?", "86400 секунд"));
        mathQuestionRepository.add(new Question("Что предшествует квадрилиону?", "Триллион"));
        mathQuestionRepository.add(new Question("Значение cos 360 гр.?", "1"));
        mathQuestionRepository.add(new Question("Первая координата точки?", "Абсцисса"));
        mathQuestionRepository.add(new Question("Вторая координата точки?", "Ордината"));
        mathQuestionRepository.add(new Question("Утверждение, требующее доказательства?", "Теорема"));
        mathQuestionRepository.add(new Question("Отрезок, соединяющий две точки окружности?", "Хорда"));
        mathQuestionRepository.add(new Question("Переведите на древнегреческий язык слова «натянутая тетива»?", "Гипотенуза"));
    }

    /**
     * Тестирование метода getQustions(int amount) класса ExaminerServiceImpl
     */
    @Test
    public void testGetQuestions() {
        Assertions.assertThrows(WrongAmountQuestionsRequestException.class,
                () -> examinerService.getQuestions(javaQuestionRepository.getAll().size() + 1 + mathQuestionRepository.getAll().size()));
        Assertions.assertThrows(WrongAmountQuestionsRequestException.class,
                () -> examinerService.getQuestions(0));
        Assertions.assertThrows(WrongAmountQuestionsRequestException.class,
                () -> examinerService.getQuestions(-1));
        int amount = examinerService.getQuestions(5).size();
        Assertions.assertEquals(5,  amount);
    }

}
