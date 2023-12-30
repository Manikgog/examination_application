package ru.examination.examination_application.service;

public interface CheckService {
    void check(String question, String answer);
    void checkAmount(int amount);
}