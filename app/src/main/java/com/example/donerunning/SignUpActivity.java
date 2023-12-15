package com.example.donerunning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {

    private EditText join_email, join_password, join_name, nick_name, height, weight, real_email;
    private Button join_button, cancel, check_button;
    private AlertDialog dialog;
    private boolean validate = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        join_email = findViewById( R.id.idET );
        join_password = findViewById( R.id.pwET );
        join_name = findViewById( R.id.nameET );
        nick_name = findViewById( R.id.nicknameET );
        height = findViewById( R.id.heightET );
        weight = findViewById( R.id.weightET );
        real_email = findViewById( R.id.emailET );

        join_button = findViewById(R.id.okBT);
        cancel = findViewById(R.id.cancelBT);
        check_button = findViewById(R.id.check_button);

        check_button.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                String UserEmail = join_email.getText().toString();
                if (validate) {
                    return; //검증 완료
                }

                if (UserEmail.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    dialog = builder.setMessage("아이디를 입력하세요.").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                                dialog = builder.setMessage("사용할 수 있는 아이디입니다.").setPositiveButton("확인", null).create();
                                dialog.show();
                                join_email.setEnabled(false); //아이디값 고정
                                validate = true; //검증 완료
                                check_button.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                                dialog = builder.setMessage("이미 존재하는 아이디입니다.").setNegativeButton("확인", null).create();
                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                ValidateRequest validateRequest = new ValidateRequest(UserEmail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SignUpActivity.this);
                queue.add(validateRequest);
            }
        });

        join_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String UserEmail = join_email.getText().toString();
                final String UserPwd = join_password.getText().toString();
                final String UserName = join_name.getText().toString();


                //아이디 중복체크 했는지 확인
                if (!validate) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    dialog = builder.setMessage("중복된 아이디가 있는지 확인하세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                //한 칸이라도 입력 안했을 경우
                if (UserEmail.equals("") || UserPwd.equals("") || UserName.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            //회원가입 성공시
                            if (success) {
                                //DB에 데이터추가
                                Toast.makeText(getApplicationContext(), String.format("%s님 가입을 환영합니다.", UserName), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                startActivity(intent);

                                //회원가입 실패시
                            } else {
                                Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //서버로 Volley를 이용해서 요청
                SignUpTask signuptask = new SignUpTask( UserEmail, UserPwd, UserName, responseListener);
                RequestQueue queue = Volley.newRequestQueue( SignUpActivity.this );
                queue.add( signuptask );
            }
        });
    }
}
