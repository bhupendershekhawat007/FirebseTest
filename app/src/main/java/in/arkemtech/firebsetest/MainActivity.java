package in.arkemtech.firebsetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBTN = findViewById(R.id.loginBTN);

        Button LogoutBTN = findViewById(R.id.LogoutBTN);

        Button PurchaseBTN = findViewById(R.id.PurchaseBTN);

        Button ErrorBTN = findViewById(R.id.ErrorBTN);


        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Analyse.getInstance(MainActivity.this).LoginEvent();
            }
        });

        LogoutBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Analyse.getInstance(MainActivity.this).LogoutEvent();
            }
        });


        PurchaseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Analyse.getInstance(MainActivity.this).UserProperties();
            }
        });



        ErrorBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Analyse.getInstance(MainActivity.this).ErrorEvent();
            }
        });



    }
}