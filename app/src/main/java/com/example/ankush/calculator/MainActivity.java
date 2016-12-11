package com.example.ankush.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean[] function = new boolean[4];
    double[] temp = {0, 0};
    boolean decimalflag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        TextView tv=(TextView)findViewById(R.id.text);
        tv.setMovementMethod(new ScrollingMovementMethod());
        Button b1=(Button)findViewById(R.id.one);
        b1.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                tv.append("1");
            }
        });
        Button b2=(Button)findViewById(R.id.two);
        b2.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                tv.append("2");
            }
        });
        Button b3=(Button)findViewById(R.id.three);
        b3.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                tv.append("3");
            }
        });
        Button b4=(Button)findViewById(R.id.four);
        b4.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                tv.append("4");
            }
        });
        Button b5=(Button)findViewById(R.id.five);
        b5.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                tv.append("5");
            }
        });
        Button b6=(Button)findViewById(R.id.six);
        b6.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                tv.append("6");
            }
        });
        Button b7=(Button)findViewById(R.id.seven);
        b7.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                tv.append("7");
            }
        });
        Button b8=(Button)findViewById(R.id.eight);
        b8.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                tv.append("8");
            }
        });
        Button b9=(Button)findViewById(R.id.nine);
        b9.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                tv.append("9");
            }
        });
        Button bplus=(Button)findViewById(R.id.plus);
        bplus.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                temp[0]=Double.parseDouble(tv.getText().toString());
                function[0]=true;
                tv.setText("");
            }
        });
        Button bminus=(Button)findViewById(R.id.minus);
        bminus.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                temp[0]=Double.parseDouble(tv.getText().toString());
                function[1]=true;
                tv.setText("");
                //  tv.append(" - ");
            }
        });
        Button bequal=(Button)findViewById(R.id.equal);
        bequal.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                getResult();
            }
        });
        Button bmul=(Button)findViewById(R.id.multiply);
        bmul.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                temp[0]=Double.parseDouble(tv.getText().toString());
                function[2]=true;
                tv.setText("");
            }
        });
        Button bdiv=(Button)findViewById(R.id.divide);
        bdiv.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                temp[0]=Double.parseDouble(tv.getText().toString());
                function[3]=true;
                tv.setText("");
            }
        });
        Button bsqrt=(Button)findViewById(R.id.sqrt);
        bsqrt.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                getSqrt();
            }
        });
        Button bclear=(Button)findViewById(R.id.C);
        bclear.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                clear();
            }
        });
        Button bsign=(Button)findViewById(R.id.sign);
        bsign.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                getPosNeg();
            }
        });
        Button bzero=(Button)findViewById(R.id.zero);
        bzero.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                tv.append("0");
            }
        });
        Button bdec=(Button)findViewById(R.id.decimal);
        bdec.setOnClickListener(new View.OnClickListener(){
            TextView tv=(TextView)findViewById(R.id.text);
            @Override
            public void onClick(View v) {
                if(!decimalflag) {
                    tv.append(".");
                    decimalflag=true;
                }
            }
        });
    }
    public void clear(){
        TextView tv=(TextView)findViewById(R.id.text);
        try{
            tv.setText("");
            decimalflag=false;
            for(int i=0;i<4;i++)
                function[i]=false;
            for(int i=0;i<2;i++)
                temp[i]=0;
        }catch(NullPointerException e){

        }
    }
    public void getSqrt() {
        TextView tv=(TextView)findViewById(R.id.text);
        try {
            double value = Math.sqrt(Double.parseDouble(tv.getText().toString()));
            tv.setText(Double.toString(value));
        } catch(NumberFormatException e) {
        }
    }

    public void getPosNeg() {
        TextView tv=(TextView)findViewById(R.id.text);
        try {
            double value = Double.parseDouble(tv.getText().toString());
            if(value != 0) {
                value = value * (-1);
                tv.setText(Double.toString(value));
            }
            else {
            }
        } catch(NumberFormatException e) {
        }
    }

    public void getResult() {
        double result = 0;
        TextView tv=(TextView)findViewById(R.id.text);
        temp[1] = Double.parseDouble(tv.getText().toString());
        try {
            if(function[2] == true)
                result = temp[0] * temp[1];
            else if(function[3] == true) {
                if(temp[1]!= 0) {
                   // Toast.makeText(this, "yo", Toast.LENGTH_SHORT).show();
                    result = temp[0] / temp[1];
                }
                else {
                    Toast.makeText(this, "Kambakht 0 se divide?", Toast.LENGTH_SHORT).show();
                }
            }
            else if(function[0] == true)
                result = temp[0] + temp[1];
            else if(function[1] == true)
                result = temp[0] - temp[1];
            tv.setText(Double.toString(result));
            for(int i = 0; i < 4; i++)
                function[i] = false;
        } catch(NumberFormatException e) {
        }
    }

}
