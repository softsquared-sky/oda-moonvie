package soft.pro.oda.src.Signup;

import soft.pro.oda.src.Signup.interfaces.SignupActivityView;
import soft.pro.oda.src.Signup.interfaces.SignupRetrofitInterface;

public class SignupService {
    private final SignupActivityView mSignupActivityView;
    private String id;
    private String pw;
    private String address;
    private int select;
    SignupService(final SignupActivityView signupActivityView,String id)
    {
        this.mSignupActivityView=signupActivityView;
        this.id=id;
    }
    SignupService(final SignupActivityView signupActivityView,String id,String pw,int select,String address)
    {
        this.mSignupActivityView=signupActivityView;
        this.id=id;
        this.pw=pw;
        this.select=select;
    }
    void idTest(){
        final SignupRetrofitInterface signupRetrofitInterface;

    }

}
