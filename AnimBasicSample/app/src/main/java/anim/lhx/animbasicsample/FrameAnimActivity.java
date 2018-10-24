package anim.lhx.animbasicsample;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FrameAnimActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);

        imageView = findViewById(R.id.imageview);

        AnimationDrawable animationDrawable = new AnimationDrawable();
        for(int i=1; i<35; i++) {
            int id = getResources().getIdentifier("f"+i, "mipmap", getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            animationDrawable.addFrame(drawable, 100);
        }
        animationDrawable.setOneShot(true);
        imageView.setImageDrawable(animationDrawable);

        animationDrawable.stop(); // 在start必须先stop,否则在第一次动画之后会停到最后一帧
        animationDrawable.start();
    }
}
