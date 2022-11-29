package com.developeralamin.yodo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yodo1.mas.Yodo1Mas;
import com.yodo1.mas.error.Yodo1MasError;
import com.yodo1.mas.helper.model.Yodo1MasAdBuildConfig;

public class MainActivity extends AppCompatActivity {

    private Button bannerAds,InterstialAds,RewaredAds,NativeAds,appOpen;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Yodo1MasAdBuildConfig config = new Yodo1MasAdBuildConfig.Builder().enableUserPrivacyDialog(true).build();
        Yodo1Mas.getInstance().setAdBuildConfig(config);


        bannerAds = findViewById(R.id.bannerAds);
        InterstialAds = findViewById(R.id.InterstialAds);
        RewaredAds = findViewById(R.id.RewaredAds);
        NativeAds = findViewById(R.id.NativeAds);
        appOpen = findViewById(R.id.appOpen);

        Yodo1Mas.getInstance().initMas(this, getString(R.string.app_key), new Yodo1Mas.InitListener() {
            @Override
            public void onMasInitSuccessful() {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMasInitFailed(@NonNull Yodo1MasError error) {
            }
        });


        bannerAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BannerActivity.class));
            }
        });

        InterstialAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InterstailActivity.class));
            }
        });

        RewaredAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RewaredActivity.class));
            }
        });

        NativeAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NativeAdsActivity.class));
            }
        });
        appOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AppOpenActivity.class));
            }
        });
    }
}