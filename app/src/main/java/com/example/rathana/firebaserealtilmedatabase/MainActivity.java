package com.example.rathana.firebaserealtilmedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView tvMessage;
    EditText etMessage;
    String key;
    FirebaseDatabase mDatabase=FirebaseDatabase.getInstance();
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMessage=findViewById(R.id.tvMessage);
        etMessage=findViewById(R.id.edMessage);
        //create database reference
        ref=mDatabase.getReference("messages");
        findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });

        getMessage(ref);
    }

    private void send() {
        /*key=ref.child("message").push().getKey();
        String message=etMessage.getText().toString();
        Map<String, Object> updateValue=new HashMap<>();
        updateValue.put("/"+key,message);
        ref.updateChildren(updateValue);
        getMessage(ref);*/

        //save object
        Message message=new Message("m1","true","success","200");
        key=ref.child("message").push().getKey();
        Map<String, Object> updateValue=new HashMap<>();
        updateValue.put("/"+key,message);
        ref.updateChildren(updateValue);
        getMessage(ref);
    }

    public void getMessage(DatabaseReference ref) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(null!=key){
                    Message  message=dataSnapshot.child(key).getValue(Message.class);
                    tvMessage.setText(message.toString());
                }

                //tvMessage.setText(dataSnapshot.child(key).getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
