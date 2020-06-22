package com.rd.draw.drawer.type;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.annotation.NonNull;

import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;

public class BasicDrawer extends BaseDrawer {

    private Paint strokePaint;
    public Context context;

    public BasicDrawer(@NonNull Paint paint, @NonNull Indicator indicator, @NonNull Context context) {
        super(paint, indicator);
        this.context = context;

        strokePaint = new Paint();
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setAntiAlias(true);
        strokePaint.setStrokeWidth(indicator.getStroke());
    }

    public void draw(
            @NonNull Canvas canvas,
            int position,
            boolean isSelectedItem,
            int coordinateX,
            int coordinateY) {

        float radius = indicator.getRadius();
        int strokePx = indicator.getStroke();
        float scaleFactor = indicator.getScaleFactor();

        int selectedColor = indicator.getSelectedColor();
        int unselectedColor = indicator.getUnselectedColor();
        int selectedPosition = indicator.getSelectedPosition();
        AnimationType animationType = indicator.getAnimationType();

        if (animationType == AnimationType.SCALE && !isSelectedItem) {
            radius *= scaleFactor;

        } else if (animationType == AnimationType.SCALE_DOWN && isSelectedItem) {
            radius *= scaleFactor;
        }

        int color = unselectedColor;
        if (position == selectedPosition) {
            color = selectedColor;
        }

        Paint paint;
        if (animationType == AnimationType.FILL && position != selectedPosition) {
            paint = strokePaint;
            paint.setStrokeWidth(strokePx);
        } else {
            paint = this.paint;
        }
        
        int unselectedDrawable = indicator.getUnselectedDrawable();
        if (!isSelectedItem && unselectedDrawable != -1) {
            Bitmap b = BitmapFactory.decodeResource(context.getResources(), unselectedDrawable);
            canvas.drawBitmap(b, coordinateX - 20, coordinateY - 20, paint);
        } else {
            paint.setColor(color);
            canvas.drawCircle(coordinateX, coordinateY, radius, paint);
        }
    }
}
