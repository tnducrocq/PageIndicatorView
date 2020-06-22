package com.rd.draw.drawer.type;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import androidx.annotation.NonNull;

import com.rd.animation.data.Value;
import com.rd.animation.data.type.WormAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

public class WormDrawer extends BaseDrawer {

    public RectF rect;
    public Context context;

    public WormDrawer(@NonNull Paint paint, @NonNull Indicator indicator, @NonNull Context context) {
        super(paint, indicator);
        this.context = context;
        this.rect = new RectF();
    }

    public void draw(
            @NonNull Canvas canvas,
            @NonNull Value value,
            int coordinateX,
            int coordinateY) {

        if (!(value instanceof WormAnimationValue)) {
            return;
        }

        WormAnimationValue v = (WormAnimationValue) value;
        int rectStart = v.getRectStart();
        int rectEnd = v.getRectEnd();

        int radius = indicator.getRadius();
        int unselectedColor = indicator.getUnselectedColor();
        int unselectedDrawable = indicator.getUnselectedDrawable();
        int selectedColor = indicator.getSelectedColor();

        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            rect.left = rectStart;
            rect.right = rectEnd;
            rect.top = coordinateY - radius;
            rect.bottom = coordinateY + radius;

        } else {
            rect.left = coordinateX - radius;
            rect.right = coordinateX + radius;
            rect.top = rectStart;
            rect.bottom = rectEnd;
        }

        paint.setColor(unselectedColor);
        canvas.drawCircle(coordinateX, coordinateY, radius, paint);

        if (unselectedDrawable != -1) {
            Bitmap b = BitmapFactory.decodeResource(context.getResources(), unselectedDrawable);
            canvas.drawBitmap(b, coordinateX - 20, coordinateY - 20, paint);
        }

        paint.setColor(selectedColor);
        canvas.drawRoundRect(rect, radius, radius, paint);
    }
}
