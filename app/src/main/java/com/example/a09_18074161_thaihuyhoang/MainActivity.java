package com.example.a09_18074161_thaihuyhoang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.a09_18074161_thaihuyhoang.recy.CustomAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListner {
    RecyclerView rcv;
    List<User> mUsers;
    CustomAdapter adt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv = findViewById(R.id.rcv);
        mUsers = new ArrayList<>();
        mUsers.add(new User("StartBuck Coofee",R.drawable.caramel,150));
        mUsers.add(new User("Black Coffee",R.drawable.caramel1,120));

//        mDonuts.add(new Donut(2,"a",10,"aaaa",R.drawable.donut_green));
        adt = new CustomAdapter(mUsers,  this);

        rcv.setHasFixedSize(true);
        rcv.setAdapter(adt);
//        rcv.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
rcv.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void itemClick(User user) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
}