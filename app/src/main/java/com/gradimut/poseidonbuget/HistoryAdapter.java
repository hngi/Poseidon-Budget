package com.gradimut.poseidonbuget;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gradimut.poseidonbuget.model.BudgetModel;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    List<BudgetModel> budgetList;
    Context context;

    public HistoryAdapter(Context context, List<BudgetModel> budgetList) {
        this.budgetList = budgetList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTxt, tvTotal, tvDate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTxt = itemView.findViewById(R.id.tvTxt);
            tvTotal = itemView.findViewById(R.id.tvTotal);
            tvDate = itemView.findViewById(R.id.tvDate);
        }

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.single_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        BudgetModel item = budgetList.get(i);
        viewHolder.tvTxt.setText(item.getName());

        double amnt = Double.parseDouble(item.getAmount());
        int trans = (int) amnt;
        final SharedPreferences sharedPreferences = context.getSharedPreferences("USER_CURRENCY", MODE_PRIVATE);
        final String userCurrency = sharedPreferences.getString("CURRENCY", "DEFAULT_EMAIL");
        viewHolder.tvTotal.setText(userCurrency + " " + trans);
        viewHolder.tvDate.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return budgetList.size();
    }
}

