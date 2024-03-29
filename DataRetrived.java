package com.example.scar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DataRetrived extends AppCompatActivity {
    private ListView listView;
    private TextView textView;
    DatabaseReference databaseReference;
    List<Students>studentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_retrived);
        listView = findViewById(R.id.list_view);
        textView = (TextView)findViewById(R.id.dist1);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("User Details");
        studentsList =new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for(DataSnapshot studentSnapshot : dataSnapshot.getChildren()){

                   Students student = studentSnapshot.getValue(Students.class);
                   studentsList.add(student);
               }
               StudentInfoAdapter studentInfoAdapter =new StudentInfoAdapter(DataRetrived.this,studentsList);
               listView.setAdapter(studentInfoAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
