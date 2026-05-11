package com.javarush.mikhail.text_quest.model;

import java.util.List;

public class Question {

    private int id;
    private String text;

    private List<Answer> answers;

    private boolean isWin;
    private boolean isGameOver;

    public Question(int id, String text, List<Answer> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers;
        isWin = false;
        isGameOver = false;
    }

    public Question(int id, String text, boolean isWin) {
        this.id = id;
        this.text = text;
        answers = List.of();
        this.isWin = isWin;
        isGameOver = true;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public boolean isWin() {
        return isWin;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
