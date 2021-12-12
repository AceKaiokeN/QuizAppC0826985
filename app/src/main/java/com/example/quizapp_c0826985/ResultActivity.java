package com.example.quizapp_c0826985;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView scoreTV,msgTV;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        scoreTV = findViewById(R.id.scoreTV);
        scoreTV.setText(String.valueOf(QuizActivity.RightansCount));
        msgTV = findViewById(R.id.msgTV);
        imageView = findViewById(R.id.imageView);
        setStuff();

    }
    public void setStuff(){

        if(QuizActivity.RightansCount<3)
        {
            msgTV.setText("Please try again!");
            imageView.setImageResource(R.drawable.tryagain);
        }
        else if(QuizActivity.RightansCount==3)
        {
            msgTV.setText("Good job!");
            imageView.setImageResource(R.drawable.good);
        }
        else if(QuizActivity.RightansCount==4)
        {
            msgTV.setText("Excellent work!");
            imageView.setImageResource(R.drawable.excellent);
        }
        else if(QuizActivity.RightansCount==5)
        {
            msgTV.setText("You are a genius");
            imageView.setImageResource(R.drawable.genius);
        }

    }


}