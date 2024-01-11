package ru.examination.examination_application.model;

import java.util.Objects;

public class Question implements Comparable{
    private final String question;
    private final String answer;

    public Question(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public Question(Question q){
        this.question = q.getQuestion();
        this.answer = q.getAnswer();
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(answer, question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

//    @Override
//    public String toString() {
//        return "Question{" +
//                "question='" + question + '\'' +
//                ", answer='" + answer + '\'' +
//                '}';
//    }


    @Override
    public int compareTo(Object o) {
        Question q = (Question) o;
        if(q.hashCode() == this.hashCode()){
            return 0;
        }else if(q.hashCode() < this.hashCode()){
            return -1;
        }
        return 1;
    }
}
