package emergency.com.crisisx;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.google.firebase.FirebaseApp;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListener;

import java.util.List;

import emergency.com.crisisx.fragments.MainMapFragment;

/**
 * Created by Arjun on 22-Mar-2017 for CrisisX.
 */

public class MainMapActivity extends AppCompatActivity {

    RecyclerView recyclerEmergencies;

    BoomMenuButton bmb;
    List<String> emergencyList;

    //FloatingActionButton fab_settings;
//    Animator animator;
//    Animation animation;
//
//    View revealView;
//
//    TranslateAnimation translateAnimationUp, translateAnimationDown;
    AlphaAnimation alphaAnimationForward, alphaAnimationReverse;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        final MainMapFragment fragment = new MainMapFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.map, fragment).commit();

        bmb = (BoomMenuButton) findViewById(R.id.bmb);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_6);
        bmb.addBuilder(new HamButton.Builder()
                //.normalImageRes(R.drawable.ambulance)
                .textSize(20)
                .normalColorRes(R.color.colorBlue)
                .normalText("Medical")
                .buttonHeight(240)
                .normalImageDrawable(getResources().getDrawable(R.drawable.ic_local_hospital_white_24dp))
                .subNormalText("Any kind of medical emergencies.")
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(MainMapActivity.this, ReportEmergency.class).putExtra("type", 0));
                                //bmb.startAnimation(alphaAnimationForward);
                            }
                        }, 30);
                    }
                }));

        bmb.addBuilder(new HamButton.Builder()
                //.normalImageRes(R.drawable.police_car)
                .textSize(20)
                .normalColorRes(R.color.colorAccent)
                .normalText("Police")
                .normalImageDrawable(getResources().getDrawable(R.mipmap.ic_navigate_next_white_24dp))
                .buttonHeight(240)
                .subNormalText("Any kind of emergency related to crime."));

        bmb.addBuilder(new HamButton.Builder()
                .normalColorRes(R.color.default_bmb_normal_color)
                .textSize(20)
                .buttonHeight(240)
                .normalImageDrawable(getResources().getDrawable(R.mipmap.ic_add_alert_black_24dp))
                .normalText("Active Emergencies")
                .subNormalText("See the emergencies you have reported and are active."));

        bmb.addBuilder(new HamButton.Builder()
                //.normalImageRes(R.drawable.fire_station)
                .normalColorRes(R.color.colorGreen)
                .textSize(20)
                .buttonHeight(240)
                .normalText("Fire")
                .normalImageDrawable(getResources().getDrawable(R.drawable.fire_station))
                .subNormalText("Any emergency related to fire.."));

        bmb.addBuilder(new HamButton.Builder()
                //.normalImageRes(R.drawable.radiation_ico)
                .normalColorRes(R.color.colorSaffron)
                .textSize(20)
                .buttonHeight(240)
                .normalText("Radioactive")
                .normalImageDrawable(getResources().getDrawable(R.drawable.radiation))
                .subNormalText("Emergency related to radioactive wastes or accidents.."));

        bmb.addBuilder(new HamButton.Builder()
                //.normalImageRes(R.drawable.radiation_ico)
                .normalColorRes(R.color.colorHint)
                .textSize(20)
                .buttonHeight(240)
                .normalText("Settings")
                .subNormalText("Change the default settings of the app.."));


        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 900);
//        fab_emergencies = (FloatingActionButton) findViewById(R.id.fab_reveal_emergencies);
        //fab_settings = (FloatingActionButton) findViewById(R.id.fab_settings);

//        translateAnimationUp = new TranslateAnimation((fab_settings.getLeft() + fab_settings.getRight()) / 2, (fab_settings.getLeft() + fab_settings.getRight()) / 2, (fab_settings.getTop() + fab_settings.getBottom()) / 2, ((fab_settings.getLeft() + fab_settings.getRight()) / 2) - 400);
//        translateAnimationUp.setFillAfter(true);
//        translateAnimationUp.setDuration(600);
//
//        translateAnimationDown = new TranslateAnimation((fab_settings.getLeft() + fab_settings.getRight()) / 2, (fab_settings.getLeft() + fab_settings.getRight()) / 2, (fab_settings.getTop() + fab_settings.getBottom()) / 2 - 400, ((fab_settings.getLeft() + fab_settings.getRight()) / 2));
//        translateAnimationDown.setFillAfter(true);
//        translateAnimationDown.setDuration(600);
//
        alphaAnimationReverse = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimationReverse.setDuration(350);

        alphaAnimationForward = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimationForward.setDuration(350);

        alphaAnimationForward.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bmb.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        alphaAnimationReverse.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bmb.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //fab_settings.setVisibility(View.GONE);
        FirebaseApp.initializeApp(this);
        bmb.setOnBoomListener(new OnBoomListener() {
            @Override
            public void onClicked(int index, BoomButton boomButton) {

            }

            @Override
            public void onBackgroundClick() {

            }

            @Override
            public void onBoomWillHide() {
                //fab_settings.startAnimation(alphaAnimationForward);
            }

            @Override
            public void onBoomDidHide() {
                //fab_settings.setVisibility(View.GONE);
            }

            @Override
            public void onBoomWillShow() {

            }

            @Override
            public void onBoomDidShow() {
                //fab_settings.setVisibility(View.VISIBLE);
                //fab_settings.startAnimation(alphaAnimationReverse);
            }
        });

//        fab_settings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String token = FirebaseInstanceId.getInstance().getToken();
//
//                // Log and toast
//                String msg = "Token: " + token;
//                Log.d("Token", msg);
//                Toast.makeText(MainMapActivity.this, msg, Toast.LENGTH_SHORT).show();
//            }
//        });

//        fab_emergencies.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                revealView.setVisibility(View.VISIBLE);
//
////                cx = (revealView.getLeft() + revealView.getRight()) / 2;
////                cy = (revealView.getTop() + revealView.getBottom()/2) / 2;
//
//                cx = revealView.getRight();
//                cy = revealView.getBottom()/2;
//
////        dx = Math.max(cx, recyclerEmergencies.getWidth() - cx);
////        dy = Math.max(cy, recyclerEmergencies.getHeight() - cy);
//
//                r = (float) Math.hypot(revealView.getWidth(), revealView.getHeight());
//
////                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
////                    animator = ViewAnimationUtils.createCircularReveal(revealView, cx, cy, 0, r);
////                } else {
//                    animator = io.codetail.animation.ViewAnimationUtils.createCircularReveal(revealView, cx, cy, 0, r);
//               // }
//
////                recyclerEmergencies.setVisibility(View.VISIBLE);
//                animator.setInterpolator(new AccelerateDecelerateInterpolator());
//                animator.setDuration(600);
//
//                animator.addListener(new Animator.AnimatorListener() {
//                    @Override
//                    public void onAnimationStart(Animator animator) {
//                        animation = AnimationUtils.loadAnimation(MainMapActivity.this, R.anim.alpha_anim);
//                        fab_settings.startAnimation(translateAnimationUp);
//                        fab_emergencies.startAnimation(animation);
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animator) {
//                        recyclerEmergencies.setVisibility(View.VISIBLE);
//                        revealView.startAnimation(alphaAnimationForward);
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animator) {
//
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animator animator) {
//
//                    }
//                });
//                animator.start();
//              }
//        });
    }

    public void onBackPressed() {
//        if(recyclerEmergencies.getVisibility() == View.VISIBLE) {
//            revealView.startAnimation(alphaAnimationReverse);
//            alphaAnimationReverse.setAnimationListener(new Animation.AnimationListener() {
//                @Override
//                public void onAnimationStart(Animation animation) {
//
//                }
//
//                @Override
//                public void onAnimationEnd(Animation animation) {
//                    final Animator animator;
////            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
////                animator = ViewAnimationUtils.createCircularReveal(recyclerEmergencies, cx, cy, r, 0);
////            } else {
//                    animator = io.codetail.animation.ViewAnimationUtils.createCircularReveal(revealView, cx, cy, r, 0);
////            }
//
//                    animator.setInterpolator(new AccelerateDecelerateInterpolator());
//                    animator.setDuration(600);
//                    animator.start();
//                    recyclerEmergencies.setVisibility(View.GONE);
//                    fab_settings.startAnimation(translateAnimationDown);
//
//                    animator.addListener(new Animator.AnimatorListener() {
//                        @Override
//                        public void onAnimationStart(Animator animator) {
//
//                        }
//
//                        @Override
//                        public void onAnimationEnd(Animator animator) {
//                            alphaAnimationReverse.setAnimationListener(null);
//                            revealView.clearAnimation();
//                            fab_emergencies.startAnimation(alphaAnimationReverse);
//                            revealView.setVisibility(View.GONE);
//                        }
//
//                        @Override
//                        public void onAnimationCancel(Animator animator) {
//
//                        }
//
//                        @Override
//                        public void onAnimationRepeat(Animator animator) {
//
//                        }
//                    });
//                }
//
//                @Override
//                public void onAnimationRepeat(Animation animation) {
//
//                }
//            });
//        }

        if(getSupportFragmentManager().getBackStackEntryCount() >= 1) {
            getSupportFragmentManager().popBackStack();
            bmb.startAnimation(alphaAnimationReverse);
        }
    }
}
