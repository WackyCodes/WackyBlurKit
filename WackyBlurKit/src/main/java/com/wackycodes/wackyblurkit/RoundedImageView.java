package com.wackycodes.wackyblurkit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;


@SuppressLint("AppCompatCustomView")
public class RoundedImageView extends ImageView {
    private float mCornerRadius = 0;
    public static final int DEFAULT_COLOR = 0xff000000;
    public static final int DEFAULT_RGB = 0;

    private RectF rectF;
    private PorterDuffXfermode porterDuffXfermode;

    public RoundedImageView(Context context) {
        this(context, null);
    }

    public RoundedImageView(Context context, AttributeSet attributes) {
        this(context, attributes,0);
    }

    public RoundedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr){
        rectF = new RectF();
        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable myDrawable = getDrawable();
        if (myDrawable instanceof BitmapDrawable && mCornerRadius > 0) {
            rectF.set(myDrawable.getBounds());
            int prevCount = canvas.saveLayer(rectF, null, Canvas.ALL_SAVE_FLAG);
            getImageMatrix().mapRect(rectF);

            // Object used to draw
            Paint paint = ((BitmapDrawable) myDrawable).getPaint();
            paint.setAntiAlias(true);
            paint.setColor(DEFAULT_COLOR);
            Xfermode prevMode = paint.getXfermode();

            canvas.drawARGB(DEFAULT_RGB, DEFAULT_RGB, DEFAULT_RGB, DEFAULT_RGB);

            canvas.drawRoundRect(rectF, mCornerRadius, mCornerRadius, paint);

            paint.setXfermode(porterDuffXfermode);
            super.onDraw(canvas);

            paint.setXfermode(prevMode);
            canvas.restoreToCount(prevCount);
        } else {
            super.onDraw(canvas);
        }
    }

    public void setCornerRadius(float cornerRadius) {
        this.mCornerRadius = cornerRadius;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }


}