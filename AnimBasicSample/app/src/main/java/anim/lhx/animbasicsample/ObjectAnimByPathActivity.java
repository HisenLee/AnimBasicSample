package anim.lhx.animbasicsample;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class ObjectAnimByPathActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button btnTriangle, btnRectangle, btnCircle, btnSine;

    // originalX, originalY
    private float p0x, p0y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim_by_path);

        imageView = findViewById(R.id.imageview_test);
        btnTriangle = findViewById(R.id.triangle);
        btnTriangle.setOnClickListener(onClickListener);
        btnRectangle = findViewById(R.id.rectangle);
        btnRectangle.setOnClickListener(onClickListener);
        btnCircle = findViewById(R.id.circle);
        btnCircle.setOnClickListener(onClickListener);
        btnSine = findViewById(R.id.sine);
        btnSine.setOnClickListener(onClickListener);
    }

    private void startAnimator(Path path) {
        ObjectAnimator objectAnimator = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            objectAnimator = ObjectAnimator.ofFloat(imageView, imageView.X, imageView.Y, path);
        }
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(1000 * 5);
        objectAnimator.start();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        p0x = imageView.getX();
        p0y = imageView.getY();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.equals(btnTriangle)) {
                startAnimator(trianglePath());
            } else if(view.equals(btnRectangle)) {
                startAnimator(rectanglePath());
            } else if(view.equals(btnCircle)) {
                startAnimator(circlePath());
            } else if(view.equals(btnSine)) {
                startAnimator(sinePath());
            }
        }
    };

    private Path trianglePath() {
        Path path = new Path();
        path.moveTo(p0x, p0y);
        path.lineTo(p0x + 200, p0y);
        path.lineTo(p0x, p0y+200);
        path.lineTo(p0x, p0y);
        return path;
    }

    private Path rectanglePath() {
        Path path = new Path();
        path.moveTo(p0x, p0y);
        path.lineTo(p0x + 200, p0y);
        path.lineTo(p0x+200, p0y+200);
        path.lineTo(p0x, p0y+200);
        path.lineTo(p0x, p0y);
        return path;
    }

    private Path circlePath() {
        Path path = new Path();
        path.moveTo(p0x, p0y);
        path.addCircle(p0x, p0y, 200, Path.Direction.CW);
        return path;
    }

    /**
     * Sine: y=Asin(ωx+φ)+k
     *       A是振幅
     *       ω是角速度，控制正弦周期(单位弧度内震动的次数)。
     *       φ初相，x=0时的相位,反映在坐标系上则为图像的左右移动。
     *       K 偏距，反映在坐标系上则为图像的上移或下移
     *       (ωx+φ)相位(相角，单位为度)，反映变量y所处的状态。
     *
     * 角度D和弧长L 的关系为（角度与圆周的比重==弧长与周长的比重)
     *       D/360 = L / ( 2 * Math.PI * r)
     *
     * 由角度和弧长的关系，推出弧长的计算方法
     *      L = (D/360) * ( 2 * Math.PI * r)
     *        =  D / 180 * Math.PI * r
     *        =  D * Math.PI * r / 180
     *
     *  由于 半径r 记作单位长度，不影响正弦曲线的轨迹，故可以忽略参数r
     *  所以上述的弧长公式最终为
     *      L = D * Math.PI / 180
     *
     *  而此处的角度D 其实就是正弦曲线中的 (ωx+φ)的值，也就是相角的值。
     *  因为程序中需要根据弧长来计算动画轨迹，不能根据角度绘制轨迹，
     *  所以需要把正弦公式中的角度计算法方式转化为弧度计算方式。
     *
     *  如下正弦的角度标准公式 y=Asin(ωx+φ)+k
     *  转化为弧度计算标准公式 y=Asin((ωx+φ) * Math.PI / 180 )+k
     */
    private Path sinePath() {
        Path path = new Path();
        path.moveTo(p0x, p0y);

        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        int screenWidth = wm.getDefaultDisplay().getWidth()-imageView.getWidth();

        int a = 150; // A是振幅
        float w = 1f; // ω是角速度，控制正弦周期(单位弧度内震动的次数)。
        int φ = 0; // φ初相，x=0时的相位,反映在坐标系上则为图像的左右移动。
        float k = p0y;// K 偏距，反映在坐标系上则为图像的上移或下移, 此处设置为初始值的纵坐标即可

        int pointX, pointY;
        for (int i = 0; i < screenWidth; i++) {
            pointX = i;
            // 根据正弦公式计算纵坐标的值
            pointY = (int) (a * Math.sin((w * pointX + φ) * Math.PI / 180) + k);
            if (i == 0) {
                path.moveTo(pointX, pointY);
            }
            // 绘制二阶贝塞尔曲线，传入控制点坐标和终点坐标
            path.quadTo(pointX, pointY, pointX + 1, pointY);
        }
        return path;
    }

}
