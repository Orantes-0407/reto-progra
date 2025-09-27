package com.example.zenquotesapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.zenquotesapp.R;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btnInicio = findViewById(R.id.btnInicio);
        btnInicio.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, EmocionActivity.class);
            startActivity(intent);
        });
    }
}

