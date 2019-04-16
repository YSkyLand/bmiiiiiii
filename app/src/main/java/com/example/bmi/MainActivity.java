package com.example.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ET1, ET2, ET3;
    private TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.eat);
    }

    int size = 30;

    public void response(View view) {
        ET1 = findViewById(R.id.editText);
        ET2 = findViewById(R.id.editText2);
        ET3 = findViewById(R.id.editText3);
        txv = findViewById(R.id.textView4);

        float height = Float.parseFloat(ET2.getText().toString());
        float weight = Float.parseFloat(ET3.getText().toString());
        float BMI1 = calculateBMI(height, weight);
        String BMI2 = String.valueOf(BMI1);

        txv.setTextSize(size);
        txv.setText("user:" + ET1.getText().toString() + "hello\n" + "Your BMI　is :" + BMI2);
        Toast.makeText(this, standardBMI(BMI1), Toast.LENGTH_LONG).show();
    }

    public float calculateBMI(float height, float weight) {
        float BMI = (float) (weight / Math.pow((height / 100), 2));
        return BMI;
    }

    public String standardBMI(float x) {
        String alert = "";

        if (x > 25) {
            alert = String.valueOf("你很重呢~真是可愛呢~");
            getWindow().setBackgroundDrawableResource(R.drawable.pig);
        } else if (x < 18.5) {
            alert = String.valueOf("豆芽菜很好吃，但希望你不要像豆芽菜一樣");
            getWindow().setBackgroundDrawableResource(R.drawable.vegetable);
        } else {
            alert = String.valueOf("你真的好棒棒喔!");
            getWindow().setBackgroundDrawableResource(R.drawable.sogreat);
        }
        return alert;
    }

}
