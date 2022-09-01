package com.jb.geriglazer_mycalculatortests;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView sum;
    private char operator = ' ';
    private double totalSum = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPointer();
    }

    private void setPointer(){
        sum = findViewById(R.id.sum);
    }

    @Override
    public void onClick(View view) {
        double myNum = Double.parseDouble(sum.getText().toString());
        Log.e("click", "onClick: "+view.getId() );
        switch (view.getId()){
            case R.id.num1:
                myNum=myNum*10+1;
                break;
            case R.id.num2:
                myNum=myNum*10+2;
                break;
            case R.id.num3:
                myNum=myNum*10+3;
                break;
            case R.id.num4:
                myNum=myNum*10+4;
                break;
            case R.id.num5:
                myNum=myNum*10+5;
                break;
            case R.id.num6:
                myNum=myNum*10+6;
                break;
            case R.id.num7:
                myNum=myNum*10+7;
                break;
            case R.id.num8:
                myNum=myNum*10+8;
                break;
            case R.id.num9:
                myNum=myNum*10+9;
                break;
            case R.id.num0:
                myNum=myNum*10;
                break;
            case R.id.clear:
                myNum=0.0;
                break;
            case R.id.div:
                totalSum = myNum;
                operator = '/';
                myNum=0;
                break;
            case R.id.multiply:
                totalSum = myNum;
                operator = '*';
                myNum=0;
                break;
            case R.id.minus:
                totalSum = myNum;
                operator = '-';
                myNum=0;
                break;
            case R.id.plus:
                totalSum = myNum;
                operator = '+';
                myNum=0;
                break;
            case R.id.ce:
                myNum=0;
                totalSum=0;
                operator=' ';
                break;
            case R.id.equal:
                switch (operator){
                    case '+':
                        myNum+=totalSum;
                        operator=' ';
                        break;
                    case '-':
                        myNum-=totalSum-myNum;
                        operator=' ';
                        break;
                    case '*':
                        myNum*=totalSum;
                        operator=' ';
                        break;
                    case '/':
                        if(myNum==0) {
                            Toast.makeText(this, "Can`t divide by zero", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        myNum=totalSum/myNum;
                        operator=' ';
                        break;
                    default:
                        sum.setText("Error");
                        return;
                }
                operator=' ';
        }
        sum.setText(String.valueOf(myNum));
    }
}