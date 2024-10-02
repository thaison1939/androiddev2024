    package vn.edu.usth.weather.ui.theme;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.ActionBar;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentActivity;
    import androidx.viewpager2.adapter.FragmentStateAdapter;
    import androidx.viewpager2.widget.ViewPager2;
    import androidx.appcompat.widget.Toolbar;
    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.graphics.Color;
    import android.graphics.drawable.ColorDrawable;
    import android.os.Bundle;
    import android.util.Log;
    import android.widget.Toast;

    import com.google.android.material.tabs.TabLayout;
    import com.google.android.material.tabs.TabLayoutMediator;

    import vn.edu.usth.weather.R;

    import android.media.MediaPlayer;

    public class WeatherActivity extends AppCompatActivity {
        private static final String TAG = "WeatherActivity";
        private ViewPager2 viewPager;
        private FragmentStateAdapter pagerAdapter;

        MediaPlayer mp;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.i("WeatherActivity", "onCreate");
            setContentView(R.layout.activity_weather);

            viewPager = findViewById(R.id.viewPager);
            pagerAdapter = new ViewPagerAdapter(this);
            viewPager.setAdapter(pagerAdapter);

            mp = MediaPlayer.create(this, R.raw.ringring);
            mp.setLooping(true);
            mp.start();

            initToolBar();

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });
            t.start();




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
        private void initToolBar() {
            Toolbar toolbar = findViewById(R.id.weather_menu);
            toolbar.inflateMenu(R.menu.menu_tool_bar);
            toolbar.setTitle(R.string.app_name);
            toolbar.setOnMenuItemClickListener(item -> {
                int itemMenuId =item.getItemId();
                if(itemMenuId == R.drawable.ic_refresh_24){
                    Toast.makeText(this,"Refreshing process...",Toast.LENGTH_SHORT).show();
                    new Thread(() -> {
                        try {
                            Thread.sleep(3000);
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(() -> Toast.makeText(this, "Refresh complete!", Toast.LENGTH_SHORT).show());
                    }).start();
                    return true;
                } else if (itemMenuId == R.id.ic_more) {
                    Intent intent = new Intent(this,PrefActivity.class);
                    startActivity(intent);
                    return true;
                }else{
                    Toast.makeText(this,"Not found menu item",Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
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