package com.example.login.Product;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProductActivity extends AppCompatActivity {

    private EditText editTextProductName;
    private EditText editTextProductID;
    private EditText editTextProductPrice;
    private EditText editTextProductImageURL;
    private Button buttonAddProduct;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        editTextProductName = findViewById(R.id.editTextProductName);
        editTextProductID = findViewById(R.id.editTextProductID);
        editTextProductPrice = findViewById(R.id.editTextProductPrice);
        editTextProductImageURL = findViewById(R.id.editTextProductImageURL);
        buttonAddProduct = findViewById(R.id.buttonAddProduct);

        databaseReference = FirebaseDatabase.getInstance().getReference("products");

        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin sản phẩm từ các trường EditText
                String productName = editTextProductName.getText().toString();
                String productID = editTextProductID.getText().toString();
                double productPrice = Double.parseDouble(editTextProductPrice.getText().toString());
                String productImageURL = editTextProductImageURL.getText().toString();

                // Tạo đối tượng Product
                Product product = new Product(productName, productID, productImageURL, productPrice);

                // Lưu thông tin sản phẩm vào Firebase Realtime Database
                databaseReference.child(productID).setValue(product);

                // Đóng hoạt động và trả về kết quả thành công
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}