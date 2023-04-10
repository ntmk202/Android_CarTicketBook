package com.ntmk.carticketbook.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import com.ntmk.carticketbook.R;

public class PaymentActivity extends AppCompatActivity {

    ImageButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        backBtn = findViewById(R.id.backButton);

        backBtn.setOnClickListener(v -> onBackPressed());
    }
}