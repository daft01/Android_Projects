package com.example.danielmorales.quiz;

/**
 * Created by danielmorales on 1/20/18.
 */

public class TrueFalse {

    private int mQuestionID;
    private boolean mAnswer;

    TrueFalse(int question, boolean guess){
        setmAnswer(guess);
        setmQuestionID(question);
    }

    public int getmQuestionID() {
        return mQuestionID;
    }

    public void setmQuestionID(int mQuestionID) {
        this.mQuestionID = mQuestionID;
    }

    public boolean getmAnswer() {
        return mAnswer;
    }

    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}
