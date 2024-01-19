package ru.examination.examination_application.service;

public interface CheckService {
    Throwable check(String question, String answer);
    Throwable checkAmount(int amount);
}