package com.example.paymentlist.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.paymentlist.R;
import com.example.paymentlist.model.PaymentMethod;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PaymentListAdapter extends RecyclerView.Adapter<PaymentListAdapter.PaymentListViewHolder> {

    private List<PaymentMethod> paymentMethods = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public PaymentListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payment_method, parent, false);
        return new PaymentListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PaymentListViewHolder holder, int position) {
        PaymentMethod paymentMethod = paymentMethods.get(holder.getAdapterPosition());
        holder.bind(paymentMethod);
    }

    @Override
    public int getItemCount() {
        return paymentMethods.size();
    }

    public void submitList(List<PaymentMethod> paymentMethods) {
        this.paymentMethods.clear();
        this.paymentMethods.addAll(paymentMethods);
        notifyDataSetChanged();
    }

    public static class PaymentListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public PaymentListViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }

        public void bind(PaymentMethod paymentMethod) {
            textView.setText(paymentMethod.getLabel());

            Glide.with(imageView.getContext()).load(paymentMethod.getImageUrl()).into(imageView);
        }
    }
}
