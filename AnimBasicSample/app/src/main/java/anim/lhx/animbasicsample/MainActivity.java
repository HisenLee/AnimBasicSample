package anim.lhx.animbasicsample;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Android Animation Demo:
 *
 * Tween Animation & Frame Animation & Property Animation
 * Tween Animation
 *      AlphaAnimation(Java); ScaleAnimation(Java); TranslateAnimation(Java); RotateAnimation(Java)
 *
 *  Frame Animation
 *
 *  Property Animation
 *      ValueAnimator, ObjectAnimation
 */
public class MainActivity extends AppCompatActivity {

    private LinearLayout mParentView;
    private List<String> mTextNames;

    private MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mParentView = findViewById(R.id.parent_view);

        mContext = MainActivity.this;
        mTextNames = new ArrayList<>();
        setData();
        initView(mTextNames);
    }

    private void setData() {
        mTextNames.add(getResources().getString(R.string.text_view1));
        mTextNames.add(getResources().getString(R.string.text_view2));
        mTextNames.add(getResources().getString(R.string.text_view3));
        mTextNames.add(getResources().getString(R.string.text_view4));
        mTextNames.add(getResources().getString(R.string.text_view5));
        mTextNames.add(getResources().getString(R.string.text_view6));
        mTextNames.add(getResources().getString(R.string.text_view7));
        mTextNames.add(getResources().getString(R.string.text_view8));
    }

    private void initView(List<String> names) {
        for (String viewName : names) {
            TextView textView = new TextView(mContext);
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            textView.setLayoutParams(textParams);
            textView.setPadding(20, 20, 20, 20);
            textView.setText(viewName);
            textView.setTag(viewName);
            textView.setOnClickListener(onClickListener);
            mParentView.addView(textView);

            LinearLayout.LayoutParams lineParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1);
            View line = new View(mContext);
            line.setLayoutParams(lineParams);
            line.setBackgroundColor(Color.RED);
            mParentView.addView(line);
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = mContext.getIntent();
            String textTag = (String)view.getTag();

            if(textTag.equals(getString(R.string.text_view1))) {  // Tween Anim Alpha
                intent.setClass(mContext, AlphaAnimActivity.class);
            } else if(textTag.equals(getString(R.string.text_view2))) { // Tween Anim Scale
                intent.setClass(mContext, ScaleAnimActivity.class);
            } else if(textTag.equals(getString(R.string.text_view3))) { // Tween Anim Translate
                intent.setClass(mContext, TranslateAnimActivity.class);
            } else if(textTag.equals(getString(R.string.text_view4))) { // Tween Anim Rotate
                intent.setClass(mContext, RotateAnimActivity.class);
            } else if(textTag.equals(getString(R.string.text_view5))) { // Frame Animation
                intent.setClass(mContext, FrameAnimActivity.class);
            } else if(textTag.equals(getString(R.string.text_view6))) { // ValueAnimator
                intent.setClass(mContext, ValueAnimActivity.class);
            } else if(textTag.equals(getString(R.string.text_view7))) { // ObjectAnimator Basic
                intent.setClass(mContext, ObjectAnimActivity.class);
            } else if(textTag.equals(getString(R.string.text_view8))) { // ObjectAnimator By Path
                intent.setClass(mContext, ObjectAnimByPathActivity.class);
            }
            MainActivity.this.startActivity(intent);
        }
    };


}
