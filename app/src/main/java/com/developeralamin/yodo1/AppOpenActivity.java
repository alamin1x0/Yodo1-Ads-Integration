package com.developeralamin.yodo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yodo1.mas.appopenad.Yodo1MasAppOpenAd;
import com.yodo1.mas.appopenad.Yodo1MasAppOpenAdListener;
import com.yodo1.mas.error.Yodo1MasError;

public class AppOpenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_open);

        Yodo1MasAppOpenAd appOpenAd = Yodo1MasAppOpenAd.getInstance();

        appOpenAd.loadAd(AppOpenActivity.this);

        appOpenAd.setAdListener(new Yodo1MasAppOpenAdListener() {
            @Override
            public void onAppOpenAdLoaded(Yodo1MasAppOpenAd ad) {
                // Code to be executed when an ad finishes loading.
                ad.showAd(AppOpenActivity.this);
            }

            @Override
            public void onAppOpenAdFailedToLoad(Yodo1MasAppOpenAd ad, @NonNull Yodo1MasError error) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAppOpenAdOpened(Yodo1MasAppOpenAd ad) {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAppOpenAdFailedToOpen(Yodo1MasAppOpenAd ad, @NonNull Yodo1MasError error) {
                // Code to be executed when an ad open fails.
            }

            @Override
            public void onAppOpenAdClosed(Yodo1MasAppOpenAd ad) {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
    }
}