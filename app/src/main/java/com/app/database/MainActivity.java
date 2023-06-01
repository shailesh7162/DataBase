package com.app.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button btnadd,btnupdate,btndelet;
    EditText editname,editcontacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd=findViewById(R.id.btnadd);
        btnupdate=findViewById(R.id.btnupdate);
        btndelet=findViewById(R.id.btndelet);
        editname=findViewById(R.id.editname);
        editcontacts=findViewById(R.id.editcontacts);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editname.getText().toString();
                String contact = editcontacts.getText().toString();

                DBHelper dbHelper = new DBHelper(MainActivity.this);
               // dbHelper.insertData(name, contact);
              //  dbHelper.updateData(2,name,contact);
                dbHelper.deleteData(4);
            }
        });
    }
}