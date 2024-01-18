package ru.examination.examination_application.repo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.examination.examination_application.exception.AddQuestionException;
import ru.examination.examination_application.exception.WrongQuestionException;
import ru.examination.examination_application.model.Question;

import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

@Repository
public class MathQuestionRepositoryImpl implements QuestionRepository{
    private final Set<Question> questions;

    public MathQuestionRepositoryImpl(){
        questions = new TreeSet<>();
    }

    @PostConstruct
    private void fillQuestions(){
        questions.add(new Question("Назовите единственное чётное простое число?", "Два"));
        questions.add(new Question("Как ещё называют периметр круга?", "Окружность"));
        questions.add(new Question("Что такое Пи, рациональное и иррациональное число?", "Пи - иррациональное число"));
        questions.add(new Question("Сколько секунд в одном дне?", "86400 секунд"));
        questions.add(new Question("Что предшествует квадрилиону?", "Триллион"));
        questions.add(new Question("Значение cos 360 гр.?", "1"));
        questions.add(new Question("Первая координата точки?", "Абсцисса"));
        questions.add(new Question("Вторая координата точки?", "Ордината"));
        questions.add(new Question("Утверждение, требующее доказательства?", "Теорема"));
        questions.add(new Question("Отрезок, соединяющий две точки окружности?", "Хорда"));
        questions.add(new Question("Переведите на древнегреческий язык слова «натянутая тетива»?", "Гипотенуза"));
        questions.add(new Question("График функции у = kx + b?", "Прямая"));
        questions.add(new Question("Сумма углов треугольника?", "180°"));
        questions.add(new Question("Абсолютная величина числа?", "Модуль"));
        questions.add(new Question("Место, занимаемое цифрой в записи числа?", "Разряд"));
        questions.add(new Question("Великий учёный, чьё имя теперь носит прямоугольная система координат?", "Декарт"));
        questions.add(new Question("Утверждение, принимаемое без доказательства?", "Аксиома"));
        questions.add(new Question("Переведите на древнегреческий язык слова «сосновая шишка»?", "Конус"));
        questions.add(new Question("График функции у = х3?", "Кубическая парабола"));
        questions.add(new Question("Равенство, справедливое при всех допустимых значениях переменных?", "Тождество"));
        questions.add(new Question("Кто из ученых установил связь между корнями квадратного уравнения?", "Виет"));
        questions.add(new Question("Кому принадлежат слова: «Я мыслю, следовательно, я существую»?", "Декарту"));
        questions.add(new Question("Какое наименьшее количество раз справил свой день рождения солдат-призывник, если все свои дни рождения он отмечал?", "18 раз"));
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
