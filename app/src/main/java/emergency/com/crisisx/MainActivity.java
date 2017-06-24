package emergency.com.crisisx;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_user);
        drawable.mutate().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        //DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_OVER);

//        userName = (EditText) findViewById(R.id.editUsername);
//        userName.setCompoundDrawables(drawable, null, null, null);
//
//        drawable = ContextCompat.getDrawable(this, R.drawable.ic_password);
//        drawable.mutate().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
//        //DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_OVER);
//
//        password = (EditText) findViewById(R.id.editPassword);
//        password.setCompoundDrawables(drawable, null, null, null);

        (findViewById(R.id.button_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, IntroActivity.class));
                finish();

                overridePendingTransition(R.anim.slide_out_rev, R.anim.slide_in_rev);
            }
        });
    }
}
