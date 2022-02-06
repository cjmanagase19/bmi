package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button submitBtn;
    private EditText nameText, ageEditTxt,heightEditTxt,weightTxt;
    private double pounds =0, inches =0, bmi=0;
    private String name;
    private int age;
    private double height;
    private double weight;
    private double feet=0,meter;
    private double grams;
    private double ounce;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitBtn = (Button) findViewById(R.id.submitBtn);
        nameText = (EditText) findViewById(R.id.nameEditTxt);
        ageEditTxt = (EditText) findViewById(R.id.ageEditTxt);
        heightEditTxt = (EditText) findViewById(R.id.heightEditTxt);
        weightTxt = (EditText) findViewById(R.id.weightEditTxt);
        nameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText("");
            }

        });
        ageEditTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ageEditTxt.setText("");
            }
        });
        heightEditTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heightEditTxt.setText("");
            }
        });
        weightTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weightTxt.setText("");
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age = Integer.parseInt(ageEditTxt.getText().toString());
                height = Double.parseDouble(heightEditTxt.getText().toString());
                weight = Double.parseDouble(weightTxt.getText().toString());


                name = nameText.getText().toString();
                result();
                startBMI();
            }
        });

    }
    public String result()
    {

        //weight
        pounds = this.weight * 2.205;
        grams = weight * 1000;
        ounce = weight * 35.274;
        //height
        inches = this.height * 0.394;
        feet = height * 0.0328084;
        meter = height * 0.01;

        bmi = pounds /inches/inches*703;
        if(bmi < 18.5) {
            System.out.println("You are underweight");
        }else if (bmi < 25) {
            System.out.println("You are normal");
        }else if (bmi < 30) {
            System.out.println("You are overweight");
        }else {
            System.out.println("You are obese");
        }

        return "";
    }
    public void startBMI() {
        if (nameText.getText().toString().equals("")) {
            nameText.setError("Input a name");
        } else if (weightTxt.getText().toString().equals("")) {
            weightTxt.setError("Input a weight");
        } else if (heightEditTxt.getText().toString().equals(""))
        {
            heightEditTxt.setError("Input a height");
        }
        else if(ageEditTxt.getText().toString().equals(""))
        {
            ageEditTxt.setError("Input Age");
        }
        else
        {
            Intent intent = new Intent(this, result.class);
            Bundle bundle = new Bundle();
            bundle.putString("name",name);
            bundle.putInt("age",age);
            bundle.putDouble("height",height);
            bundle.putDouble("weight",weight);
            bundle.putDouble("bmiNumber",bmi);
            bundle.putString("bmi",result());
            bundle.putDouble("pounds",pounds);
            bundle.putDouble("inches",inches);
            bundle.putDouble("ounce",ounce);
            bundle.putDouble("grams",grams);
            bundle.putDouble("feet",feet);
            bundle.putDouble("meter",meter);
            intent.putExtras(bundle);
            startActivity(intent);

        }
    }

}