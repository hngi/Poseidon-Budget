package com.gradimut.poseidonbuget;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gradimut.poseidonbuget.model.ItemModel;

import java.util.List;


public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.ViewHolder> {
    BudgetActivity mBudgetActivity;

    List<ItemModel> itemModelList;

    public BudgetAdapter(List<ItemModel> itemModelList) {
        this.itemModelList = itemModelList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemExId, text_cost;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemExId =  itemView.findViewById(R.id.itemExId);
            text_cost = itemView.findViewById(R.id.text_cost);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_expenditure_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ItemModel item = itemModelList.get(i);
        viewHolder.itemExId.setText(item.getItemName());
        viewHolder.text_cost.setText(item.getBudgetAllocate());
    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }
}
