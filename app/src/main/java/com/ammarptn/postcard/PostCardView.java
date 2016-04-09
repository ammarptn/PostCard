package com.ammarptn.postcard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by ammarptn on 2/28/2016.
 */
public class PostCardView extends View {
    private final Paint mTextPaint;
    private int mWidth;
    private int mHeight;
    String text = "";

    public PostCardView(Context context) {
        super(context);

        mTextPaint = new Paint();
        mTextPaint.setColor(Color.BLACK);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        mHeight = View.MeasureSpec.getSize(heightMeasureSpec);


    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);




    }


}
