package com.example.dell_3421.tourism_location;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn_Activity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText userText,passwordText;
    private Button btn_signin, btn_sinup;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signin);
        getSupportActionBar().hide();
        //Get Firebase auth instance
        mAuth = FirebaseAuth.getInstance();

        userText = (EditText) findViewById(R.id.editText_user);
        passwordText = (EditText) findViewById(R.id.editText_Password);
        btn_signin = (Button) findViewById(R.id.button_signin);
        btn_sinup = (Button) findViewById(R.id.button_create);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_signin);
        btn_sinup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(SignIn_Activity.this,SignUp_Activity.class);
                startActivity(go);
                finish();
            }
        });

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userText.getText().toString().trim();
                String password = passwordText.getText().toString();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(SignIn_Activity.this, "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(SignIn_Activity.this, "Enter password! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.length()<6){
                    Toast.makeText(SignIn_Activity.this, "Password too short!!!!", Toast.LENGTH_SHORT).show();
                    return;
                }
//              progressBar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(SignIn_Activity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.e("Task","Is here!");
                                if(!task.isSuccessful()){
                                    Toast.makeText(SignIn_Activity.this,"Login fail.",Toast.LENGTH_SHORT).show();
                                }else{
                                    Intent go = new Intent(SignIn_Activity.this,MainLogin_Activity.class);
                                    startActivity(go);
                                    finish();
                                }
                            }
                        });
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}
