package com.ntmk.carticketbook.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;
import com.ntmk.carticketbook.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    AutoCompleteTextView placeStart, placeEnd, person;
    TextInputEditText date;
    Button filterBtn;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public void showDatePickerDialog(View v) {
        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText(R.string.date);
        MaterialDatePicker<Long> datePicker = builder.build();
        datePicker.addOnPositiveButtonClickListener(selection -> {
            // Do something with the selected date
            long selectedDate = selection;
            // Update the EditText with the selected date
            date = findViewById(R.id.calendar);
            date.setText(dateFormat.format(new Date(selectedDate)));
        });
        datePicker.show(getSupportFragmentManager(), "datePicker");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeStart = findViewById(R.id.placeStart);
        placeEnd = findViewById(R.id.placeEnd);
        date = findViewById(R.id.calendar);
        person = findViewById(R.id.countPreson);
        filterBtn = findViewById(R.id.filterButton);
//        placeStart = findViewById(R.id.placeStart);
//        placeEnd = findViewById(R.id.placeEnd);
//        date = findViewById(R.id.calendar);
//        person = findViewById(R.id.countPreson);

        String[] places = getResources().getStringArray(R.array.places);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, places);




        filterBtn.setOnClickListener(v -> {
//            if(placeStart.getText().equals(" ") || placeEnd.getText().equals(" ") || date.getText().equals(" ") || person.getText().equals("") ){
//
//                Toast.makeText(this,"Vui lòng điền đầy đủ thông tin",Toast.LENGTH_LONG).show();
//            }else{
                Intent intent = new Intent(this, TuyenxeActivity.class);
                intent.putExtra("placeStart",placeStart.getText().toString());
                intent.putExtra("placeEnd",placeEnd.getText().toString());
                intent.putExtra("date",date.getText().toString());
                intent.putExtra("person",Integer.parseInt(person.getText().toString()));
                startActivity(intent);
//            }
        });

        placeStart.setAdapter(arrayAdapter);
        placeEnd.setAdapter(arrayAdapter);

    }
}



