package soft.pro.oda.src.Signup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import soft.pro.oda.R;
import soft.pro.oda.src.BaseActivity;
import soft.pro.oda.src.Signup.interfaces.SignupActivityView;
import soft.pro.oda.src.main.interfaces.MainActivityView;

public class SignupActivity extends BaseActivity implements SignupActivityView {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    RadioGroup rg;
    Button checkButton;
    TextView resultWindow;
    TextView reason;
    TextView intro;
    Button signButton;
    int userCode;
    int selectCode;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);
        editText5=findViewById(R.id.editText5);
        rg=(RadioGroup)findViewById(R.id.rg);
        checkButton=findViewById(R.id.checkButton);
        resultWindow=findViewById(R.id.resultWindow);
        reason=findViewById(R.id.reason);
        signButton=findViewById(R.id.signButton);
        intro=findViewById(R.id.intro);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tryGetTest(editText1.getText().toString());
            }
        });
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intro.clearComposingText();
                tryUserTest(editText1.getText().toString(),
                        editText2.getText().toString(),
                        selectCode
                        ,editText5.getText().toString()
                        );
            }
        });

    }



    @Override
    public void validateSuccess(int code,String text) {
        hideProgressDialog();
//       resultWindow.setText(text);
        if(code==100)
            resultWindow.setText("중복된 id 존재");
        if(code==150)
            resultWindow.setText("중복된 id 없음");
    }

    @Override
    public void validateFailure(String message) {

        hideProgressDialog();
        showCustomToast(message==null||message.isEmpty()?getString(R.string.network_error):message);
    }
    private void tryGetTest(String something)
    {
        showProgressDialog();
        final SignupService signupService=new SignupService(this,something);
        signupService.idTest();
    }

    @Override
    public void userSuccess(int code, String text) {
        reason.setText(text);
        hideProgressDialog();
        if(code==0)
            intro.append("공백입력");
        if(code==10)
            intro.append("특수문자 입력");
        if(code==200)
            intro.append("성공");
        if(code==20)
            intro.append("id는 4자 이상 10자 이하");
        if(code==30)
            intro.append("pw는 5장 이상 15자 이하");
    }

    @Override
    public void userFailure(int code, String message) {
        hideProgressDialog();
        showCustomToast(message==null||message.isEmpty()?getString(R.string.network_error):message);
    }

    private void tryUserTest(String id,String pw,int select,String address) {
        showProgressDialog();
        final SignupService signupService=new SignupService(this,id,pw,3,address);
        signupService.userTest();
    }

    public void radioClick(View view) {
        switch (view.getId()) {
            case R.id.rad1:
                selectCode=1;
            case R.id.rad2:
                selectCode=2;
            case R.id.rad3:
                selectCode=3;
            case R.id.rad4:
                selectCode=4;
            case R.id.rad5:
                selectCode=5;
            case R.id.rad6:
                selectCode=6;
            case R.id.rad7:
                selectCode=7;
            case R.id.rad8:
                selectCode=8;
        }

    }
}
