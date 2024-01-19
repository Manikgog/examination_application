package ru.examination.examination_application.repo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.examination.examination_application.ExaminationApplication;
import ru.examination.examination_application.exception.AddQuestionException;
import ru.examination.examination_application.exception.WrongQuestionException;
import ru.examination.examination_application.model.Question;

import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Repository
public class JavaQuestionRepositoryImpl implements QuestionRepository {
    private final Set<Question> questions;

    public JavaQuestionRepositoryImpl(){
        questions = new TreeSet<>(ExaminationApplication.questionsList);
    }

    @PostConstruct
    private void fillQuestions(){
        questions.add(new Question("Первое название языка Java?", "Oak"));
        questions.add(new Question("Размер типа int в байтах?", "4 байта"));
        questions.add(new Question("Размер типа float в байтах?", "4 байта"));
        questions.add(new Question("Размер типа double в байтах?", "8 байта"));
        questions.add(new Question("Размер типа char в байтах?", "2 байта"));
        questions.add(new Question("Сколько примитивных типов существует в Java?", "8"));
        questions.add(new Question("От какого класса наследуются все классы в Java?", "Object"));
        questions.add(new Question("В чём разница между char и Character?", "char является примитивным типом, а Character классом"));
        questions.add(new Question("Параметры в Java передаются по ссылке или по значению?", "В Java все аргументы передаются по значению"));
        questions.add(new Question("Перечислите принципы ООП?", "Инкапсуляция, наследование, , полиморфизм"));
        questions.add(new Question("Какие два класса не наследуются от Object?", "Таких классов нет, все классы наследуются от Object"));
        questions.add(new Question("В каком году началась разработка языка Java?", "1991"));
        questions.add(new Question("Сколько целочисленных примитивных типов существует в Java?", "4"));
        questions.add(new Question("Сколько примитивных типов с плавающей точкой существует в Java?", "2"));
    }
    public Question add(Question question){
        if(!questions.add(question)){
            throw new AddQuestionException("Такой вопрос уже есть");
        }
        return question;
    }

    public Question remove(Question question){
        if(!questions.remove(question)) {
            throw new WrongQuestionException("Такой вопрос отсутствует в списке");
        }
        return question;
    }

    public Set<Question> getAll(){
        return Collections.unmodifiableSet(questions);
    }

    public Question getRandom(){
        Random rnd = new Random();
        return questions
                .stream()
                .toList()
                .get(Math.abs(rnd.nextInt() % questions.size()));
    }


}
