package com.example.game;
public class QuestionBank {
    private String textQuestions [] = {
            "1. What the color of apple ?",
            "2. Who is the first president of USA ?",
            "3. What animal that can fly ?",
            "4. 10 + 945 = ?",
            "5. What year now ?"
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"red", "green", "black", "orange"},
            {"Obama", "Vladimir Putin", "George Washington", "Donald Trump"},
            {"Fish", "Cat", "Bird", "Snake"},
            {"970", "289", "955", "980"},
            {"1999", "2000", "2010", "2020"}
    };

    private String mCorrectAnswers[] = {"red", "George Washington", "Bird",
            "955", "2020"};

    public int getLength(){
        return textQuestions.length;
    }

    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}

