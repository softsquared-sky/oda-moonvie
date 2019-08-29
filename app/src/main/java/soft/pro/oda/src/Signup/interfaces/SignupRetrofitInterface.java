package soft.pro.oda.src.Signup.interfaces;

import kotlin.random.Random;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import soft.pro.oda.src.main.models.CheckResponse;
import soft.pro.oda.src.main.models.DefaultResponse;
import soft.pro.oda.src.main.models.UserResponse;

public interface SignupRetrofitInterface {

@GET("/id")
    Call<CheckResponse> idTest(@Query("id") String id);

@POST("/user")
    Call<UserResponse> userTest(@Body RequestBody params);
}
