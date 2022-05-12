package com.example.myapplicationv4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Mat extends AppCompatActivity {

    Button btn_start, btn_answer0, btn_answer1, btn_answer2, btn_answer3;
    TextView tv_score, tv_question, tv_timer, tv_mes;
    ProgressBar prog_timer;

    GameMat gameMat = new GameMat();
    int secondsRemaining = 30;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mat);

        btn_start = findViewById(R.id.btn_start);
        btn_answer0= findViewById(R.id.btn_ans0);
        btn_answer1=findViewById(R.id.btn_ans1);
        btn_answer2= findViewById(R.id.btn_ans2);
        btn_answer3=findViewById(R.id.btn_ans3);

        tv_score = findViewById(R.id.tv_score);
        tv_mes=findViewById(R.id.tv_mes);
        tv_question=findViewById(R.id.tv_question);
        tv_timer=findViewById(R.id.tv_time);

        prog_timer=findViewById(R.id.prog_timer);

        tv_timer.setText("0sec");
        tv_question.setText("");
        tv_mes.setText("Nacisnij START");
        tv_score.setText("0pkt");
        prog_timer.setProgress(0);

        View.OnClickListener startButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button start_button = (Button) v;

                start_button.setVisibility(View.INVISIBLE);
                secondsRemaining=30;
                gameMat = new GameMat();
                nextTurn();
                timer.start();
                tv_score.setText(Integer.toString(gameMat.getScore())+"pkt");
            }
        };
        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked = (Button)v;

                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());

                gameMat.checkAnswer(answerSelected);
                tv_score.setText(Integer.toString(gameMat.getScore())+"pkt");
                nextTurn();
            }
        };
        btn_start.setOnClickListener(startButtonClickListener);

        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);

    }

    CountDownTimer timer = new CountDownTimer(30000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            secondsRemaining--;
            tv_timer.setText(Integer.toString(secondsRemaining)+ "sec");
            prog_timer.setProgress(30 - secondsRemaining);
        }

        @Override
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);
            tv_mes.setText("Czas sie skonczyl" + gameMat.getNumberCorrect()+ "/" + (gameMat.getTotalQuestions()-1));

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_start.setVisibility(View.VISIBLE);
                }
            },4000);
        }
    };

    @SuppressLint("SetTextI18n")
    private void nextTurn(){
        gameMat.makeNewQuestion();
        int [] answer = gameMat.getCurrentQuestion().getAnswerArray();

        btn_answer0.setText(Integer.toString(answer[0]));
        btn_answer1.setText(Integer.toString(answer[1]));
        btn_answer2.setText(Integer.toString(answer[2]));
        btn_answer3.setText(Integer.toString(answer[3]));

        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);

        tv_question.setText(gameMat.getCurrentQuestion().getQustionPhrase());
        tv_mes.setText(gameMat.getNumberCorrect()+ " / " + (gameMat.getTotalQuestions()-1));
    }
}
