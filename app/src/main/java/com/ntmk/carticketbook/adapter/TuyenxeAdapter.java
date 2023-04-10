package com.ntmk.carticketbook.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ntmk.carticketbook.R;
import com.ntmk.carticketbook.model.Tuyenxe;
import com.ntmk.carticketbook.view.ThongtinveActivity;

import java.util.ArrayList;

public class TuyenxeAdapter extends RecyclerView.Adapter<TuyenxeAdapter.TuyenxeViewHolder> {

        Context context;
        ArrayList<Tuyenxe> newTuyenxeList;
        int person = 0;

    public TuyenxeAdapter(Context context, ArrayList<Tuyenxe> newTuyenxeList,int person){
        this.context = context;
        this.newTuyenxeList = newTuyenxeList;
        this.person = person;
    }

    @NonNull
    @Override
    public TuyenxeAdapter.TuyenxeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View tuyenxeView = LayoutInflater.from(context).inflate(R.layout.tuyenxe_item, parent, false);

        return new TuyenxeViewHolder(tuyenxeView);
    }

    @Override
    public void onBindViewHolder(@NonNull TuyenxeAdapter.TuyenxeViewHolder holder, int position) {
        Tuyenxe tuyenxe = newTuyenxeList.get(position);
        holder.tvTimeStart.setText(tuyenxe.getThoiGianDi());
        holder.tvTimeEnd.setText(tuyenxe.getThoiGianDen());
        holder.tvLocationStart.setText(tuyenxe.getDiemDi());
        holder.tvLocationEnd.setText(tuyenxe.getDiemDen());
        holder.tvPriceTicket.setText(String.valueOf(tuyenxe.getGiaVe()));
        holder.tvCarType.setText(tuyenxe.getLoaiXe());
        holder.cvTuyenxeItem.setOnClickListener(v -> {
//            Toast.makeText(context,"no1", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(context, ThongtinveActivity.class);
            intent.putExtra("timeStart", newTuyenxeList.get(position).getThoiGianDi());
            intent.putExtra("timeEnd", newTuyenxeList.get(position).getThoiGianDen());
            intent.putExtra("locationStart", newTuyenxeList.get(position).getDiemDi());
            intent.putExtra("locationEnd", newTuyenxeList.get(position).getDiemDen());
            intent.putExtra("PriceKey", newTuyenxeList.get(position).getGiaVe());
            intent.putExtra("Person", person);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return newTuyenxeList.size();
    }

    public static class TuyenxeViewHolder extends RecyclerView.ViewHolder {

        TextView tvTimeStart;
        TextView tvTimeEnd;
        TextView tvLocationStart;
        TextView tvLocationEnd;
        TextView tvPriceTicket;
        TextView tvCarType;
        CardView cvTuyenxeItem;

        public TuyenxeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTimeStart = itemView.findViewById(R.id.timeStart);
            tvTimeEnd = itemView.findViewById(R.id.timeEnd);
            tvLocationStart = itemView.findViewById(R.id.locationStart);
            tvLocationEnd = itemView.findViewById(R.id.locationEnd);
            tvPriceTicket = itemView.findViewById(R.id.ticketPrice);
            tvCarType = itemView.findViewById(R.id.CarType);
            cvTuyenxeItem = itemView.findViewById(R.id.tuyenxe_item);
        }
    }
}
