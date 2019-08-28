package com.example.android.dateme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    //HANDLING THE NAME INPUT
    public String getname (){
        EditText name = (EditText) findViewById(R.id.person_name);
        String plain_name = name.getText().toString();
        return plain_name;
    }

    //HANDLING THE AGE INPUT
    int age = 25;
    //Decreasing age
    public void decreaseAge (View view) {
        if (age == 18){
            age = 18;
            displayAge(age);
            Toast.makeText(this,getString(R.string.tooYoung), Toast.LENGTH_LONG).show();
        }
        else {
            age = age - 1;
            displayAge(age);
        }

    }
    //Increasing age
    public void increaseAge (View view) {
        if (age == 60){
            age = age + 1;
            displayAge(age);
            Toast.makeText(this, getString(R.string.tooOld), Toast.LENGTH_LONG).show();
        }
        else {
            age = age + 1;
            displayAge(age);
        }

    }
    //Showing age
    private void displayAge(int age) {
        TextView ageTextView = (TextView) findViewById(R.id.age_text_view);
        ageTextView.setText("" + age);
    }

    //HANDLING THE GENDER INPUT
    public void reactMale (View view) {
        Toast.makeText(this, getString(R.string.reactMale), Toast.LENGTH_LONG).show();
    }

    //HANDLING CONCERT INPUT
    public int concert_click() {
        int total = 0;
        RadioGroup radio_concert = (RadioGroup) findViewById(R.id.radio_concert);
        //Get which radioButton is checked
        int radioButtonID = radio_concert.getCheckedRadioButtonId();
        //Assigning value to radiobutton
        if (radioButtonID==R.id.articmonkeys) {
            total = total + 4;
        } else if (radioButtonID == R.id.justinbieber){
            total = total + 2;
        } else if (radioButtonID==R.id.katyperry) {
            total = total + 1;
        } else if (radioButtonID==R.id.theweeknd) {
            total = total + 3;
        }
        return total;
    }

    //HANDLING THE DATE INPUT
    public int date_click() {
        int total = 0;
        RadioGroup radio_concert = (RadioGroup) findViewById(R.id.radio_date);
        //Get which radioButton is checked
        int radioButtonID = radio_concert.getCheckedRadioButtonId();
        //Assigning value to radiobutton
        if (radioButtonID==R.id.coffee) {
            total = total + 3;
        } else if (radioButtonID == R.id.netflix){
            total = total + 1;
        } else if (radioButtonID==R.id.dinner) {
            total = total + 2;
        } else if (radioButtonID==R.id.pool) {
            total = total + 4;
        }
        return total;
    }

    //HANDLING THE CHORE INPUT
    public int chore_click() {
        int total = 0;
        RadioGroup radio_concert = (RadioGroup) findViewById(R.id.radio_chore);
        //Get which radioButton is checked
        int radioButtonID = radio_concert.getCheckedRadioButtonId();
        //Assigning value to radiobutton
        if (radioButtonID==R.id.cooking) {
            total = total + 1;
        } else if (radioButtonID == R.id.vacuuming){
            total = total + 2;
        } else if (radioButtonID==R.id.dust) {
            total = total + 3;
        } else if (radioButtonID==R.id.ironing) {
            total = total + 4;
        }
        return total;
    }

    //HANDLING THE PET INPUT
    public int pet_click() {
        int total = 0;
        RadioGroup radio_concert = (RadioGroup) findViewById(R.id.radio_pets);
        //Get which radioButton is checked
        int radioButtonID = radio_concert.getCheckedRadioButtonId();
        //Assigning value to radiobutton
        if (radioButtonID==R.id.fish) {
            total = total + 3;
        } else if (radioButtonID == R.id.dog){
            total = total + 4;
        } else if (radioButtonID==R.id.snake) {
            total = total + 1;
        } else if (radioButtonID==R.id.cat) {
            total = total + 2;
        }
        return total;
    }

    //CALCULATING TOTAL
    public int calculatetotal(){
        int concert_total = concert_click();
        int date_total = date_click();
        int chore_total = chore_click();
        int pet_total = pet_click();
        int total = concert_total + date_total + chore_total + pet_total;
        return total;
    }

    //MAKING SUCCESS MESSAGE
    public String makesuccessmessage(int total){
        String message;
        String name = getname();
        message = getString(R.string.hi) + " " + name + "!";
        message += "\n" + getString(R.string.scoresuccess) + ": " + total + getString(R.string.max) + "!";
        message += "\n" + getString(R.string.meet);
        return message;
    }

    //MAKING FAILURE MESSAGE
    public String makefailmessage(int total){
        String message;
        String name = getname();
        message = getString(R.string.sorry) + " " + name + ".";
        message += "\n" + getString(R.string.scorefailure) + ": " + total + getString(R.string.max) + ".";
        message += "\n" + getString(R.string.leave);
        return message;
    }


    //WHEN PRESSING THE SUBMIT BUTTON
    public void submit(View view) {
        int total = calculatetotal();
        String message;
        if (total > 8) {
            message = makesuccessmessage(total);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        } else {
            message = makefailmessage(total);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }


}

