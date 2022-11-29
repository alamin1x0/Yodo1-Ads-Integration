package com.developeralamin.yodo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.yodo1.mas.Yodo1Mas;
import com.yodo1.mas.error.Yodo1MasError;
import com.yodo1.mas.reward.Yodo1MasRewardAd;
import com.yodo1.mas.reward.Yodo1MasRewardAdListener;

public class RewaredActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewared);

        Yodo1Mas.getInstance().initMas(this, getString(R.string.app_key), new Yodo1Mas.InitListener() {
            @Override
            public void onMasInitSuccessful() {
                Toast.makeText(RewaredActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMasInitFailed(@NonNull Yodo1MasError error) {
            }
        });

        Yodo1MasRewardAd.getInstance().setAdListener(new Yodo1MasRewardAdListener() {

            @Override
            public void onRewardAdLoaded(Yodo1MasRewardAd ad) {
                showRewarded();
            }

            @Override
            public void onRewardAdFailedToLoad(Yodo1MasRewardAd ad, @NonNull Yodo1MasError error) {

            }

            @Override
            public void onRewardAdOpened(Yodo1MasRewardAd ad) {

            }

            @Override
            public void onRewardAdFailedToOpen(Yodo1MasRewardAd ad, @NonNull Yodo1MasError error) {
                ad.loadAd(RewaredActivity.this);
            }

            @Override
            public void onRewardAdClosed(Yodo1MasRewardAd ad) {
                ad.loadAd(RewaredActivity.this);
            }

            @Override
            public void onRewardAdEarned(Yodo1MasRewardAd ad) {

            }
        });

        Yodo1MasRewardAd.getInstance().loadAd(RewaredActivity.this);
    }

    public void showRewarded(){
        if (Yodo1Mas.getInstance().isRewardedAdLoaded()){
            Yodo1Mas.getInstance().showRewardedAd(RewaredActivity.this);
        }

    }
}