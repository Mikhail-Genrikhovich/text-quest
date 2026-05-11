package com.javarush.mikhail.text_quest.service;

import com.javarush.mikhail.text_quest.model.Answer;
import com.javarush.mikhail.text_quest.model.Question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameService {

    private final Map<Integer, Question> questions = new HashMap<>();


    public GameService(){
        initQuestions();
    }

    private void initQuestions(){
        questions.put(1, new Question(1, "Ты попытался вернуться, но всё вокруг одинаковое." +
                "\nТвои действия: ",
                Arrays.asList(
                        new Answer("Ничего не делать...", 11),
                        new Answer("Взобраться на дерево...", 12),
                        new Answer("Идти прямо не сворачивая...", 2)
                )));

        questions.put(2, new Question(2, "Ты выбрел на опушку и вдали увидел домик." +
                "\nТвои действия:",
                Arrays.asList(
                        new Answer("Ничего не делать...", 11),
                        new Answer("Вернуться в лес...", 22),
                        new Answer("Идти к избушке...", 3)
                )));

        questions.put(3, new Question(3, "На твоем пути река." +
                "\nТвои действия:",
                Arrays.asList(
                        new Answer("Перейти вброд...", 31),
                        new Answer("Идти вверх по течению...", 32),
                        new Answer("Идти вниз по течению...", 4)
                )));

        questions.put(4, new Question(4, "Ты добрался до домика. В нем явно кто-то живет." +
                "\nТвои действия:",
                Arrays.asList(
                        new Answer("Дождаться хозяина...", 41),
                        new Answer("Идти дальше...", 42),
                        new Answer("Идти дальше, прихватив все, что тебе кажется пригодится...", 43)
                )));

        questions.put(11, new Question(11, "Ты решил ничего не делать... Стемнело..." +
                "Из темноты появились волки...",false));

        questions.put(12, new Question(12, "Ты решил взобраться на дерево, но ветка под тобой сломалась..." +
                "Ты упал и разбился...",false));

        questions.put(22, new Question(22, "Ты вернулся в лес и запаниковал..." +
                "В панике ты наткнулся на кабана...",false));

        questions.put(31, new Question(31, "Ты попытался перейти реку вброд..." +
                "Течение оказалось слишком сильным...",false));

        questions.put(32, new Question(32, "Ты идешь вверх по течению и насвистываешь незамысловатую " +
                "мелодию как вдруг видишь человека... Это оказался лесник, который помог тебе выбраться" +
                "обратно к друзьям! Ура! Будь осторожнее!",true));

        questions.put(41, new Question(41, "Ты решил посидеть и дождаться хозяина... " +
                "Спастя какое-то время появился незнакомец. Это оказался лесник, который помог тебе выбраться" +
                "обратно к друзьям! Ура! Будь осторожнее!",true));

        questions.put(42, new Question(42, "Ты пошёл дальше в лес. " +
                "К вечеру ты наткнулся на стаю волков...",false));

        questions.put(43, new Question(43, "Ты взял спички и вяленое мясо." +
                "Но от встречи с волками это не уберегло...",false));

    }

    public Question getQuestion(int id) {
        return questions.get(id);
    }

    public int getStartQuestionId() {
        return 1;
    }
}
