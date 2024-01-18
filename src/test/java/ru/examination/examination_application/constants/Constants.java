package ru.examination.examination_application.constants;

import ru.examination.examination_application.model.Question;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Constants {
    public static final Question QUESTION_1 = new Question("Размер типа double в байтах?", "8 байта");
    public static final Question QUESTION_2 = new Question("Размер типа char в байтах?", "2 байта");
    public static final Question QUESTION_3 = new Question("Сколько примитивных типов существует в Java?", "8");
    public static final Question QUESTION_4 = new Question("От какого класса наследуются все классы в Java?", "Object");
    public static final Question QUESTION_5 = new Question("В чём разница между char и Character?", "char является примитивным типом, а Character классом");
    public static final Question QUESTION_6 = new Question("Параметры в Java передаются по ссылке или по значению?", "В Java все аргументы передаются по значению");
    public static final Question QUESTION_7 = new Question("Перечислите принципы ООП?", "Инкапсуляция, наследование, , полиморфизм");

    public static final Set<Question> QUESTIONS = new TreeSet<>(Arrays.asList(
            QUESTION_1,
            QUESTION_2,
            QUESTION_3,
            QUESTION_4,
            QUESTION_5,
            QUESTION_6,
            QUESTION_7
    ) );

    public static final Question MATH_QUESTION_1 = new Question("Назовите единственное чётное простое число?", "Два");
    public static final Question MATH_QUESTION_2 = new Question("Как ещё называют периметр круга?", "Окружность");
    public static final Question MATH_QUESTION_3 = new Question("Что такое Пи, рациональное и иррациональное число?", "Пи - иррациональное число");
    public static final Question MATH_QUESTION_4 = new Question("Сколько секунд в одном дне?", "86400 секунд");
    public static final Question MATH_QUESTION_5 = new Question("Что предшествует квадрилиону?", "Триллион");
    public static final Question MATH_QUESTION_6 = new Question("Значение cos 360 гр.?", "1");
    public static final Question MATH_QUESTION_7 = new Question("Первая координата точки?", "Абсцисса");
    public static final Question MATH_QUESTION_8 = new Question("Вторая координата точки?", "Ордината");
    public static final Question MATH_QUESTION_9 = new Question("Утверждение, требующее доказательства?", "Теорема");
    public static final Question MATH_QUESTION_10 = new Question("Отрезок, соединяющий две точки окружности?", "Хорда");
    public static final Question MATH_QUESTION_11 = new Question("Переведите на древнегреческий язык слова «натянутая тетива»?", "Гипотенуза");
    public static final Question MATH_QUESTION_12 = new Question("График функции у = kx + b?", "Прямая");
    public static final Question MATH_QUESTION_13 = new Question("Сумма углов треугольника?", "180°");
    public static final Question MATH_QUESTION_14 = new Question("Абсолютная величина числа?", "Модуль");
    public static final Question MATH_QUESTION_15 = new Question("Место, занимаемое цифрой в записи числа?", "Разряд");
    public static final Question MATH_QUESTION_16 = new Question("Великий учёный, чьё имя теперь носит прямоугольная система координат?", "Декарт");
    public static final Question MATH_QUESTION_17 = new Question("Утверждение, принимаемое без доказательства?", "Аксиома");
    public static final Question MATH_QUESTION_18 = new Question("Переведите на древнегреческий язык слова «сосновая шишка»?", "Конус");
    public static final Question MATH_QUESTION_19 = new Question("График функции у = х3?", "Кубическая парабола");
    public static final Question MATH_QUESTION_20 = new Question("Равенство, справедливое при всех допустимых значениях переменных?", "Тождество");
    public static final Question MATH_QUESTION_21 = new Question("Кто из ученых установил связь между корнями квадратного уравнения?", "Виет");
    public static final Question MATH_QUESTION_22 = new Question("Кому принадлежат слова: «Я мыслю, следовательно, я существую»?", "Декарту");
    public static final Question MATH_QUESTION_23 = new Question("Какое наименьшее количество раз справил свой день рождения солдат-призывник, если все свои дни рождения он отмечал?", "18 раз");

    public static final Set<Question> MATH_QUESTIONS = new TreeSet<>(Arrays.asList(
            MATH_QUESTION_1,
            MATH_QUESTION_2,
            MATH_QUESTION_3,
            MATH_QUESTION_4,
            MATH_QUESTION_5,
            MATH_QUESTION_6,
            MATH_QUESTION_7,
            MATH_QUESTION_8,
            MATH_QUESTION_9,
            MATH_QUESTION_10,
            MATH_QUESTION_11,
            MATH_QUESTION_12,
            MATH_QUESTION_13,
            MATH_QUESTION_14,
            MATH_QUESTION_15,
            MATH_QUESTION_16,
            MATH_QUESTION_17,
            MATH_QUESTION_18,
            MATH_QUESTION_19,
            MATH_QUESTION_20,
            MATH_QUESTION_21
    ) );


}
