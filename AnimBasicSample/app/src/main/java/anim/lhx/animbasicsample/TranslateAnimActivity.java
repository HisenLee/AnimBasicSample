package anim.lhx.animbasicsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class TranslateAnimActivity extends AppCompatActivity {

    private TextView tvAd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_anim);

        tvAd1 = findViewById(R.id.ad1);

        AnimationSet setAnimation = new AnimationSet(true);
        setAnimation.setFillAfter(true);
        // 沿Y轴方向移动
        Animation translateAnim = new TranslateAnimation(0,0,0,500);
        translateAnim.setDuration(5000);
        translateAnim.setFillAfter(true);
        Interpolator interpolator = new LinearInterpolator(); // 匀速插值器
        translateAnim.setInterpolator(interpolator);

        // 移动的过程中放大
        Animation scaleAnim = new ScaleAnimation(0,2,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.2f);
        scaleAnim.setDuration(5000);
        scaleAnim.setFillAfter(true);
        scaleAnim.setInterpolator(interpolator);

        setAnimation.addAnimation(translateAnim);
        setAnimation.addAnimation(scaleAnim);
        tvAd1.startAnimation(setAnimation);

    }
}
