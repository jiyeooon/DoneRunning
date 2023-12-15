package com.example.donerunning;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;


import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity{

    private EditText login_email, login_password;
    private Button login_button, find_button, signup_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        login_email = findViewById( R.id.idET );
        login_password = findViewById( R.id.pwET );
        login_button = findViewById( R.id.loginBT );
        login_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserEmail = login_email.getText().toString();
                String UserPwd = login_password.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {//로그인 성공시

                                String UserEmail = jsonObject.getString( "UserEmail" );
                                String UserPwd = jsonObject.getString( "UserPwd" );
                                String UserName = jsonObject.getString( "UserName" );

                                Toast.makeText( getApplicationContext(), String.format("%s님 환영합니다.", UserName), Toast.LENGTH_SHORT ).show();
                                Intent intent = new Intent( LoginActivity.this, MainActivity.class );

                                intent.putExtra( "UserEmail", UserEmail );
                                intent.putExtra( "UserPwd", UserPwd );
                                intent.putExtra( "UserName", UserName );

                                startActivity( intent );

                            } else {//로그인 실패시
                                Toast.makeText( getApplicationContext(), "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT ).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginTask loginRequest = new LoginTask( UserEmail, UserPwd, responseListener );
                RequestQueue queue = Volley.newRequestQueue( LoginActivity.this );
                queue.add( loginRequest );

            }
        });
        find_button = findViewById( R.id.FindIdpwBT );
        find_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FindIdPw.class);
                startActivity(intent);//액티비티 띄우기
            }
        });

        signup_button = findViewById( R.id.signupBT );
        signup_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);//액티비티 띄우기
            }
        });


    }
}

