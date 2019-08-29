package soft.pro.oda.src.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import soft.pro.oda.R;
import soft.pro.oda.src.Login.LoginActivity;
import soft.pro.oda.src.main.MainActivity;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Handler hd=new Handler();
        hd.postDelayed(new splashHandler(),3000);
    }

    private class splashHandler implements Runnable {
        @Override
        public void run() {
            Intent intent=new Intent(getApplication(), LoginActivity.class);
            startActivity(intent);
            SplashActivity.this.finish();
        }
    }

    @Override
    public void onBackPressed() {

    }
}
