package com.lyd.glidev3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;


/**
 * 描述: 将图片转化为圆角,构造中第二个参数定义半径
 * 作者: LYD
 * 创建日期: 2019/4/15 17:18
 */
public class GlideRoundTransform extends BitmapTransformation {

    private static float radius = 0f;

    /**
     * 构造函数
     * 默认圆角半径 4dp
     *
     * @param context
     */
    public GlideRoundTransform(Context context) {
        this(context, 4);
    }

    /**
     * 构造函数
     *
     * @param context Context
     * @param dp      圆角半径
     */
    public GlideRoundTransform(Context context, int dp) {
        super(context);
        this.radius = Resources.getSystem().getDisplayMetrics().density * dp;
    }

    private static Bitmap roundCrop(BitmapPool pool, Bitmap source) {
        if (source == null)
            return null;
        Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
        canvas.drawRoundRect(rectF, radius, radius, paint);
        return result;
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return roundCrop(pool, toTransform);
    }

    @Override
    public String getId() {
        return getClass().getName() + Math.round(radius);
    }
}
