package ru.examination.examination_application.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.examination.examination_application.exception.AddQuestionException;
import ru.examination.examination_application.model.Question;
import ru.examination.examination_application.repo.MathQuestionRepositoryImpl;
import ru.examination.examination_application.repo.QuestionRepositoryImpl;

import java.util.stream.Stream;

import static ru.examination.examination_application.constants.Constants.*;

public class MathQuestionServiceTest {
    private final MathQuestionService questionService;
    
    public MathQuestionServiceTest(){
        QuestionRepositoryImpl javaQuestionRepository = new QuestionRepositoryImpl();
        MathQuestionRepositoryImpl mathQuestionRepository = new MathQuestionRepositoryImpl();
        CheckService checkService = new CheckServiceImpl(javaQuestionRepository, mathQuestionRepository);
        questionService = new MathQuestionService(mathQuestionRepository, checkService);

        questionService.add(MATH_QUESTION_1.getQuestion(), MATH_QUESTION_1.getAnswer());
        questionService.add(MATH_QUESTION_2.getQuestion(), MATH_QUESTION_2.getAnswer());
        questionService.add(MATH_QUESTION_3.getQuestion(), MATH_QUESTION_3.getAnswer());
        questionService.add(MATH_QUESTION_4.getQuestion(), MATH_QUESTION_4.getAnswer());
        questionService.add(MATH_QUESTION_5.getQuestion(), MATH_QUESTION_5.getAnswer());
        questionService.add(MATH_QUESTION_6.getQuestion(), MATH_QUESTION_6.getAnswer());
        questionService.add(MATH_QUESTION_7.getQuestion(), MATH_QUESTION_7.getAnswer());
        questionService.add(MATH_QUESTION_8.getQuestion(), MATH_QUESTION_8.getAnswer());
        questionService.add(MATH_QUESTION_9.getQuestion(), MATH_QUESTION_9.getAnswer());
        questionService.add(MATH_QUESTION_10.getQuestion(), MATH_QUESTION_10.getAnswer());
        questionService.add(MATH_QUESTION_11.getQuestion(), MATH_QUESTION_11.getAnswer());
        questionService.add(MATH_QUESTION_12.getQuestion(), MATH_QUESTION_12.getAnswer());
        questionService.add(MATH_QUESTION_13.getQuestion(), MATH_QUESTION_13.getAnswer());
        questionService.add(MATH_QUESTION_14.getQuestion(), MATH_QUESTION_14.getAnswer());
        questionService.add(MATH_QUESTION_15.getQuestion(), MATH_QUESTION_15.getAnswer());
        questionService.add(MATH_QUESTION_16.getQuestion(), MATH_QUESTION_16.getAnswer());
        questionService.add(MATH_QUESTION_17.getQuestion(), MATH_QUESTION_17.getAnswer());
        questionService.add(MATH_QUESTION_18.getQuestion(), MATH_QUESTION_18.getAnswer());
        questionService.add(MATH_QUESTION_19.getQuestion(), MATH_QUESTION_19.getAnswer());
        questionService.add(MATH_QUESTION_20.getQuestion(), MATH_QUESTION_20.getAnswer());
        questionService.add(MATH_QUESTION_21.getQuestion(), MATH_QUESTION_21.getAnswer());

    }

    public static Stream<Arguments> provideParamsForPositiveAddMethodTests(){
        return Stream.of(
                Arguments.of(MATH_QUESTION_22.getQuestion(), MATH_QUESTION_22.getAnswer(),
                        new Question(MATH_QUESTION_22.getQuestion(), MATH_QUESTION_22.getAnswer())),
                Arguments.of(MATH_QUESTION_23.getQuestion(), MATH_QUESTION_23.getAnswer(),
                        new Question(MATH_QUESTION_23.getQuestion(), MATH_QUESTION_23.getAnswer()))
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
                Arguments.of(MATH_QUESTION_1.getQuestion(), MATH_QUESTION_1.getAnswer(),
                        new Question(MATH_QUESTION_1.getQuestion(), MATH_QUESTION_1.getAnswer())),
                Arguments.of(MATH_QUESTION_2.getQuestion(), MATH_QUESTION_2.getAnswer(),
                        new Question(MATH_QUESTION_2.getQuestion(), MATH_QUESTION_2.getAnswer()))
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
