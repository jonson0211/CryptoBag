package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView image, searchIcon;
    private TextView coinAbbv, coinField, value, valueField, marketCapField, marketCap, changeDay, changeDayField,
                    changeWeek, changeWeekField, changeOne, changeOneField, volume, volumeField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        System.out.println("HI");
        Intent intent = getIntent();
        String str = intent.getStringExtra("coinName");
        System.out.println(str);
        final Coin currentCoin = Coin.getCoinByName(str);

         image = (ImageView) findViewById(R.id.image);
        searchIcon = (ImageView) findViewById(R.id.searchIcon);
         coinField = (TextView) findViewById(R.id.coinField);
         coinAbbv = (TextView)findViewById(R.id.coinAbbv);
         changeOne = (TextView)findViewById(R.id.changeOne);
         changeOneField = (TextView)findViewById(R.id.changeOneField);
         value = (TextView)findViewById(R.id.value);
        valueField = (TextView)findViewById(R.id.valueField);
        marketCap = (TextView)findViewById(R.id.marketCap);
        marketCapField = (TextView)findViewById(R.id.marketCapField);
        changeDay = (TextView)findViewById(R.id.changeDay);
        changeDayField = (TextView)findViewById(R.id.changeDayField);
        changeWeek = (TextView)findViewById(R.id.changeWeek);
        changeWeekField = (TextView)findViewById(R.id.changeWeekField);
        volume = (TextView)findViewById(R.id.volume);
        volumeField = (TextView)findViewById(R.id.volumeField);

        coinField.setText(currentCoin.getName());
        coinAbbv.setText(currentCoin.getSymbol());
        changeOneField.setText(String.valueOf(currentCoin.getChange1h()));
        valueField.setText(String.valueOf(currentCoin.getValue()));
        marketCapField.setText(String.valueOf(currentCoin.getMarketcap()));
        changeWeekField.setText(String.valueOf(currentCoin.getChange7d()));
        volumeField.setText(String.valueOf(currentCoin.getVolume()));
        changeDayField.setText(String.valueOf(currentCoin.getChange24h()));

    }

}
