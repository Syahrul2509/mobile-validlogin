package com.syahrul.login;

import android.content.Intent;
import android.os.UserHandle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String User,Pass;
    TextInputEditText user,pass;
    TextInputLayout layoutlog,layoutpass;
    Button btlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutlog=findViewById(R.id.layoutlog);
        layoutpass=findViewById(R.id.layoutpass);
        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        btlog=findViewById(R.id.btlog);
        btlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User=user.getText().toString();
                Pass=pass.getText().toString();
                if (User.length()==0) {
                    layoutlog.setError("Kolom harus di isi");
                }else if (User!="admin"){
                    layoutlog.setError("masukan username yang benar");
                    if (User.equals("admin") || User.equals("user")){
                        layoutlog.setError(null);
                        layoutlog.setErrorEnabled(false);
                    }
                }

                if (Pass.length()==0){
                    layoutlog.setError("kolom harus di isi");
                }else if (Pass!="admin"){
                    layoutpass.setError("Masukan password yg benar");
                    if(Pass.equals("admin") || Pass.equals("user")){
                        layoutpass.setError(null);
                        layoutpass.setErrorEnabled(false);
                    }
                }
                if (User.equals("admin") && Pass.equals("user")){
                    layoutpass.setError("masukan password yang benar");
                }else if (User.equals("user") && Pass.equals("admin")){
                    layoutpass.setError("Masukan Password yang benar");
                }
                if (User.equals("admin") && Pass.equals("admin")){
                    Intent admin=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(admin);

                }if (User.equals("user") && Pass.equals("user")){
                    Intent User=new Intent(MainActivity.this,Main3Activity.class);
                    startActivity(User);
                }

            }
        });

    }
}
