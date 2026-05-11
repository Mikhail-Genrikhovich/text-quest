package com.javarush.mikhail.text_quest.service;

import com.javarush.mikhail.text_quest.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTest {

    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameService();
    }

    @Test
    @DisplayName("Существует ли стартовый вопрос?")
    void getStartQuestionId_shouldReturnOne() {
        int startId = gameService.getStartQuestionId();

        assertEquals(1, startId);
    }

    @Test
    @DisplayName("Существует вопрос с id?")
    void getQuestion_whenIdIsValid_shouldReturnQuestion() {
        Question question = gameService.getQuestion(1);

        assertNotNull(question);
    }

    @Test
    @DisplayName("Вернет null вопрос с несуществующим id?")
    void getQuestion_whenIdNotExist_shouldReturnNull() {
        Question question = gameService.getQuestion(1000);

        assertNull(question);
    }

    @Test
    @DisplayName("Есть ответы у стартового вопроса?")
    void getQuestion_firstQuestion_shouldHaveAnswers() {
        Question question = gameService.getQuestion(1);

        assertNotNull(question);
        assertFalse(question.getAnswers().isEmpty());
    }

    @Test
    @DisplayName("Победный путь работает?")
    void questPath_winPath_shouldLeadToVictory() {
        Question q1 = gameService.getQuestion(1);
        assertNotNull(q1);

        int nextId = q1.getAnswers().get(2).getNextQuestionId();

        Question q2 = gameService.getQuestion(nextId);
        assertNotNull(q2);

        nextId = q2.getAnswers().get(2).getNextQuestionId();

        Question q3 = gameService.getQuestion(nextId);
        assertNotNull(q3);

        nextId = q3.getAnswers().get(1).getNextQuestionId();

        Question finalQuestion = gameService.getQuestion(nextId);
        assertNotNull(finalQuestion);

        assertTrue(finalQuestion.isGameOver());
        assertTrue(finalQuestion.isWin());

    }

    @Test
    @DisplayName("Поражение работает правильно?")
    void questPath_loseFirstAnswer_shouldLeadToDefeat() {
        Question q1 = gameService.getQuestion(1);

        int nextId = q1.getAnswers().get(0).getNextQuestionId();

        Question finalQuestion = gameService.getQuestion(nextId);
        assertNotNull(finalQuestion);

        assertTrue(finalQuestion.isGameOver());
        assertFalse(finalQuestion.isWin());
    }

}
