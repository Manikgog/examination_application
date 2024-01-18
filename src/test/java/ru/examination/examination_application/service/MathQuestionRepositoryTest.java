package ru.examination.examination_application.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.examination.examination_application.exception.AddQuestionException;
import ru.examination.examination_application.exception.WrongQuestionException;
import ru.examination.examination_application.model.Question;
import ru.examination.examination_application.repo.MathQuestionRepositoryImpl;

import java.util.stream.Stream;

import static ru.examination.examination_application.constants.Constants.*;
import static ru.examination.examination_application.constants.Constants.MATH_QUESTION_21;

public class MathQuestionRepositoryTest {
    private final MathQuestionRepositoryImpl questionRepository;
    public MathQuestionRepositoryTest(){
        this.questionRepository = new MathQuestionRepositoryImpl();

        questionRepository.add(MATH_QUESTION_1);
        questionRepository.add(MATH_QUESTION_2);
        questionRepository.add(MATH_QUESTION_3);
        questionRepository.add(MATH_QUESTION_4);
        questionRepository.add(MATH_QUESTION_5);
        questionRepository.add(MATH_QUESTION_6);
        questionRepository.add(MATH_QUESTION_7);
        questionRepository.add(MATH_QUESTION_8);
        questionRepository.add(MATH_QUESTION_9);
        questionRepository.add(MATH_QUESTION_10);
        questionRepository.add(MATH_QUESTION_11);
        questionRepository.add(MATH_QUESTION_12);
        questionRepository.add(MATH_QUESTION_13);
        questionRepository.add(MATH_QUESTION_14);
        questionRepository.add(MATH_QUESTION_15);
        questionRepository.add(MATH_QUESTION_16);
        questionRepository.add(MATH_QUESTION_17);
        questionRepository.add(MATH_QUESTION_18);
        questionRepository.add(MATH_QUESTION_19);
        questionRepository.add(MATH_QUESTION_20);
        questionRepository.add(MATH_QUESTION_21);
    }

    public static Stream<Arguments> provideParamsForPositive_AddMethod_Test(){
        return Stream.of(
                Arguments.of(MATH_QUESTION_22, MATH_QUESTION_22),
                Arguments.of(MATH_QUESTION_23, MATH_QUESTION_23)
        );
    }

    /**
     * Для тестирования метода add класса MathQuestionRepositoryImpl
     * при передаче в него объекта Question для добавления и объекта
     * Question для проверки возвращения ожидаемого результата.
     * @param question, question
     */
    @ParameterizedTest
    @MethodSource("provideParamsForPositive_AddMethod_Test")
    public void addTest(Question question, Question expectedResult){
        // размер списка вопросов до добавления нового вопроса
        int sizeOfQuestionsBeforeAdding = questionRepository.getAll().size();
        Question actualResult = questionRepository.add(question);
        Assertions.assertEquals(expectedResult, actualResult);
        // проверка увеличения списка вопросов после добавления вопроса
        Assertions.assertEquals(sizeOfQuestionsBeforeAdding + 1, questionRepository.getAll().size());
        // проверка наличия добавленного вопроса в списке
        Assertions.assertTrue(questionRepository.getAll().contains(actualResult));
    }

    public static Stream<Arguments> provideParamsForNegative_AddMethod_Test(){
        return Stream.of(
                Arguments.of(MATH_QUESTION_1),
                Arguments.of(MATH_QUESTION_3)
        );
    }

    /**
     * Для тестирования метода add класса MathQuestionRepositoryImpl
     * при передаче в него уже имеющегося объекта Question в поле
     * Set<Question> questions этого класса.
     * @param question - вопрос для проверки метода.
     */
    @ParameterizedTest
    @MethodSource("provideParamsForNegative_AddMethod_Test")
    public void addExistingQuestionTest(Question question){
        Assertions.assertThrows(AddQuestionException.class, ()->questionRepository.add(question));
    }

    public static Stream<Arguments> provideParamsForPositive_RemoveMethod_Test(){
        return Stream.of(
                Arguments.of(MATH_QUESTION_2, MATH_QUESTION_2),
                Arguments.of(MATH_QUESTION_5, MATH_QUESTION_5)
        );
    }

    /**
     * Тестирование удаления существующих в списке вопросов.
     * @param question - вопрос для проверки метода.
     * @param expectedResult - ожидаемый результат.
     */
    @ParameterizedTest
    @MethodSource("provideParamsForPositive_RemoveMethod_Test")
    public void removeTest(Question question, Question expectedResult){
        int sizeBeforeRemovingQuestion = questionRepository.getAll().size();
        Question actualResult = questionRepository.remove(question);
        Assertions.assertEquals(expectedResult, actualResult);
        int sizeAfterRemovingQuestion = questionRepository.getAll().size();
        Assertions.assertEquals(sizeBeforeRemovingQuestion - 1, sizeAfterRemovingQuestion);
    }

    public static Stream<Arguments> provideParamsForNegative_RemoveMethod_Test(){
        return Stream.of(
                Arguments.of(MATH_QUESTION_22),
                Arguments.of(MATH_QUESTION_23)
        );
    }

    /**
     * Тестирование удаления несуществующего в списке вопроса.
     * @param question
     */
    @ParameterizedTest
    @MethodSource("provideParamsForNegative_RemoveMethod_Test")
    public void removeNotExistingQuestionTest(Question question){
        Assertions.assertThrows(WrongQuestionException.class, ()->questionRepository.remove(question));
    }

    /**
     * Тестирования возвращения полного списка вопросов.
     */
    @Test
    public void getAll_Test(){
        Assertions.assertEquals(MATH_QUESTIONS, questionRepository.getAll());
    }

    /**
     * Тестирования выдачи случайного вопроса из списка.
     */
    @Test
    public void getRandom_Test(){
        Question actualResult = questionRepository.getRandom();
        Assertions.assertTrue(questionRepository.getAll().contains(actualResult));
        actualResult = questionRepository.getRandom();
        Assertions.assertTrue(questionRepository.getAll().contains(actualResult));
        actualResult = questionRepository.getRandom();
        Assertions.assertTrue(questionRepository.getAll().contains(actualResult));
        actualResult = questionRepository.getRandom();
        Assertions.assertTrue(questionRepository.getAll().contains(actualResult));
    }

}
