package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is to return the bitcoded state of a multiple choice answer with three Checkboxes
     * @return answer is returned with bitcoded state of checked boxes: Box1 Bit 0, Box2 Bit 1, Box3 Bit 2
     */
    public int checkboxAnswer3(boolean checkedA, boolean checkedB, boolean checkedC) {
        int answer = 0;
        
        if (checkedA) 
            answer += 1;
        if (checkedB)
            answer += 2;
        if (checkedC)
            answer += 4;
        
        return answer;
    }

    /**
     * This method is to return the result of question 1 (false or true)
     * @return resultQ1 is returned which is a boolean that is true when the answer is correct and false when it is wrong
     */
    private boolean checkAnswerQ1() {
        int answerQ1 = 0;
        boolean resultQ1 = false;

        CheckBox CheckBoxA = findViewById(R.id.question1CheckBox1);
        boolean checkedA = CheckBoxA.isChecked();
        CheckBox CheckBoxB = findViewById(R.id.question1CheckBox2);
        boolean checkedB = CheckBoxB.isChecked();
        CheckBox CheckBoxC = findViewById(R.id.question1CheckBox3);
        boolean checkedC = CheckBoxC.isChecked();

        answerQ1 = checkboxAnswer3(checkedA, checkedB, checkedC);

        if (answerQ1 == 6) {
            resultQ1 = true;
        }

        return resultQ1;
    }

    /**
     * This method is to return the result of question 2 (false or true)
     * @return resultQ2 is returned which is a boolean that is true when the answer is correct and false when it is wrong
     */
    private boolean checkAnswerQ2() {
        int answerQ2 = 0;
        boolean resultQ2 = false;

        CheckBox CheckBoxA = findViewById(R.id.question2CheckBox1);
        boolean checkedA = CheckBoxA.isChecked();
        CheckBox CheckBoxB = findViewById(R.id.question2CheckBox2);
        boolean checkedB = CheckBoxB.isChecked();
        CheckBox CheckBoxC = findViewById(R.id.question2CheckBox3);
        boolean checkedC = CheckBoxC.isChecked();

        answerQ2 = checkboxAnswer3(checkedA, checkedB, checkedC);

        if (answerQ2 == 5) {
            resultQ2 = true;
        }

        return resultQ2;
    }

    /**
     * This method is to return the result of question 3 (false or true)
     * @return resultQ3 is returned which is a boolean that is true when the answer is correct and false when it is wrong
     */
    private boolean checkAnswerQ3() {
        boolean resultQ3 = false;

        RadioButton radioButtonB = findViewById(R.id.no_radio_button);
        boolean checkedB = radioButtonB.isChecked();

        if (checkedB == true) {
            resultQ3 = true;
        }

        return resultQ3;
    }

    /**
     * This method is to return the result of question 4 (false or true)
     * @return resultQ4 is returned which is a boolean that is true when the answer is correct and false when it is wrong
     */
    private boolean checkAnswerQ4() {
        boolean resultQ4 = false;
        
        RadioButton radioButtonA = findViewById(R.id.A_radio_button);
        boolean checkedA = radioButtonA.isChecked();

        if (checkedA == true) {
            resultQ4 = true;
        }

        return resultQ4;
    }

    /**
     * This method checks if the user input for question 5 matches the correct answer "Banana"
     * If the user enters any text containing the word banana and not containing the word apple, the question is considered answered correctly
     * @return resultQ5 is returned which is a boolean that is true when the answer is correct and false when it is wrong
     */
    private boolean checkAnswerQ5() {
        boolean resultQ5 = false;
        String correctAnswerOption = getString(R.string.correctAnswerQ5);
        String wrongAnswerOption = getString(R.string.wrongAnswerQ5);

        EditText inputAnswerQ5 = (EditText) findViewById(R.id.AnswerFieldQ5);
        String answerQ5 = inputAnswerQ5.getText().toString();

        resultQ5 = answerQ5.toLowerCase().contains(correctAnswerOption.toLowerCase());

        if (answerQ5.toLowerCase().contains(wrongAnswerOption.toLowerCase())) {
            resultQ5 = false;
        }

        return resultQ5;
    }

    /**
     * This method checks the results of all 5 questions and displays in a toast message the result for each question, as well as a summary how many questions were answered correctly
     * @return this function does not return any value
     */
    public void checkAnswers(View view) {
        int points = 0;
        String answerToQuestion1 = getString(R.string.question) + " 1: " + getString(R.string.wrong);
        String answerToQuestion2 = getString(R.string.question) + " 2: " + getString(R.string.wrong);
        String answerToQuestion3 = getString(R.string.question) + " 3: " + getString(R.string.wrong);
        String answerToQuestion4 = getString(R.string.question) + " 4: " + getString(R.string.wrong);
        String answerToQuestion5 = getString(R.string.question) + " 5: " + getString(R.string.wrong);

        if (checkAnswerQ1() == true) {
            answerToQuestion1 = getString(R.string.question) + " 1: " + getString(R.string.correct);
            points += 1;
        }

        if (checkAnswerQ2() == true) {
            answerToQuestion2 = getString(R.string.question) + " 2: " + getString(R.string.correct);
            points += 1;
        }

        if (checkAnswerQ3() == true) {
            answerToQuestion3 = getString(R.string.question) + " 3: " + getString(R.string.correct);
            points += 1;
        }

        if (checkAnswerQ4() == true) {
            answerToQuestion4 = getString(R.string.question) + " 4: " + getString(R.string.correct);
            points += 1;
        }

        if (checkAnswerQ5() == true) {
            answerToQuestion5 = getString(R.string.question) + " 5: " + getString(R.string.correct);
            points += 1;
        }

        String rightAnswers = Integer.toString(points);

        String answerSummary = answerToQuestion1 +"\n";
        answerSummary += answerToQuestion2 +"\n";
        answerSummary += answerToQuestion3 +"\n";
        answerSummary += answerToQuestion4 +"\n";
        answerSummary += answerToQuestion5 +"\n";

        if (points == 5) {
            answerSummary += getString(R.string.summary5Of5);
        }
        else if ((points >= 2) && (points <5)) {
            answerSummary +=  getString(R.string.summarySomeOf5, rightAnswers);
        }
        else if (points == 1) {
            answerSummary += getString(R.string.summary1Of5);
        }
        else {
            answerSummary += getString(R.string.summaryNoneOf5);
        }
        answerSummary += "\n" + getString(R.string.score) + " " + points;

        Toast.makeText(this, answerSummary, Toast.LENGTH_LONG).show();
        return;
    }
}