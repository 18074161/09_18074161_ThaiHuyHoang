package com.example.a09_18074161_thaihuyhoang.aa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a09_18074161_thaihuyhoang.MainActivity;
import com.example.a09_18074161_thaihuyhoang.R;
import com.example.a09_18074161_thaihuyhoang.database.TaiKhoan;
import com.example.a09_18074161_thaihuyhoang.database.UserDatabase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class SignIn extends AppCompatActivity {
    TextView plEmail, plPass;
    Button btnSignIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        plEmail = findViewById(R.id.plEmail);
        plPass = findViewById(R.id.plPass);
        btnSignIn = findViewById(R.id.btnSignIn);

        mAuth = FirebaseAuth.getInstance();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = plEmail.getText().toString();
                String password = plPass.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
                    Toast.makeText(SignIn.this, "Phải nhập đủ tài khaonr và mật khẩu", Toast.LENGTH_SHORT).show();
                else
                    DangNhap(email, password);

            }
        });

    }

    private void DangNhap(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String emai = email;
                            Date currentTime = Calendar.getInstance().getTime();
                            String time = String.valueOf(currentTime);
                            UserDatabase.getInstance(SignIn.this).userDao().addUser(new TaiKhoan(email,time));
                            Intent intent = new Intent(SignIn.this, MainActivity.class);
//                            intent.putExtra("authen",email);
                            startActivity(intent);
                            Toast.makeText(SignIn.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(SignIn.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    }
