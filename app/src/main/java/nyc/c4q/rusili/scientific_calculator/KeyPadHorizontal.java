package nyc.c4q.rusili.scientific_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView; 

import org.mariuszgromada.math.mxparser.Expression;


/**
 * Created by RafatK *AKA* BlackJack on 10/7/16.
 */

public class KeyPadHorizontal extends AppCompatActivity{


    private TextView tvMainLand,tvHistoryLand;
    private String landDisplay = "";
    private String landHistory = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        tvMainLand = (TextView) findViewById(R.id.tv_MainLand);
        tvHistoryLand = (TextView) findViewById(R.id.idHistoryLand);
//
    }






    //-------------------------------- Landscape Functions ---------------------------------
    boolean finishedExpression = false;
    boolean logActivated = false;


    public void setCalculator(){
        tvMainLand.setText(landDisplay);
        tvHistoryLand.setText(landDisplay);
    }


    public void onClickNumLand(View v){    // xml on click function for adding numbers, parens, and simple operators to display
        Button b = (Button) v;
        String i = (String)b.getText();
        if(finishedExpression){
            landDisplay = i;
            landHistory = i;
            setCalculator();
            finishedExpression = false;
        }
        else {
            landDisplay += i;
            landHistory += i;
            setCalculator();
        }
    }

    public void onClickOpLand(View v){    // xml on click function for adding numbers, parens, and simple operators to display
        Button b = (Button) v;
        String i = (String)b.getText();
        landDisplay += i;
        landHistory += i;
        setCalculator();
        finishedExpression = false;
    }

    public void onClickEqualsPress(View v){ // xml on click function that evaluates the string in the main textview using mxparser
        String input = (String) tvMainLand.getText();
        Expression e = new Expression(input);
        String answer = Double.toString(e.calculate());
        tvMainLand.setText(answer);
        landDisplay = answer;
        finishedExpression = true;
    }

    public void onClickDelPress(View v){
        landDisplay = "";
        landHistory = "";
        setCalculator();
    }

    public void onClickSinTanCos(View v){
        Button b = (Button) v;
        String operation = b.getText().toString() + '(';
        landDisplay += operation;
        landHistory += operation;
        setCalculator();
    }

    public void onExponentClick(View v){
        landDisplay += "^";
        landHistory += "^";
        setCalculator();
        finishedExpression = false;
    }

    public void onSqrtClick(View v){
        landDisplay += "sqrt(";
        landHistory += "sqrt(";
        setCalculator();
    }

    public void onExponentialClick(View v){
        landDisplay += "!";
        landHistory += "!";
        setCalculator();
        finishedExpression = false;
    }

    public void onClickPiLand(View v){    // xml on click function for adding numbers, parens, and simple operators to display
        String i = "pi";
        if(finishedExpression){
            landDisplay = i;
            landHistory = i;
            setCalculator();
            finishedExpression = false;
        }
        else {
            landDisplay += i;
            landHistory += i;
            setCalculator();
        }
    }


    public void onClickELand(View v){
        String i = "e";
        if(finishedExpression){
            landDisplay = i;
            landHistory = i;
            setCalculator();
            finishedExpression = false;
        }
        else {
            landDisplay += i;
            landHistory += i;
            setCalculator();
        }
    }

    public void onLnClick(View v){
        landDisplay += "ln(";
        landHistory += "ln(";
        setCalculator();
    }

    public void onLogClick(View v){
        if(!logActivated){
            Button b = (Button) v;
            b.setText(",");
            landDisplay += "log(";
            landHistory += "log(";
            setCalculator();
            logActivated = true;
        }
        else {
            Button b = (Button) v;
            b.setText("log");
            landDisplay += ",";
            landHistory += ",";
            setCalculator();
            logActivated = false;
        }
    }



    public void onClickExpLand(View v){    // xml on click function for adding numbers, parens, and simple operators to display
        landDisplay += "E";
        landHistory += "E";
        setCalculator();
        finishedExpression = false;
    }










}

