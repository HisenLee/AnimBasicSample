package anim.lhx.animbasicsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class ScaleAnimActivity extends AppCompatActivity {

    private ImageView imageViewPlus, imageViewMinus;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_anim);

        imageViewPlus = findViewById(R.id.iv_plus);
        imageViewMinus = findViewById(R.id.iv_minus);
        textView = findViewById(R.id.text);

        imageViewPlus.setOnClickListener(onClickListener);
        imageViewMinus.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.equals(imageViewPlus)) {
                Animation scaleAnim = new ScaleAnimation(0,5,0,5,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                scaleAnim.setDuration(5000);
                scaleAnim.setFillAfter(true);
                Interpolator interpolator = new LinearInterpolator(); // 匀速插值器
                scaleAnim.setInterpolator(interpolator);
                textView.startAnimation(scaleAnim);
            } else if(view.equals(imageViewMinus)) {
                Animation scaleAnim = new ScaleAnimation(5,2,5,2,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                scaleAnim.setDuration(5000);
                scaleAnim.setFillAfter(true);
                Interpolator interpolator = new LinearInterpolator(); // 匀速插值器
                scaleAnim.setInterpolator(interpolator);
                textView.startAnimation(scaleAnim);
            }
        }
    };

}
