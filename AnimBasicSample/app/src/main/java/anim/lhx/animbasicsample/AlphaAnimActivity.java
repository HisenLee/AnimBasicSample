package anim.lhx.animbasicsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class AlphaAnimActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_anim);

        imageView = findViewById(R.id.image_view);
        imageView.setImageDrawable(getResources().getDrawable(R.mipmap.bg1));

        Animation alphaAnimation = new AlphaAnimation(1,0);
        alphaAnimation.setDuration(3000);
        Interpolator interpolator = new LinearInterpolator(); // 匀速插值器
        alphaAnimation.setInterpolator(interpolator);
        imageView.setAnimation(alphaAnimation);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setImageDrawable(getResources().getDrawable(R.mipmap.bg2));
                Animation alphaAnimation2 = new AlphaAnimation(0,1);
                alphaAnimation2.setDuration(3000);
                imageView.setAnimation(alphaAnimation2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
