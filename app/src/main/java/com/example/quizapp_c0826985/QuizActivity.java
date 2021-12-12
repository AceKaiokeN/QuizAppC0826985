package com.example.quizapp_c0826985;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.transform.Result;

public class QuizActivity extends AppCompatActivity {
    ArrayList<Questions> selectedques = new ArrayList<>();
    ArrayList<Questions> quesArr = new ArrayList<>();
    int QuesCounter = 1;
     public static int RightansCount;
    TextView questionsTV;
    RadioButton op1,op2,op3,op4;
    Button nextBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        fillData();
        questionsTV = findViewById(R.id.questionTV);
        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        op3 = findViewById(R.id.op3);
        op4 = findViewById(R.id.op4);
        nextBTN = findViewById(R.id.nextBTN);

        randomQuestions();
        screen();
        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAns();
                QuesCounter = QuesCounter + 1;
                if(QuesCounter<=5)
                {
                    screen();
                }
                else
                {
                    Result();
                }
            }
        });


    }

    public void fillData() {
        String[] op1 = new String[]{"6", "5", "7", "4"};
        selectedques.add(new Questions("How many days do we have in a week?", op1, 2));
        String[] op2 = new String[]{"364", "365", "360", "363"};
        selectedques.add(new Questions("How many days are there in a normal year?", op2, 1));
        String[] op3 = new String[]{"6", "7", "4", "5"};
        selectedques.add(new Questions("How many colors are there in a rainbow?", op3, 1));
        String[] op4 = new String[]{"Giraffe", "Lion", "Camel", "Snake"};
        String[] op5 = new String[]{"24", "25", "21", "26"};
        String[] op6 = new String[]{"One", "Two", "Three", "Four"};
        String[] op7 = new String[]{"24", "21", "25", "26"};
        String[] op8 = new String[]{"4", "5", "3", "1"};
        String[] op9 = new String[]{"January", "February", "March", "April"};
        String[] op10 = new String[]{"Tiger", "Dog", "Lion", "Cat"};
        selectedques.add(new Questions("Which animal is known as the ‘Ship of the Desert?",op4,2));
        selectedques.add(new Questions("How many letters are there in the English alphabet?",op5,3));
        selectedques.add(new Questions("How many primary colors are there?",op6,2));
        selectedques.add(new Questions("How many consonants are there in the English alphabet?",op7,1));
        selectedques.add(new Questions("How many sides are there in a triangle?",op8,2));
        selectedques.add(new Questions("Which month of the year has the least number of days?",op9,1));
        selectedques.add(new Questions("Which animal is called King of Jungle?",op10,2));

    }


    public void screen(){

       String question = quesArr.get(QuesCounter-1).getQuestion();
        questionsTV.setText(question);
        String[] opt1 = quesArr.get(QuesCounter-1).getOpts();
        op1.setText(opt1[0]);
        op2.setText(opt1[1]);
        op3.setText(opt1[2]);
        op4.setText(opt1[3]);

    }

    public void randomQuestions(){
        for(int i = 0;i<=5;i++)
        {
            Random random = new Random();
            int randomNo = random.nextInt(4);
            quesArr.add(new Questions(selectedques.get(randomNo).getQuestion(),selectedques.get(randomNo).getOpts(),selectedques.get(randomNo).getAnsInd()));
            selectedques.remove(randomNo);
        }
    }

    public void verifyAns(){
        if(op1.isChecked() && quesArr.get(QuesCounter-1).getAnsInd() == 0)
        {
            RightansCount = RightansCount + 1;
        }

        else if (op2.isChecked() && quesArr.get(QuesCounter-1).getAnsInd()==1)
        {
            RightansCount = RightansCount + 1;
        }

        else if(op3.isChecked() && quesArr.get(QuesCounter-1).getAnsInd()==2)
        {
            RightansCount = RightansCount + 1;
        }
        else if(op4.isChecked() && quesArr.get(QuesCounter-1).getAnsInd()==3)
        {
            RightansCount = RightansCount + 1;
        }

    }

    public void Result(){
        Intent intent = new Intent(this,ResultActivity.class);
        startActivity(intent);
    }







}