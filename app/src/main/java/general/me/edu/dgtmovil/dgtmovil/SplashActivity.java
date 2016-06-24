package general.me.edu.dgtmovil.dgtmovil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import general.me.edu.dgtmovil.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(1500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                   Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);

                }
            }
        };
        timerThread.start();
    }
    }

