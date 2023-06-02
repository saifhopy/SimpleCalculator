package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;
    private double currentNumber = 0;
    private String currentOperator = "";
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        // Attachez les événements aux boutons de l'interface utilisateur
        Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("0");
            }
        });

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("1");
            }
        });
        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("2");
            }
        });
        Button button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("3");
            }
        });Button button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("4");
            }
        });Button button5=findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("5");
            }
        });Button button6=findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("6");
            }
        });Button button7=findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("7");
            }
        });Button button8=findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("8");
            }
        });Button button9=findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("9");
            }
        });

        // Ajoutez les événements pour les autres boutons

        Button buttonplus = findViewById(R.id.buttonAdd);
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("+");
            }
        });
        Button buttonmoins = findViewById(R.id.buttonSubtract);
        buttonmoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("-");
            }
        });
        Button buttonfois = findViewById(R.id.buttonMultiply);
        buttonfois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("*");
            }
        });
        Button buttondiviser = findViewById(R.id.buttonDivide);
        buttondiviser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("/");
            }
        });
        Button buttondot=findViewById(R.id.buttonDot);
        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumber(".");
            }
        });
        Button buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });



        // Ajoutez les événements pour les autres opérations
        Button buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCalculator();
            }
        });

        Button buttonBackspace = findViewById(R.id.buttonBackspace);
        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLastDigit();
            }
        });
    }
    private void resetCalculator() {
        resultTextView.setText("0");
    }

    // Remove the last digit entered in the operation
    private void removeLastDigit() {
        String currentText = resultTextView.getText().toString();
        int length = currentText.length();

        // Ensure there is at least one character
        if (length > 1) {
            // Remove the last character
            String newText = currentText.substring(0, length - 1);
            resultTextView.setText(newText);
        } else {
            // If only one character is left, set the text to 0
            resultTextView.setText("0");
        }
    }


    private void appendNumber(String number) {
        if (isNewOperation) {
            resultTextView.setText(number);
            isNewOperation = false;
        } else {
            resultTextView.append(number);
        }
    }

    private void performOperation(String operator) {
        currentOperator = operator;
        currentNumber = Double.parseDouble(resultTextView.getText().toString());
        isNewOperation = true;
    }

    private void calculateResult() {
        double newNumber = Double.parseDouble(resultTextView.getText().toString());
        double result = 0;

        switch (currentOperator) {
            case "+":
                result = Calculator.add(currentNumber, newNumber);
                break;
            case "-":
                result=Calculator.subtract(currentNumber,newNumber);
                break;
            case "*":
                result=Calculator.multiply(currentNumber,newNumber);
                break;
            case "/":
                result=Calculator.divide(currentNumber,newNumber);

            default:
                break;
        }

        resultTextView.setText(String.valueOf(result));
        isNewOperation = true;
    }

    // Ajoutez d'autres méthodes pour les autres opérations et fonctionnalités de la calculatrice
}
