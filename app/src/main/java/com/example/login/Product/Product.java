package com.example.login.Product;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Product implements Parcelable {
    private String name;
    private String id;
    private String image;
    private double price;

    public Product(String name,String id, String image, double price) {
        this.name = name;
        this.id = id;
        this.image = image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }
    // Parcelable implementation
    protected Product(Parcel in) {
        name = in.readString();
        id = in.readString();
        image = in.readString();
        price = in.readDouble();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(image);
        dest.writeDouble(price);
    }
}
