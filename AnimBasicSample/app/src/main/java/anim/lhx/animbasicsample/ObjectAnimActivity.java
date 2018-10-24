package anim.lhx.animbasicsample;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class ObjectAnimActivity extends AppCompatActivity {

    private ImageView mImageView1, mImageView2, mImageView3, mImageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);

        mImageView1 = findViewById(R.id.iv_test1);
        mImageView1.setImageDrawable(getResources().getDrawable(R.mipmap.refresh));
        mImageView2 = findViewById(R.id.iv_test2);
        mImageView2.setImageDrawable(getResources().getDrawable(R.mipmap.refresh));
        mImageView3 = findViewById(R.id.iv_test3);
        mImageView3.setImageDrawable(getResources().getDrawable(R.mipmap.refresh));
        mImageView4 = findViewById(R.id.iv_test4);
        mImageView4.setImageDrawable(getResources().getDrawable(R.mipmap.refresh));

        // translation
        ObjectAnimator
                .ofFloat(mImageView1, "translationX", 0.0f, -180.0f, 0.0f, 180.0f, 0.0f, -90.0f, 0.0f, 90.0f, 0.0f)
                .setDuration(1000 * 10)
                .start();

        // rotationX
        ObjectAnimator
                .ofFloat(mImageView2, "rotation", 0.0f, 3600.0f)
                .setDuration(1000 * 10)
                .start();

        // alpha
        ObjectAnimator
                .ofFloat(mImageView3, "alpha", 1.0f, 0.0f, 1.0f)
                .setDuration(1000 * 10)
                .start();

        // scale
        AnimatorSet animSet = new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mImageView4, "scaleX",  1.0f, 2.0f, 1.0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mImageView4, "scaleY",  1.0f, 2.0f, 1.0f);
        animSet.setDuration(1000 * 10);
        animSet.setInterpolator(new LinearInterpolator());
        animSet.play(scaleX).with(scaleY); //同时开始
        animSet.start();

    }
}
