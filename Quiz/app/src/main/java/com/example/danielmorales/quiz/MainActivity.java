package com.example.danielmorales.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import java.lang.Math;


public class MainActivity extends AppCompatActivity {

        Button mTrueButton;
        Button mFalseButon;
        TextView mQuestionTextView;
        int mIndex;
        int mScore;
        TextView mProgress;
        ProgressBar mProgressBar;

        private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    final int  PROCRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            mScore = savedInstanceState.getInt("ScoreKey");
            mIndex = savedInstanceState.getInt("IndexKey");
        } else {
            mScore = 0;
            mIndex = 0;
        }

        mTrueButton = (Button) findViewById(R.id.trueButton);
        mFalseButon = (Button) findViewById(R.id.falseButton);
        mQuestionTextView = (TextView) findViewById(R.id.question);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mProgress = (TextView) findViewById(R.id.progress);


        mProgress.setText(mScore + "/" + mQuestionBank.length);
        mQuestionTextView.setText(mQuestionBank[mIndex].getmQuestionID());

        mTrueButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnwer(true);
                updateQuestion();
            }
        });

        mFalseButon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnwer(false);
                updateQuestion();
            }
        });
    }

    public void updateQuestion(){
        mIndex = (mIndex + 1) % mQuestionBank.length;
        mQuestionTextView.setText(mQuestionBank[mIndex].getmQuestionID());
        mProgress.setText(mIndex + "/" + mQuestionBank.length);
    }

    public void checkAnwer(boolean userSelection){

        if(userSelection == mQuestionBank[mIndex].getmAnswer()) {
            mProgressBar.incrementProgressBy(PROCRESS_BAR_INCREMENT);
            mScore++;
        }
    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("ScoreKey", mScore);
        outState.putInt("IndexKey", mIndex);
    }
}
