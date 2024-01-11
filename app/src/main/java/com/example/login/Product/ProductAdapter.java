package com.example.login.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.login.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    private List<Product> productList;

    public ProductAdapter(Context context,List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        // Hiển thị thông tin sản phẩm trong ViewHolder
        holder.nameTextView.setText(product.getName());
        holder.priceTextView.setText(String.valueOf(product.getPrice()));
        Glide.with(context)
                .load(product.getImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView priceTextView;
        public ImageView imageView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_txt);
            priceTextView = itemView.findViewById(R.id.price_txt);
            imageView = itemView.findViewById(R.id.drink_img);
        }
    }
}