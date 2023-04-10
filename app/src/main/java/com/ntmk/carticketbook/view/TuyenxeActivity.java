package com.ntmk.carticketbook.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ntmk.carticketbook.R;
import com.ntmk.carticketbook.adapter.TuyenxeAdapter;
import com.ntmk.carticketbook.model.Tuyenxe;

import java.util.ArrayList;

public class TuyenxeActivity extends AppCompatActivity {

    RecyclerView TuyenxeRecyclerView;
    ArrayList<Tuyenxe> TuyenxeList = new ArrayList<>();
    ImageButton backBtn;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuyenxe);

        Intent intent = getIntent();
        String placeStart = intent.getStringExtra("placeStart");
        String placeEnd = intent.getStringExtra("placeEnd");
        String date = intent.getStringExtra("date");
        int person = intent.getIntExtra("person",0);

        backBtn = findViewById(R.id.backButton);

        backBtn.setOnClickListener(v -> onBackPressed());

        TuyenxeRecyclerView = findViewById(R.id.tuyenxeRecyclerView);
        TuyenxeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mDatabase= FirebaseDatabase.getInstance().getReference("ThongTinChuyenDi");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshotJob) {
//                JobList.removeAll(JobList);
                for (DataSnapshot postSnapshotJob : dataSnapshotJob.getChildren()) {
                    Tuyenxe tuyenxe = (Tuyenxe) postSnapshotJob.getValue(Tuyenxe.class);
                    if (tuyenxe.getDiemDi().equals(placeStart) && tuyenxe.getDiemDen().equals(placeEnd)){
                        String day = (String) tuyenxe.getThoiGianDi().split(" ")[1];
                        day = day.replace('/','-');
                        if (day.equals(date)) {
                            TuyenxeList.add(new Tuyenxe(tuyenxe.getThoiGianDi(), tuyenxe.getThoiGianDen(), tuyenxe.getDiemDi(), tuyenxe.getDiemDen(), tuyenxe.getGiaVe(), tuyenxe.getLoaiXe()));

                            TuyenxeAdapter tuyenxeAdapter = new TuyenxeAdapter(getApplicationContext(), TuyenxeList,person);
                            TuyenxeRecyclerView.setAdapter(tuyenxeAdapter);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("false");
            }

        });
    }
}