package ru.examination.examination_application.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.examination.examination_application.exception.AddQuestionException;
import ru.examination.examination_application.model.Question;
import ru.examination.examination_application.repo.QuestionRepositoryImpl;

import java.util.stream.Stream;

public class JavaQuestionServiceTest {
    private final JavaQuestionService questionService;
    public JavaQuestionServiceTest(){
        QuestionRepositoryImpl listOfQuestions = new QuestionRepositoryImpl();
        CheckService checkService = new CheckServiceImpl(listOfQuestions, null);
        this.questionService = new JavaQuestionService(listOfQuestions, checkService);
        listOfQuestions.add(new Question("Размер типа double в байтах?", "8 байта"));
        listOfQuestions.add(new Question("Размер типа char в байтах?", "2 байта"));
        listOfQuestions.add(new Question("Сколько примитивных типов существует в Java?", "8"));
        listOfQuestions.add(new Question("От какого класса наследуются все классы в Java?", "Object"));
        listOfQuestions.add(new Question("В чём разница между char и Character?", "char является примитивным типом, а Character классом"));
        listOfQuestions.add(new Question("Параметры в Java передаются по ссылке или по значению?", "В Java все аргументы передаются по значению"));
        listOfQuestions.add(new Question("Перечислите принципы ООП?", "Инкапсуляция, наследование, , полиморфизм"));

    }

    public static Stream<Arguments> provideParamsForPositiveAddMethodTests(){
        return Stream.of(
                Arguments.of("Первое название языка Java?", "Oak",
                        new Question("Первое название языка Java?", "Oak")),
                Arguments.of("Размер типа int в байтах?", "4 байта",
                        new Question("Размер типа int в байтах?", "4 байта"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForPositiveAddMethodTests")
    public void testAdd(String question, String answer, Question expectedResult){
        // размер списка вопросов до добавления нового вопроса
        int sizeOfQuestionsBeforeAdding = questionService.getAll().size();
        Question actualResult = questionService.add(question, answer);
        Assertions.assertEquals(expectedResult, actualResult);
        // проверка увеличения списка вопросов после добавления вопроса
        Assertions.assertEquals(sizeOfQuestionsBeforeAdding + 1, questionService.getAll().size());
        // проверка наличия добавленного вопроса в списке
        Assertions.assertTrue(questionService.getAll().contains(actualResult));
    }

    public static Stream<Arguments> provideParamsForNegativeAddMethodTests(){
        return Stream.of(
                Arguments.of(null, "4 байта"),
                Arguments.of("Размер типа float в байтах?", null),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForNegativeAddMethodTests")
    public void testAdd(String question, String answer){
        if(question == null && answer == null){
            Assertions.assertThrows(AddQuestionException.class, () -> questionService.add(null, null));
        }else if(question == null) {
            Assertions.assertThrows(AddQuestionException.class, () -> questionService.add(null, answer));
        }else if(answer == null){
            Assertions.assertThrows(AddQuestionException.class, () -> questionService.add(question, null));
        }
    }

    public static Stream<Arguments> provideParamsForPositiveRemoveMethodTests(){
        return Stream.of(
                Arguments.of("Размер типа double в байтах?", "8 байта",
                        new Question("Размер типа double в байтах?", "8 байта")),
                Arguments.of("Размер типа char в байтах?", "2 байта",
                        new Question("Размер типа char в байтах?", "2 байта"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForPositiveRemoveMethodTests")
    public void testRemove(String question, String answer, Question expectedResult){
        int sizeOfQuestionsBeforeAdding = questionService.getAll().size(); // размер списка вопросов до добавления нового вопроса
        Question actualResult = questionService.remove(question, answer);
        Assertions.assertEquals(expectedResult, actualResult);
        // проверка уменьшения размера хранилища вопросов после удаления
        Assertions.assertEquals(sizeOfQuestionsBeforeAdding - 1, questionService.getAll().size());
        // проверка отсутствия удалённого вопроса в хранилище
        Assertions.assertFalse(questionService.getAll().contains(actualResult));
    }

    public static Stream<Arguments> provideParamsForNegativeRemoveMethodTests(){
        return Stream.of(
                Arguments.of(null, "4 байта"),
                Arguments.of("Размер типа float в байтах?", null),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForNegativeRemoveMethodTests")
    public void testRemove(String question, String answer){
        if(question == null && answer == null){
            Assertions.assertThrows(AddQuestionException.class, () -> questionService.remove(null, null));
        }else if(question == null) {
            Assertions.assertThrows(AddQuestionException.class, () -> questionService.remove(null, answer));
        }else if(answer == null){
            Assertions.assertThrows(AddQuestionException.class, () -> questionService.remove(question, null));
        }
    }

}
