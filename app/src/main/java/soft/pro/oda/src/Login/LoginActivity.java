package soft.pro.oda.src.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import soft.pro.oda.R;
import soft.pro.oda.src.Signup.SignupActivity;
import soft.pro.oda.src.main.MainActivity;

public class LoginActivity extends AppCompatActivity {

    EditText mId;
    EditText mPw;
    CheckBox mCheckBox;
    Button mLogin;
    Button mSignup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_login);

       mId=(EditText)findViewById(R.id.id);
       mPw=(EditText)findViewById(R.id.pw);
       mCheckBox=(CheckBox) findViewById(R.id.checkBox);
       mLogin=(Button)findViewById(R.id.login_button);
       mSignup=(Button)findViewById(R.id.sign_up);


        mId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });
        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),SignupActivity.class);
                startActivity(intent);
            }
        });
    }


}
