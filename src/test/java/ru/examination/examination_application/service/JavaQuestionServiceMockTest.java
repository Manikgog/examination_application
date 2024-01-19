package ru.examination.examination_application.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.examination.examination_application.exception.AddQuestionException;
import ru.examination.examination_application.model.Question;
import ru.examination.examination_application.repo.JavaQuestionRepositoryImpl;
import java.util.Set;
import static org.mockito.Mockito.when;
import static ru.examination.examination_application.constants.Constants.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceMockTest {
    @Mock
    JavaQuestionRepositoryImpl listOfQuestions;
    @Mock
    CheckService checkService;
    @InjectMocks
    JavaQuestionService questionService;

    /**
     * Тестирование метода add(String question, String answer) класса JavaQuestionServiceImpl
     */
    @Test
    public void addTest(){
        when(listOfQuestions.add(QUESTION_1)).thenReturn(QUESTION_1);

        Question actualResult = questionService.add(QUESTION_1.getQuestion(), QUESTION_1.getAnswer());
        Assertions.assertEquals(QUESTION_1, actualResult);

        when(listOfQuestions.add(QUESTION_2)).thenReturn(QUESTION_2);
        actualResult = questionService.add(QUESTION_2.getQuestion(), QUESTION_2.getAnswer());
        Assertions.assertEquals(QUESTION_2, actualResult);

        when(checkService.check(null, null)).thenThrow(new AddQuestionException());
        Assertions.assertThrows(AddQuestionException.class, ()->questionService.add(null, null));

        when(checkService.check("question", null)).thenThrow(AddQuestionException.class);
        Assertions.assertThrows(AddQuestionException.class, ()->questionService.add("question", null));

        when(checkService.check(null, "answer")).thenThrow(AddQuestionException.class);
        Assertions.assertThrows(AddQuestionException.class, ()->questionService.add( null, "answer"));

        when(checkService.check("", "")).thenThrow(new AddQuestionException());
        Assertions.assertThrows(AddQuestionException.class, ()->questionService.add("", ""));

        when(checkService.check("question", "")).thenThrow(new AddQuestionException());
        Assertions.assertThrows(AddQuestionException.class, ()->questionService.add("question", ""));

        when(checkService.check("", "answer")).thenThrow(new AddQuestionException());
        Assertions.assertThrows(AddQuestionException.class, ()->questionService.add("", "answer"));

    }

    /**
     * Тестирование метода remove(String question, String answer) класса JavaQuestionService
     */
    @Test void removeTest(){
        when(listOfQuestions.remove(QUESTION_3)).thenReturn(QUESTION_3);

        Question actualResult = questionService.remove(QUESTION_3.getQuestion(), QUESTION_3.getAnswer());
        Assertions.assertEquals(QUESTION_3, actualResult);

        when(listOfQuestions.remove(QUESTION_4)).thenReturn(QUESTION_4);

        actualResult = questionService.remove(QUESTION_4.getQuestion(), QUESTION_4.getAnswer());
        Assertions.assertEquals(QUESTION_4, actualResult);

        when(checkService.check(null, null)).thenThrow(AddQuestionException.class);
        Assertions.assertThrows(AddQuestionException.class, ()->questionService.remove(null, null));

        when(checkService.check("question", null)).thenThrow(AddQuestionException.class);
        Assertions.assertThrows(AddQuestionException.class, ()->questionService.remove("question", null));

        when(checkService.check(null, "answer")).thenThrow(AddQuestionException.class);
        Assertions.assertThrows(AddQuestionException.class, ()->questionService.remove( null, "answer"));

        when(checkService.check("", "")).thenThrow(new AddQuestionException());
        Assertions.assertThrows(AddQuestionException.class, ()->questionService.add("", ""));

        when(checkService.check("question", "")).thenThrow(new AddQuestionException());
        Assertions.assertThrows(AddQuestionException.class, ()->questionService.add("question", ""));

        when(checkService.check("", "answer")).thenThrow(new AddQuestionException());
        Assertions.assertThrows(AddQuestionException.class, ()->questionService.add("", "answer"));
    }

    /**
     * Тестирование метода getAll() класса JavaQuestionService
     */
    @Test
    void getAllTest(){
        when(listOfQuestions.getAll()).thenReturn(QUESTIONS);

        Set<Question> actualResult = questionService.getAll();
        Assertions.assertEquals(QUESTIONS, actualResult);
    }


}
