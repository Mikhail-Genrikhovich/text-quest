package com.javarush.mikhail.text_quest.model;

public class Answer {

    private String text;
    private int nextQuestionId;

    public Answer(String text, int nextQuestionId) {
        this.text = text;
        this.nextQuestionId = nextQuestionId;
    }

    public String getText() {
        return text;
    }

    public int getNextQuestionId() {
        return nextQuestionId;
    }
}
