package soft.pro.oda.src.Signup.interfaces;

import kotlin.random.Random;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import soft.pro.oda.src.main.models.DefaultResponse;

public interface SignupRetrofitInterface {

@GET("/id")
    Call<DefaultResponse> idTest();



}
