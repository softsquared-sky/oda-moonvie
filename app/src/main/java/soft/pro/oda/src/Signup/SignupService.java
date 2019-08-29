package soft.pro.oda.src.Signup;

import android.util.Log;

import org.json.JSONObject;

import kotlin.Result;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import soft.pro.oda.src.Signup.interfaces.SignupActivityView;
import soft.pro.oda.src.Signup.interfaces.SignupRetrofitInterface;
import soft.pro.oda.src.main.models.CheckResponse;
import soft.pro.oda.src.main.models.DefaultResponse;
import soft.pro.oda.src.main.models.UserResponse;

import static soft.pro.oda.src.ApplicationClass.MEDIA_TYPE_JSON;
import static soft.pro.oda.src.ApplicationClass.TAG;
import static soft.pro.oda.src.ApplicationClass.getRetrofit;

public class SignupService {
    private final SignupActivityView mSignupActivityView;
    private String id;
    private String pw;
    private String address;
    private int select;
    public JSONObject jsonObject;
    int FAIL=-100;

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
        this.address=address;
    }


    void idTest(){//중복api
  final SignupRetrofitInterface signupRetrofitInterface=getRetrofit().create(SignupRetrofitInterface.class);

  Log.d(TAG,"id: "+id);

  signupRetrofitInterface.idTest(id).enqueue(new Callback<CheckResponse>() {
      @Override
      public void onResponse(Call<CheckResponse> call, Response<CheckResponse> response) {

          final CheckResponse checkResponse=response.body();
          if(checkResponse==null)//연결 실패한거
          {
              mSignupActivityView.validateFailure(null);
              Log.d(TAG,"중복확인 실패");
              return;
          }
          Log.d(TAG,"중복확인 성공");
          mSignupActivityView.validateSuccess(checkResponse.getCode(),checkResponse.getMessage());
      }

      @Override//중복확인 실패
      public void onFailure(Call<CheckResponse> call, Throwable t) {
          mSignupActivityView.validateFailure(null);
      }
  });


    }
    void userTest()
    {
        try {
            jsonObject = new JSONObject();
            jsonObject.put("id", this.id);
            jsonObject.put("pw",this.pw);
            jsonObject.put("type",this.select);
            jsonObject.put("address",this.address);
        }catch(Exception e)
        {

        }
        final SignupRetrofitInterface signupRetrofitInterface=getRetrofit().create(SignupRetrofitInterface.class);
        signupRetrofitInterface.userTest(RequestBody.create(MEDIA_TYPE_JSON,jsonObject.toString())).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                final UserResponse userResponse=response.body();

                if(userResponse==null)
                {
                    mSignupActivityView.userFailure(userResponse.getCode(),null);
                    Log.d(TAG,"실패");
                }
                mSignupActivityView.userSuccess(userResponse.getCode(),userResponse.getMessage());

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

                mSignupActivityView.userFailure(FAIL,null);
            }
        });
    }

}
