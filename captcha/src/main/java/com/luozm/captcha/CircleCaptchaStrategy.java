package com.luozm.captcha;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;

import androidx.annotation.NonNull;

import java.util.Random;


public class CircleCaptchaStrategy extends CaptchaStrategy {

    public CircleCaptchaStrategy(Context ctx) {
        super(ctx);
    }

    @Override
    public Path getBlockShape(int blockSize) {
        // 圆形的半径为块大小的一半
        int radius = blockSize / 2;
        Path path = new Path();

        // 添加一个圆形到路径中，圆心位于 (blockSize / 2, blockSize / 2)，半径为 radius
        path.addCircle(blockSize / 2f, blockSize / 2f, radius, Path.Direction.CW);

        return path;
    }

    @Override
    public @NonNull PositionInfo getBlockPositionInfo(int width, int height, int blockSize) {
        Random random = new Random();
        int left = random.nextInt(width - blockSize + 1);
        if (left < blockSize) {
            left = blockSize;
        }
        int top = random.nextInt(height - blockSize + 1);
        return new PositionInfo(left, top);
    }

    @Override
    public @NonNull PositionInfo getPositionInfoForSwipeBlock(int width, int height, int blockSize) {
        Random random = new Random();
        int left = random.nextInt(width - blockSize + 1);
        int top = random.nextInt(height - blockSize + 1);
        return new PositionInfo(left, top);
    }

    @Override
    public Paint getBlockShadowPaint() {
        Paint shadowPaint = new Paint();
        shadowPaint.setColor(Color.parseColor("#000000"));
        shadowPaint.setAlpha(165);
        return shadowPaint;
    }

    @Override
    public Paint getBlockBitmapPaint() {
        return new Paint();
    }


    @Override
    public void decorationSwipeBlockBitmap(Canvas canvas, Path shape) {
//        Paint paint = new Paint();
//        paint.setColor(Color.parseColor("#FFFFFF"));
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(10);
//        paint.setPathEffect(new DashPathEffect(new float[]{20, 20}, 10));
//        Path path = new Path(shape);
//        canvas.drawPath(path, paint);
    }
}
