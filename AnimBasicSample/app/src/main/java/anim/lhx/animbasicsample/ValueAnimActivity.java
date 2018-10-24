package anim.lhx.animbasicsample;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class ValueAnimActivity extends AppCompatActivity {

    private TextView textViewSign, textViewAmount, textViewChangeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_anim);

        textViewSign = findViewById(R.id.textview_sign);
        textViewAmount = findViewById(R.id.textview_amount);
        textViewChangeColor = findViewById(R.id.textview_color);

        // 实现旋转和自增的效果
        ValueAnimator amountAnimator = ValueAnimator.ofInt(0, 3600);
        amountAnimator.setDuration(1000 * 9);
        amountAnimator.setInterpolator(new LinearInterpolator());// 匀速率变化
        amountAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                // ValueAnimator会自动生成数值序列，再把变化中的数值序列作用于控件textViewAmount，和textViewSign来实现动画
                int value = (int)valueAnimator.getAnimatedValue();
                textViewAmount.setText(String.valueOf(value)); // 实现金额自增
                textViewSign.setRotationX(value); // 沿着X轴方向旋转
            }
        });
        amountAnimator.start();
        // 实现颜色自动过渡转变的效果
        ValueAnimator colorAnimator = ValueAnimator.ofInt(0xfff10f0f,0xfff10fbf,0xff740ff1,0xff2f0ff1, 0xff0f94f1,0xff0ff1af,0xff14f10f,0xffeaf804,0xfff92a0f);
        colorAnimator.setDuration(1000 * 9);
        colorAnimator.setInterpolator(new LinearInterpolator());// 匀速率变化
        colorAnimator.setEvaluator(new ArgbEvaluator()); // 色值过渡转换器, 就是如丝般顺滑， 如果不设置转换器的话变化会太突兀
        colorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value = (int)valueAnimator.getAnimatedValue();
                textViewChangeColor.setText("Changing");
                textViewChangeColor.setTextColor(value);
            }
        });
        colorAnimator.start();

    }
}
