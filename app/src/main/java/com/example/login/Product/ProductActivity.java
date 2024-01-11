package com.example.login.Product;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ProductActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = findViewById(R.id.ProductRecycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(ProductActivity.this,productList);
        recyclerView.setAdapter(productAdapter);

        // Lấy dữ liệu sản phẩm từ Firebase Realtime Database
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("products");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String productId = snapshot.getKey();
                    String productName = snapshot.child("name").getValue(String.class);
//                    String productDetail = snapshot.child("detail").getValue(String.class);
                    String productImage = snapshot.child("image").getValue(String.class);
                    int productPrice = snapshot.child("price").getValue(Integer.class);

                    Product product = new Product (productName, productImage, productPrice);
                    productList.add(product);
                }
                productAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
