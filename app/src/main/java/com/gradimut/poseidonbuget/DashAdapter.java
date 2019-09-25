package com.gradimut.poseidonbuget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DashAdapter extends RecyclerView.Adapter<DashAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<DashModel> mList;

    DashAdapter(Context context, ArrayList<DashModel> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.single_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        DashModel salaryItem = mList.get(position);

        ImageView image = viewHolder.avatar_view;
        TextView salary, stroke, currency, total, date;

        salary = viewHolder.item_salary;
        stroke = viewHolder.item_stroke;
        currency = viewHolder.item_currency;
        date = viewHolder.item_date;
        total = viewHolder.item_total;

        image.setImageResource(salaryItem.getImage());

        salary.setText(salaryItem.getSalary());
        currency.setText(salaryItem.getCurrency());
        date.setText(salaryItem.getDate());
        total.setText(salaryItem.getTotal());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar_view;
        TextView item_salary, item_currency, item_stroke, item_total, item_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            avatar_view = itemView.findViewById(R.id.iconSymbol);
            item_salary = itemView.findViewById(R.id.tvFirst);
            item_stroke = itemView.findViewById(R.id.tvStroke);
            item_currency = itemView.findViewById(R.id.currName);
            item_date = itemView.findViewById(R.id.tvDate);
            item_total = itemView.findViewById(R.id.tvTotal);
        }
    }
}
