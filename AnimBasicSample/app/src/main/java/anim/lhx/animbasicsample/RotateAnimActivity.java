package anim.lhx.animbasicsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class RotateAnimActivity extends AppCompatActivity {

    private ImageView ivRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_anim);

        ivRefresh = findViewById(R.id.iv_refresh);

        Animation rotateAnimation = new RotateAnimation(0,360*30, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(1000 * 30);
        rotateAnimation.setFillAfter(true);
        Interpolator interpolator = new LinearInterpolator(); // 匀速插值器
        rotateAnimation.setInterpolator(interpolator);

        ivRefresh.startAnimation(rotateAnimation);
    }
}
