package com.serdynskim.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText firstNumber = findViewById(R.id.number1);
        final EditText secondNumber = findViewById(R.id.number2);
        final RadioGroup operators = findViewById(R.id.operators);
        final RadioButton add = findViewById(R.id.add); // we dont have component yet
        final RadioButton subtract = findViewById(R.id.subtract);
        final RadioButton multiplication = findViewById(R.id.multiplication);
        final RadioButton divison = findViewById(R.id.division);
        final Button equals = findViewById(R.id.equals);
        final TextView result = findViewById(R.id.result);
        final Switch darkMode = findViewById(R.id.darkMode);



        darkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    buttonView.setText("Dark Mode");
                }
                else {
                    AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_NO));
                    buttonView.setText("Light Mode");
                }
            }
        });


        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final double firstNumberValue = Double.parseDouble(firstNumber.getText().toString());
                final double secondNumberValue = Double.parseDouble(secondNumber.getText().toString());

                final int operatorButtonId = operators.getCheckedRadioButtonId();

                Double answer;

                if (operatorButtonId == add.getId()) {
                    answer = firstNumberValue + secondNumberValue;
                } else if (operatorButtonId == subtract.getId()){
                    answer = firstNumberValue - secondNumberValue;
                }
                else if (operatorButtonId == multiplication.getId()){
                    answer = firstNumberValue * secondNumberValue;
                }
                else{
                    answer = firstNumberValue / secondNumberValue;
                }

                result.setText(answer.toString());
            }
        });
    }
    }