package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class cleanerActivity extends AppCompatActivity {

    TextView cleanername;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference cleanerRef = database.getReference("Cleaners");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaner);

        cleanername = findViewById(R.id.cleanerName);
    }
}
