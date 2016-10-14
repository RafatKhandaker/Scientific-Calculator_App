package nyc.c4q.rusili.scientific_calculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean lastequals = false;
    private String op = "";
    private String sNumber1, sNumber2, sAnswer;
    private String sDisplay = "";
    private String sDisplay2 = "";
    private TextView tvMain, tvHistory;
    private HorizontalScrollView scroll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        launchKeyPad(this);
        setContentView(R.layout.calculator);
        scroll = (HorizontalScrollView) findViewById(R.id.headerscroll);
        tvHistory = (TextView) findViewById(R.id.headerdisplay);
        tvMain = (TextView) findViewById(R.id.displaynumbers);
//        super.onSaveInstanceState(savedInstanceState);
}
    public void ce() {
        lastequals = false;
        sNumber1 = sNumber2 = sAnswer = sDisplay = sDisplay2 = "";
        tvMain.setText(sDisplay);
        tvHistory.setText(sDisplay2);
    }

    public void clear() {
        sDisplay = "";
        tvMain.setText(sDisplay);
    }

    public void addValue(int input) {
        sDisplay = Integer.toString(input);
        tvMain.setText(sDisplay);
        sDisplay2 += input;
        tvHistory.setText(sDisplay2);
    }

    public void addValue(char input) {
        sDisplay = Integer.toString(input);
        tvMain.setText(sDisplay);
        sDisplay2 += input;
        tvHistory.setText(sDisplay2);
    }

    public void del() {
        sDisplay = sDisplay.substring(0, (sDisplay.length() - 1));
        sDisplay2 = sDisplay2.substring(0, (sDisplay2.length() - 1));
        tvMain.setText(sDisplay);
        tvHistory.setText(sDisplay2);
    }
    public void onClickNum(View v) {
        Button b = (Button)v;
        int i = Integer.parseInt(b.getText().toString());
        addValue(i);
    }

    public void onClickUtil(View v) {
        Button b = (Button)v;
        String s = b.getText().toString();
        switch (s){
            case ".":
                if (!sDisplay.contains(".")) {
                    addValue('.');
                }
                break;
            case "DEL":
                this.del();
                break;
            case "":
                this.ce();
                break;
            case "=":
                sNumber2 = sDisplay;
                Log.d("sDisplay", sDisplay);
                if (op.equals("/")) {
                    sAnswer = Double.toString(Double.parseDouble(sNumber1) / Double.parseDouble(sNumber2));
                } else if (op.equals("*")) {
                    sAnswer = Double.toString(Double.parseDouble(sNumber1) * Double.parseDouble(sNumber2));
                } else if (op.equals("-")) {
                    sAnswer = Double.toString(Double.parseDouble(sNumber1) - Double.parseDouble(sNumber2));
                } else if (op.equals("+")) {
                    sAnswer = Double.toString(Double.parseDouble(sNumber1) + Double.parseDouble(sNumber2));
                }
                // Converts double to int if answer ends in ".0"
                if (Double.parseDouble(sAnswer) == Math.floor(Double.parseDouble(sAnswer))){
                    sAnswer = Integer.toString((int) Double.parseDouble(sAnswer));
                }

                tvMain.setText(sAnswer);
                if (lastequals) {
                    sDisplay2 += " " + op + " " + sNumber2;
                }
                lastequals = true;
                sNumber1 = sAnswer;
                sDisplay2 += " = " + sAnswer;
                tvHistory.setText(sDisplay2);

                scroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
                break;
        }
    }

    public void onClickOp(View v) {
        Button b = (Button)v;
        String s = b.getText().toString();

        if (!lastequals) {
            sNumber1 = sDisplay;
        }
        tvHistory.setText(sDisplay2);
        scroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
        lastequals = false;
        clear();
        switch (s){
            case "+":
                op = "+";
                sDisplay2 += " + ";
                break;
            case "-":
                op = "-";
                sDisplay2 += " - ";
                break;
            case "*":
                op = "*";
                sDisplay2 += " * ";
                break;
            case "/":
                op = "/";
                sDisplay2 += " / ";
                break;
        }
        tvHistory.setText(sDisplay2);
    }

    private void launchKeyPad(Context context){
        Intent intent = new Intent(context, KeyPad.class);
        context.startActivity(intent);
    }



}



//<--This code was taken from a deleted instance state -->

//    tvDeg = (TextView) findViewById(R.id.idDeg);
//    tvRad = (TextView) findViewById(R.id.idRad);
//    public void onSwitch(View view) {
//        if (isDeg){
//            tvDeg.setText("DEG");
//            tvDeg.setTextColor(Color.parseColor("#f7f7f7"));
//            tvDeg.setBackgroundColor(Color.parseColor("#767676"));
//            tvRad.setText(":::::");
//            tvRad.setTextColor(Color.parseColor("#505050"));
//            tvRad.setBackgroundColor(Color.parseColor("#f7f7f7"));
//            isDeg = false;
//        } else {
//            tvRad.setText("RAD");
//            tvRad.setTextColor(Color.parseColor("#f7f7f7"));
//            tvRad.setBackgroundColor(Color.parseColor("#767676"));
//            tvDeg.setText(":::::");
//            tvDeg.setTextColor(Color.parseColor("#505050"));
//            tvDeg.setBackgroundColor(Color.parseColor("#f7f7f7"));
//            isDeg = true;
//        }
//
//
//    }

