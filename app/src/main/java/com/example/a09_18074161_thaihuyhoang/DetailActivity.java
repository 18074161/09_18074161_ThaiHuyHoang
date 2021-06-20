package com.example.a09_18074161_thaihuyhoang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a09_18074161_thaihuyhoang.api.APIService;
import com.example.a09_18074161_thaihuyhoang.api.Cart;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    TextView tvQuantity, tvDetailPrice, tvDetailName;
    ImageButton imgbtnPlus,imgbtnMinus;
    ImageView imgDetailUser;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetailName = findViewById(R.id.tvDetailName);
        tvQuantity = findViewById(R.id.tvQuantity);
        tvDetailPrice = findViewById(R.id.tvDetailPrice);
        imgDetailUser = findViewById(R.id.imgDetailUser);
        btnAdd = findViewById(R.id.btnAdd);
        imgbtnPlus = findViewById(R.id.imgbtnPlus);
        imgbtnMinus = findViewById(R.id.imgbtnMinus);

        User user = (User) getIntent().getSerializableExtra("user");
        tvDetailName.setText(user.getName());
        tvDetailPrice.setText(user.getPrice()+"");
        imgDetailUser.setImageResource(user.getAnh());

        imgbtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soluong = Integer.parseInt(tvQuantity.getText().toString());
                APIService.apiService.addUser(new Cart(user.getName(),user.getPrice(),soluong)).enqueue(new Callback<Cart>() {
                    @Override
                    public void onResponse(Call<Cart> call, Response<Cart> response) {
                        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Cart> call, Throwable t) {

                    }
                });
            }
        });






    }
}