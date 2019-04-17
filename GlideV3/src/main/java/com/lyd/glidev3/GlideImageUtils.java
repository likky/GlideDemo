package com.lyd.glidev3;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;


/**
 * 描述: Glide加载图片工具类
 * 作者: LYD
 * 创建日期: 2019/4/15 17:19
 */
public class GlideImageUtils {
    private static GlideImageUtils imageUtils;

    public static GlideImageUtils getInstance() {
        if (imageUtils == null) {
            imageUtils = new GlideImageUtils();
        }
        return imageUtils;
    }

    /**
     * 加载普通图片
     *
     * @param context    (可不填,使用全局Context)
     * @param errorResId 默认图片
     * @param imagePath  图片路径
     * @param imageView  显示图片的目标
     */
    public void loadImage(Context context, int errorResId, String imagePath, ImageView imageView) {
        Glide.with(context)
                .load(imagePath)
                .asBitmap()
                .placeholder(errorResId <= 0 ? R.drawable.default_img : errorResId)
                .error(errorResId <= 0 ? R.drawable.default_img : errorResId).into(imageView);
    }


    /**
     * 加载圆角图片
     * xml文件不需要设置CenterCrop
     *
     * @param context
     * @param errorResId 默认图片
     * @param imagePath
     * @param imageView
     */
    public void loadRoundImage(Context context, int errorResId, String imagePath, ImageView imageView) {
        Glide.with(context)
                .load(imagePath)
                .asBitmap()
                .placeholder(errorResId <= 0 ? R.drawable.default_img : errorResId)
                .error(errorResId <= 0 ? R.drawable.default_img : errorResId)
                .transform(new CenterCrop(context), new GlideRoundTransform(context))
                .into(imageView);
    }

    /**
     * 加载圆形图片
     *
     * @param context
     * @param errorResId 默认图片
     * @param imagePath
     * @param imageView
     */
    public void loadCircleImage(Context context, int errorResId, String imagePath, ImageView imageView) {
        Glide.with(context)
                .load(imagePath)
                .asBitmap()
                .placeholder(errorResId <= 0 ? R.drawable.default_img : errorResId)
                .error(errorResId <= 0 ? R.drawable.default_img : errorResId)
                .transform(new CenterCrop(context), new GlideCircleTransform(context))
                .into(imageView);
    }

    /**
     * 高斯模糊
     *
     * @param context
     * @param errorResId
     * @param imagePath
     * @param imageView
     */
    public void loadBlurImage(Context context, int errorResId, String imagePath, ImageView imageView) {
        Glide.with(context)
                .load(imagePath)
                .asBitmap()
                .placeholder(errorResId <= 0 ? R.drawable.default_img : errorResId)
                .error(errorResId <= 0 ? R.drawable.default_img : errorResId)
                .transform(new GlideBlurTransformation(context))// 高斯模糊处理
                .into(imageView);
    }

    /**
     * 需引入:glide-transformations
     * 矩形圆角 ImageView
     *
     * @param context    上下文
     * @param errorResId 错误的资源图片
     * @param url        图片链接
     * @param imageView  组件
     */
    public void showImageViewToRoundedCorners(Context context, int errorResId, String url, ImageView imageView) {
        //        Glide.with(context).load(url)
        //                .error(errorResId)//设置错误图片
        //                .bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL))//设置矩形圆角
        //                .diskCacheStrategy(DiskCacheStrategy.RESULT)//缓存修改过的图片
        //                .into(imageView);
    }


}
