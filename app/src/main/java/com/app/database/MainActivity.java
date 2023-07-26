package com.app.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnadd;
    EditText editname, editnumber;

    ArrayList<Integer> idList = new ArrayList<>();
    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> numberList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd = findViewById(R.id.btnadd);
        editname = findViewById(R.id.editname);
        editnumber=findViewById(R.id.editnumber);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=editname.getText().toString();
                String number=editnumber.getText().toString();
                DBHelper dbHelper=new DBHelper(MainActivity.this);


                Cursor cursor=dbHelper.showContact();
                while (cursor.moveToNext())
                {
                    Log.d("TTT", "onCreate: Id="+cursor.getInt(0));
                    Log.d("TTT", "onCreate: Name="+cursor.getString(1));
                    Log.d("TTT", "onCreate: Number="+cursor.getString(2));
                    idList.add(cursor.getInt(0));
                    nameList.add(cursor.getString(1));
                    numberList.add(cursor.getString(2));

                }
             //   dbHelper.updateContact(idList.get(2),name,number);
               // dbHelper.deleteContact(id);

            }
        });

    }
}