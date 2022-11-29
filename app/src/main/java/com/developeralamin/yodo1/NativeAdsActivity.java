package com.developeralamin.yodo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.yodo1.mas.Yodo1Mas;
import com.yodo1.mas.error.Yodo1MasError;
import com.yodo1.mas.nativeads.Yodo1MasNativeAdListener;
import com.yodo1.mas.nativeads.Yodo1MasNativeAdView;

public class NativeAdsActivity extends AppCompatActivity {

    private Yodo1MasNativeAdView nativeAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_ads);

        nativeAdView = findViewById(R.id.yodo1_mas_native);
        nativeAdView.loadAd();


        nativeAdView.setAdListener(new Yodo1MasNativeAdListener() {
            @Override public void onNativeAdLoaded(Yodo1MasNativeAdView nativeAdView) {
                // Code to be executed when an ad finishes loading.
            }
            @Override public void onNativeAdFailedToLoad(Yodo1MasNativeAdView nativeAdView, @NonNull Yodo1MasError error) {
                // Code to be executed when an ad request fails.
            }
        });

    }
}