package vn.edu.usth.weather.ui.theme;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;

import vn.edu.usth.weather.R;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "WeatherActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("WeatherActivity", "onCreate");
        setContentView(R.layout.activity_weather);

        //set ActionBar color
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#3F51B5"));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);

        /*
        ForecastFragment forecastFragment = new ForecastFragment();

        getSupportFragmentManager().beginTransaction().add(
                R.id.bglayout, forecastFragment
        ).commit();

        WeatherFragment wf = new WeatherFragment();

        getSupportFragmentManager().beginTransaction().add(
                R.id.bglayout, wf
        ).commit();
        */

    }




    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}