package com.example.homework1_3;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int value1;
    int value2;
    String op;
    TextView textView;
ArrayList<String> list;
ArrayList<String> listOp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.result);
       list = new ArrayList<>();

        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");



        listOp = new ArrayList<>();


        listOp.add("*");
        listOp.add("+");
        listOp.add("-");
        listOp.add("/");


        if (savedInstanceState != null) {
            value1 = savedInstanceState.getInt("value1");
            value2 = savedInstanceState.getInt("value2");
            op = savedInstanceState.getString("op");


        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("value1",value1);
        outState.putInt("value2",value2);
        outState.putString("op",op);
    }

    public void onClinic(View v) {
        try {
            switch (v.getId()) {
                case R.id.zero:
                   textView.append("0");
                    list.get(0);
                    break;
                case R.id.one:
                    textView.append("1");
                    list.get(1);
                    break;
                case R.id.two:
                    textView.append("2");
                    list.get(2);
                    break;
                case R.id.three:
                    textView.append("3");
                    list.get(3);
                    break;
                case R.id.four:
                    textView.append("4");
                    list.get(4);
                    break;
                case R.id.five:
                    textView.append("5");
                    list.get(5);
                    break;
                case R.id.six:
                    textView.append("6");
                    list.get(6);
                    break;
                case R.id.seven:
                    textView.append("7");
                    list.get(7);
                    break;
                case R.id.eight:
                    textView.append("8");
                    list.get(8);
                    break;
                case R.id.nine:
                    textView.append("9");
                    list.get(9);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View v) {

        try {
            switch (v.getId()) {
                case R.id.multiply:
                    op = "*";
                    value1 = Integer.parseInt(textView.getText().toString());

                    textView.setText(value1+""+listOp.get(0));
                    break;
                case R.id.plus:
                    value1 = Integer.valueOf(textView.getText().toString());
                    textView.setText(value1+""+listOp.get(1));
                    op = "+";
                    break;
                case R.id.minus:
                    value1 = Integer.valueOf(textView.getText().toString());
                    textView.setText(value1 + ""+listOp.get(2));
                    op = "-";
                    break;
                case R.id.devite:
                    value1 = Integer.valueOf(textView.getText().toString());
                    textView.setText(value1 + ""+listOp.get(3));
                    op = "/";
                    break;
                case R.id.equel:
                    String first = textView.getText().toString().replace(value1 + op + "", "");
                    value2 = Integer.valueOf(first);
                    switch (op) {
                        case "+":
                            textView.setText(value1 + "+" + value2 + "=" + (value1 + value2));
                            break;
                        case "-":
                            textView.setText(value1 + "-" + value2 + "=" + (value1 - value2));
                            break;
                        case "*":
                            textView.setText(value1 + "*" + value2 + "=" + (value1 * value2));
                            break;
                        case "/":
                            textView.setText(value1 + "/" + value2 + "=" + (float) value1 / value2);
                            break;
                    }
                    break;
                case R.id.c:
                    textView.setText("");
                    break;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
