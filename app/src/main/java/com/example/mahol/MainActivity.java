package com.example.mahol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    Spinner room_number;
    Button enter;
    EditText price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        room_number = (Spinner) findViewById(R.id.roomnumber);
        price = (EditText) findViewById(R.id.price);

        enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        check();
                    }
                }
        );
        //addData();


    }

    public void check() {
        if (room_number.getSelectedItem().equals("Room Number") || TextUtils.isEmpty(price.getText().toString())) {
            Toast.makeText(MainActivity.this, "Something is missing", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, demoactivity.class);
            startActivity(intent);

        }
    }


        public void addData() {
            String roomnumber = String.valueOf(room_number.getSelectedItem());
            final int roomprice = Integer.parseInt(price.getText().toString());
            myDb.insertData(roomnumber, roomprice);

        }


}
