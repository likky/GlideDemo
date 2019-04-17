package com.lyd.glidedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class GlideV3UseActivity extends AppCompatActivity {

    private ImageView imgDefault;
    private ImageView imgCircle;
    private ImageView imgRound;
    private ImageView imgBlur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_use);
        initView();
        initGlideUse();
    }


    private void initView() {
        imgDefault = findViewById(R.id.img_default);
        imgCircle = findViewById(R.id.img_circle);
        imgRound = findViewById(R.id.img_round);
        imgBlur = findViewById(R.id.img_blur);
    }

    private void initGlideUse() {
        String url = "http://www.hubei.gov.cn/mlhb/lyms/xyjq/201205/W020120531559128275377.jpg";
        //GlideImageUtils.getInstance().loadImage(App.getMyApplicationContext(), R.drawable.default_head, url, imgDefault);

        //GlideImageUtils.getInstance().loadCircleImage(App.getMyApplicationContext(), R.drawable.default_head_circle, url, imgCircle);

        //GlideImageUtils.getInstance().loadRoundImage(App.getMyApplicationContext(), R.drawable.default_head_round, url, imgRound);

        //GlideImageUtils.getInstance().loadBlurImage(App.getMyApplicationContext(), R.drawable.default_img, url, imgBlur);

    }
}
