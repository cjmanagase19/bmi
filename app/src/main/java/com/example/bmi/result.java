package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class result extends AppCompatActivity{
    private EditText multiText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle bundle = getIntent().getExtras();

        multiText = (EditText) findViewById(R.id.MultipleEdittxt);
        multiText.setEnabled(false);

        multiText.setText("Name: "+bundle.getString("name")+"\n"+"age: "
                +bundle.getInt("age")+"\n"+"Weight: "+bundle.getDouble("weight")
                +"\n"+"Height: "+bundle.getDouble("height")+"\n\n"+bundle.getString("bmi")+"\n"
                +String.format("%.02f",bundle.getDouble("bmiNumber"))+"\n\n"+"Converted Weight"+"\n"
                +"Ounce: "+bundle.getDouble("ounce")+"\n"+"Grams: "+bundle.getDouble("grams")+"\n"
                +"Pounds: "+ bundle.getDouble("pounds")+"\n\n"+"Converted Height"+"\n"
                +"Meter: "+bundle.getDouble("meter")+"\n"+"Feet: "+bundle.getDouble("feet")+"\n"
                +"Inches: "+ bundle.getDouble("inches"));





    }
}