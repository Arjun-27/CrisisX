package emergency.com.crisisx;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import emergency.com.crisisx.adapters.FragmentViewPagerAdapter;
import emergency.com.crisisx.views.NonSwipeableViewPager;

/**
 * Created by Arjun on 16-Mar-2017 for CrisisX.
 */

public class IntroActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

    NonSwipeableViewPager viewPager;
    public static FragmentViewPagerAdapter viewPagerAdapter;
    ArgbEvaluator argbEvaluator;

    public static Integer colors[];

    Button buttonNext, buttonBack;

    RadioGroup radioGroup;
    int position = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        viewPager = (NonSwipeableViewPager) findViewById(R.id.view_pager);
        buttonNext = (Button) findViewById(R.id.button_next);
        buttonBack = (Button) findViewById(R.id.button_back);

        colors = new Integer[]{ContextCompat.getColor(this, R.color.colorPrimary), ContextCompat.getColor(this, R.color.colorSaffron)};

        viewPagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setBackgroundColor(colors[0]);

        buttonBack.setVisibility(View.GONE);

        viewPager.addOnPageChangeListener(this);

        argbEvaluator = new ArgbEvaluator();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position < viewPagerAdapter.getCount() - 1 && !viewPagerAdapter.isForLogin()) {
                    viewPager.setCurrentItem(position + 1, true);
                } else {
                    startActivity(new Intent(IntroActivity.this, MainActivity.class));
                    finish();

                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position > 0) {
                    viewPager.setCurrentItem(position - 1, true);
                }
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        this.position = position;
        if (position < (viewPagerAdapter.getCount() - 1) && position < (colors.length - 1)) {
            viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position + 1]));
        } else {
            //viewPager.setBackgroundColor(colors[colors.length - 1]);
        }
    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            buttonBack.setVisibility(View.GONE);
            buttonNext.setVisibility(View.VISIBLE);
        } else if (position < viewPagerAdapter.getCount() - 1) {
            buttonBack.setVisibility(View.VISIBLE);
            buttonNext.setVisibility(View.VISIBLE);
        } else {
            buttonNext.setVisibility(View.GONE);
            buttonBack.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
