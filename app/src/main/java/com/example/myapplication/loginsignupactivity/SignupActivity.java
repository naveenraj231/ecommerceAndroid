package com.example.myapplication.loginsignupactivity;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.myapplication.R;
import com.example.myapplication.controller.API;
import com.example.myapplication.controller.APIInterface;
import com.example.myapplication.model.CustomerDetails;
import com.example.myapplication.model.LoginRequestBody;
import com.example.myapplication.model.Signupbody;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword,inputName;
    private Button btnSignIn, btnSignUp,select,upload;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    String email,password,name;
    private ImageView imageView;



    private int PICK_IMAGE_REQUEST = 1;
    private static final int STORAGE_PERMISSION_CODE = 123;
    private Bitmap bitmap;
    private Uri filePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btnSignIn = (Button) findViewById(R.id.sign_in_button);
        btnSignUp = (Button) findViewById(R.id.sign_up_button);


        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        inputName = (EditText) findViewById(R.id.name);
        imageView=(ImageView)findViewById(R.id.imageView);
        select=(Button)findViewById(R.id.buttonChoose);
        upload=(Button)findViewById(R.id.buttonUpload);



//        select.setOnClickListener((View.OnClickListener) this);
//        upload.setOnClickListener((View.OnClickListener) this);



        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        btnSignUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                email= inputEmail.getText().toString();
                 password = inputPassword.getText().toString();
                 name = inputName.getText().toString();


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Enter Name!!", Toast.LENGTH_SHORT).show();
                    return;
                }



                Signupbody signupbody=new Signupbody(email,password,name,"tcytc","en");
                sendtoken(signupbody);

            }



        });

    }



    public void sendtoken(Signupbody signupBody)
    {

        API.getRetrofitClient(API.BASE_URL).create(APIInterface.class).signup(signupBody).enqueue(
                new Callback<CustomerDetails>() {
                    @Override
                    public void onResponse(Call<CustomerDetails>call, Response<CustomerDetails> response) {
                        if (response.isSuccessful()) {
                            // success logic
                            Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText (SignupActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<CustomerDetails> call, Throwable t) {
                        Toast.makeText (SignupActivity.this, "failed", Toast.LENGTH_SHORT).show();


                    }
                }
        );
    }


    @Override
    protected void onResume() {
        super.onResume();

    }






}
