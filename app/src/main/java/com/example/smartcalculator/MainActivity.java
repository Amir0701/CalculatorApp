package com.example.smartcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;
    private TextView mathOperationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mathOperationTextView = findViewById(R.id.math_operation);
        resultText = findViewById(R.id.result);
        onClick();
    }

    private void appendMathOperation(String operation){
        if(resultText.getText().length() != 0) {
            mathOperationTextView.setText(resultText.getText());
            resultText.setText("");
        }
        mathOperationTextView.append(operation);

    }

    private void onClick(){
        findViewById(R.id.CE_button).setOnClickListener(view -> {
            mathOperationTextView.setText("");
            resultText.setText("");
        });

        findViewById(R.id.open_scope_button).setOnClickListener(view -> {
            appendMathOperation("(");
        });

        findViewById(R.id.close_scope_button).setOnClickListener(view->{
            appendMathOperation(")");
        });

        findViewById(R.id.plus_button).setOnClickListener(view -> {
            appendMathOperation("+");
        });

        findViewById(R.id.seven_button).setOnClickListener(view ->{
            appendMathOperation("7");
        });

        findViewById(R.id.eight_button).setOnClickListener(view ->{
            appendMathOperation("8");
        });

        findViewById(R.id.nine_button).setOnClickListener(view ->{
            appendMathOperation("9");
        });

        findViewById(R.id.minus_button).setOnClickListener(view ->{
            appendMathOperation("-");
        });

        findViewById(R.id.four_button).setOnClickListener(view ->{
            appendMathOperation("4");
        });

        findViewById(R.id.five_button).setOnClickListener(view ->{
            appendMathOperation("5");
        });

        findViewById(R.id.six_button).setOnClickListener(view ->{
            appendMathOperation("6");
        });

        findViewById(R.id.multiplication_buttn).setOnClickListener(view ->{
            appendMathOperation("*");
        });

        findViewById(R.id.one_button).setOnClickListener(view ->{
            appendMathOperation("1");
        });

        findViewById(R.id.two_button).setOnClickListener(view ->{
            appendMathOperation("2");
        });

        findViewById(R.id.three_button).setOnClickListener(view ->{
            appendMathOperation("3");
        });

        findViewById(R.id.division_button).setOnClickListener(view ->{
            appendMathOperation("/");
        });

        findViewById(R.id.zero_button).setOnClickListener(view ->{
            appendMathOperation("0");
        });

        findViewById(R.id.dot_button).setOnClickListener(view ->{
            appendMathOperation(".");
        });

        findViewById(R.id.backspace_button).setOnClickListener(view ->{
            if(mathOperationTextView.getText().length() != 0) {
                String mathOperation = mathOperationTextView.getText().toString();
                mathOperationTextView.setText("");
                appendMathOperation(mathOperation.substring(0, mathOperation.length() - 1));
            }
        });

        findViewById(R.id.equal_button).setOnClickListener(view -> {
            try {
                Expression expression = new ExpressionBuilder(mathOperationTextView.getText().toString()).build();
                double result = expression.evaluate();
                long resultLong = (long)result;
                double res = (double)resultLong;

                if (result == res) {
                    resultText.setText(Long.toString(resultLong));
                } else {
                    resultText.setText(Double.toString(result));
                }

                //resultText.setText(Double.toString(result));
            }catch (Exception ex){
                Log.d("Error", "сообщение: " + ex.getMessage());
            }
        });
    }
}