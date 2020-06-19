package com.example.docsach;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Content extends AppCompatActivity {

    TextView textView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myData = database.getReference();
    Bookitem content;
    String stt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        textView = findViewById(R.id.tvContent);
        Intent intent = getIntent();
        stt = intent.getExtras().getString("stt");
        stt = String.valueOf(Integer.parseInt(stt) + 1);
        myData.child("Book").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                content = dataSnapshot.getValue(Bookitem.class);
                if(content.BookID.contains(stt)){
                    textView.setText(content.BookContent);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}