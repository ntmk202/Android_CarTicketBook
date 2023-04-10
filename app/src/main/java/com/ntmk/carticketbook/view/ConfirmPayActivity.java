package com.ntmk.carticketbook.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ntmk.carticketbook.R;

public class ConfirmPayActivity extends AppCompatActivity {

    ImageButton backBtn;
    Button payButton;
    TextView paymentMethod, diemDi, diemDen, thoigianDi, thoigianDen, name, number, email, address, count, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_pay);

        Intent intentdata = getIntent();
        String DiemDi = intentdata.getExtras().getString("DiemDi");
        String DiemDen = intentdata.getExtras().getString("DiemDen");
        String ThoiGianDi = intentdata.getExtras().getString("ThoiGianDi");
        String ThoiGianDen = intentdata.getExtras().getString("ThoiGianDen");
        String DiemDon = intentdata.getExtras().getString("DiemDon");
        String HoVaTen = intentdata.getExtras().getString("HoVaTen");
        String SoDienThoi = intentdata.getExtras().getString("SoDienThoi");
        String Email = intentdata.getExtras().getString("Email");
        int SoNguoi = intentdata.getExtras().getInt("SoNguoi");
        int GiaVe = intentdata.getExtras().getInt("GiaVe");

        payButton = findViewById(R.id.payButton);
        backBtn = findViewById(R.id.backButton);
        paymentMethod = findViewById(R.id.paymentMethod);
        diemDi = findViewById(R.id.txDiemdi);
        diemDen = findViewById(R.id.txDiemden);
        thoigianDi = findViewById(R.id.txThoigiandi);
        thoigianDen = findViewById(R.id.txThoigianden);
        name = findViewById(R.id.txName);
        number = findViewById(R.id.txNumber);
        email = findViewById(R.id.txEmail);
        address = findViewById(R.id.txAddress);
        count = findViewById(R.id.txCount);
        price = findViewById(R.id.txPrice);

        diemDi.setText(DiemDi);
        diemDen.setText(DiemDen);
        thoigianDi.setText(ThoiGianDi);
        thoigianDen.setText(ThoiGianDen);
        number.setText(SoDienThoi);
        name.setText(HoVaTen);
        email.setText(Email);
        address.setText(DiemDon);
        count.setText(String.valueOf(SoNguoi));
        price.setText(GiaVe*SoNguoi+" VND");

        backBtn.setOnClickListener(v -> onBackPressed());
        paymentMethod.setOnClickListener(v -> {
            startActivity(new Intent(this, PaymentActivity.class));
        });
        payButton.setOnClickListener(v -> {
            Toast.makeText(this,"Pay Succesccfully",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
        });


    }
}