    package vn.edu.usth.weather.ui.theme;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.ActionBar;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentActivity;
    import androidx.viewpager2.adapter.FragmentStateAdapter;
    import androidx.viewpager2.widget.ViewPager2;

    import android.annotation.SuppressLint;
    import android.graphics.Color;
    import android.graphics.drawable.ColorDrawable;
    import android.os.Bundle;
    import android.text.Html;
    import android.util.Log;

    import com.google.android.material.tabs.TabLayout;
    import com.google.android.material.tabs.TabLayoutMediator;

    import vn.edu.usth.weather.R;

    public class WeatherActivity extends AppCompatActivity {
        private static final String TAG = "WeatherActivity";
        private ViewPager2 viewPager;
        private FragmentStateAdapter pagerAdapter;

        @SuppressLint("MissingInflatedId")
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

            viewPager = findViewById(R.id.viewPager);
            pagerAdapter = new ViewPagerAdapter(this);
            viewPager.setAdapter(pagerAdapter);


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

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
            new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
                switch (position) {
                    case 0:
                        tab.setText("HANOI, VIETNAM");
                        break;
                    case 1:
                        tab.setText("PARIS, FRANCE");
                        break;
                    case 2:
                        tab.setText("TOULOUSE, FRANCE");
                        break;
                }
            }).attach();
        }


        public class ViewPagerAdapter extends FragmentStateAdapter {
            private final int Page_count = 3;

            public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
                super(fragmentActivity);
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return new WeatherAndForecastFragment();
            }

            @Override
            public int getItemCount() {
                return Page_count;
            }
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