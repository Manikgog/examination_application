package ru.examination.examination_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.examination.examination_application.model.Question;

import java.util.Set;
import java.util.TreeSet;


@SpringBootApplication
public class ExaminationApplication {
	public static Set<Question> questionsList = new TreeSet<>();
	public static void main(String[] args) {

		questionsList.add(new Question("Первое название языка Java?", "Oak"));
		questionsList.add(new Question("Размер типа int в байтах?", "4 байта"));
		questionsList.add(new Question("Размер типа float в байтах?", "4 байта"));
		questionsList.add(new Question("Размер типа double в байтах?", "8 байта"));
		questionsList.add(new Question("Размер типа char в байтах?", "2 байта"));
		questionsList.add(new Question("Сколько примитивных типов существует в Java?", "8"));
		questionsList.add(new Question("От какого класса наследуются все классы в Java?", "Object"));
		questionsList.add(new Question("В чём разница между char и Character?", "char является примитивным типом, а Character классом"));
		questionsList.add(new Question("Параметры в Java передаются по ссылке или по значению?", "В Java все аргументы передаются по значению"));
		questionsList.add(new Question("Перечислите принципы ООП?", "Инкапсуляция, наследование, , полиморфизм"));
		questionsList.add(new Question("Какие два класса не наследуются от Object?", "Таких классов нет, все классы наследуются от Object"));
		questionsList.add(new Question("В каком году началась разработка языка Java?", "1991"));
		questionsList.add(new Question("Сколько целочисленных примитивных типов существует в Java?", "4"));
		questionsList.add(new Question("Сколько примитивных типов с плавающей точкой существует в Java?", "2"));

		SpringApplication.run(ExaminationApplication.class, args);
	}

}
