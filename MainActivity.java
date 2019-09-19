package com.example.scar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends Activity {
    private EditText name, area_,mobile,door_no;
    private Button send,bet,ret,alert;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("User Details");

        name=(EditText) findViewById(R.id.name1);
        area_=(EditText) findViewById(R.id.area1);
        mobile=(EditText) findViewById(R.id.mobile1);
        door_no=(EditText) findViewById(R.id.language1);
        send=(Button) findViewById(R.id.send_but);
        ret=(Button) findViewById(R.id.button6);
        bet=(Button) findViewById(R.id.drive_but);
        alert=(Button) findViewById(R.id.button2);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudents();
            }
        });

        bet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Motor will be opened for 15mins!", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void addStudents() {
        String Area =area_.getText().toString();
        String Name = name.getText().toString();
        String Mobile_No = mobile.getText().toString();
        String Door_No =door_no.getText().toString();


        if (!TextUtils.isEmpty(Name) && !TextUtils.isEmpty(Mobile_No) && !TextUtils.isEmpty(Door_No) && !TextUtils.isEmpty(Area)) {

            String id = databaseReference.push().getKey();
            Students student = new Students(id,Name, Area,Mobile_No,Door_No);
            databaseReference.child(id).setValue(student);
            name.setText("");
            area_.setText("");
            mobile.setText("");
            door_no.setText("");

        } else {

            Toast.makeText(MainActivity.this, "Field is empty!", Toast.LENGTH_LONG).show();

        }
    }
    //for driver activity

    public void openActivity2() {

        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent next =new Intent(this,DataRetrived.class);
        startActivity(next);
    }



// for party activity

    public void onBackPressed(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure want to exit!");
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}



