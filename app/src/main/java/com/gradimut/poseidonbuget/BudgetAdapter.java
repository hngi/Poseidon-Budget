package com.gradimut.poseidonbuget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<BudgetModel> mList;

    BudgetAdapter(Context context, ArrayList<BudgetModel> list) {
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

        BudgetModel budgetItem = mList.get(position);

        TextView itemName, cost;

        itemName = viewHolder.item_name;
        cost = viewHolder.item_cost;

        itemName.setText(budgetItem.getName());
        cost.setText(budgetItem.getCost());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_name, item_cost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item_name = itemView.findViewById(R.id.text_item);
            item_cost = itemView.findViewById(R.id.text_cost);
        }
    }
}
