package com.example.android.aboutnorthernireland;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int initialScore;
    RadioButton answerOne, answerTwo, answerThree, answerFour;
    CheckBox chk1,chk2,chk3,chk4;
    EditText answerSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    //The following method displays the final score
    public void myScore(View view) {
        //Radiobutton question one
        answerOne = (RadioButton) findViewById(R.id.europe);
        boolean hasOne = answerOne.isChecked();

        //Radiobutton question two
        answerTwo = (RadioButton) findViewById(R.id.belfast);
        boolean hasTwo = answerTwo.isChecked();

        //Radiobutton question three
        answerThree = (RadioButton) findViewById(R.id.christianity);
        boolean hasThree = answerThree.isChecked();

        //Radiobutton question four
        answerFour = (RadioButton) findViewById(R.id.six);
        boolean hasFour = answerFour.isChecked();

        //Checkbox  question five
        chk1 = (CheckBox) findViewById(R.id.coast);
        chk2 = (CheckBox) findViewById(R.id.titanic);
        chk3 = (CheckBox) findViewById(R.id.tower);
        chk4 = (CheckBox) findViewById(R.id.mountain);
        boolean hasFive = chk1.isChecked();chk2.isChecked();

        //EditText question six
        answerSix = (EditText) findViewById(R.id.square);

        int scorTot = calculateScore(hasOne, hasTwo, hasThree, hasFour, hasFive);
        int ulTim = scorTot + finNum();

        Toast.makeText(this, "You got " + ulTim + " answers right out of 6.", Toast.LENGTH_LONG).show();
    }
    //The following method calculate the total score from all questions except question six ( calculate the score from the RadioButton and the CheckBox question types)
    private int calculateScore(boolean addOne, boolean addTwo, boolean addThree, boolean addFour, boolean addFive) {
        int baseScore = 0;
        if (addOne) {
            baseScore = baseScore + 1;
        }
        if (addTwo) {
            baseScore = baseScore + 1;
        }
        if (addThree) {
            baseScore = baseScore + 1;
        }
        if (addFour) {
            baseScore = baseScore + 1;
        }

        if (chk1.isChecked() && chk2.isChecked() && !chk3.isChecked() && !chk4.isChecked()){
            if (addFive)
            baseScore = baseScore + 1;
        }
        return initialScore + baseScore;
    }
    //the following method finds the value entered in the EditText field and compares it to the right value (2000)
    public int finNum() {
        int scoreNow = initialScore;
        int correctAnswer = 1921;
        String edTxt = answerSix.getText().toString();
        if (edTxt.equals("")) {
            Toast edTxt1 = Toast.makeText(getApplicationContext(), "Check your answers, you forgot to answer question 6!", Toast.LENGTH_SHORT);
            edTxt1.show();
            edTxt1.setGravity(Gravity.CENTER,0,0);
            edTxt1.show();
        } else {
            int notxt = Integer.parseInt(answerSix.getText().toString());
            if (correctAnswer == notxt) {
                scoreNow = initialScore + 1;
            } else {
                scoreNow = initialScore;
            }

        }

        return initialScore + scoreNow;
    }
}
