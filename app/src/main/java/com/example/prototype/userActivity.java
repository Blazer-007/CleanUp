package com.example.prototype;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.HashMap;

public class userActivity extends AppCompatActivity {

    EditText location,type;
    Button addBtn,viewBtn;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference rootRef = db.getReference();
    DatabaseReference userRef = rootRef.child("Users");
    DatabaseReference garbageRef = rootRef.child("Garbage");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        location = findViewById(R.id.locationID);
        type = findViewById(R.id.typeID);
        addBtn = findViewById(R.id.addID);
        viewBtn = findViewById(R.id.viewID);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String garbageLocation,garbageType;
                garbageLocation = location.getText().toString().trim();
                garbageType = type.getText().toString().trim();

                HashMap<String,String> gbg = new HashMap<>();
                gbg.put("Location", garbageLocation);
                gbg.put("Type", garbageType);
                gbg.put("Status", "Unclean");

                garbageRef.push().setValue(gbg);

            }
        });



        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(userActivity.this,details.class);
                startActivity(intent);
            }
        });

    }
}
