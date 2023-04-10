package com.ntmk.carticketbook.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.ntmk.carticketbook.R;

public class ThongtinveActivity extends AppCompatActivity {

    TextView timeStart2, timeEnd2, locationStart2, locationEnd2;
    TextInputEditText inputName, inputNumber,inputEmail, myPlace;
    Button nextActivity;
    ImageButton backBtn;
    LinearLayout locationBtn;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinve);

        backBtn = findViewById(R.id.backButton);
        nextActivity = findViewById(R.id.nextButton);
        locationBtn = findViewById(R.id.linearLayout2);
        timeStart2 = findViewById(R.id.timeStart2);
        timeEnd2 = findViewById(R.id.timeEnd2);
        locationStart2 = findViewById(R.id.locationStart2);
        locationEnd2 = findViewById(R.id.locationEnd2);



        backBtn.setOnClickListener(v -> onBackPressed());


        Intent intentdata = getIntent();
        String timeStart = intentdata.getExtras().getString("timeStart");
        String timeEnd = intentdata.getExtras().getString("timeEnd");
        String locationStart = intentdata.getExtras().getString("locationStart");
        String locationEnd = intentdata.getExtras().getString("locationEnd");
        int person = intentdata.getExtras().getInt("Person");
        int priceKey = intentdata.getExtras().getInt("PriceKey");


        timeStart2.setText(timeStart);
        timeEnd2.setText(timeEnd);
        locationStart2.setText(locationStart);
        locationEnd2.setText(locationEnd);

        nextActivity.setOnClickListener(v -> {
            myPlace = findViewById(R.id.myPlace);
            inputName = findViewById(R.id.inputName);
            inputNumber = findViewById(R.id.inputNumber);
            inputEmail = findViewById(R.id.inputEmail);

            Intent intent = new Intent(this, ConfirmPayActivity.class);
            intent.putExtra("DiemDi",locationStart);
            intent.putExtra("DiemDen",locationEnd);
            intent.putExtra("ThoiGianDi",timeStart);
            intent.putExtra("ThoiGianDen",timeEnd);
            intent.putExtra("GiaVe",priceKey);
            intent.putExtra("DiemDon",myPlace.getText().toString());
            intent.putExtra("HoVaTen",inputName.getText().toString());
            intent.putExtra("SoDienThoi",inputNumber.getText().toString());
            intent.putExtra("Email",inputEmail.getText().toString());
            intent.putExtra("SoNguoi",person);
            startActivity(intent);
        });
    }
}