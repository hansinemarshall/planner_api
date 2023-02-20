package com.forkit.planner_api.models;

import java.time.LocalDate;

public class FlashCard {

    private Long id;
    private String question;
    private String answer;
    private LocalDate date;
    private String topic;
    private boolean isCorrect;

    public FlashCard(Long id, String question, String answer, LocalDate date, String topic, boolean isCorrect) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.date = date;
        this.topic = topic;
        this.isCorrect = false;
    }

    public FlashCard(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
