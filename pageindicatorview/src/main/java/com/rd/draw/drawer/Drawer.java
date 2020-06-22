package com.rd.draw.drawer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.annotation.NonNull;

import com.rd.animation.data.Value;
import com.rd.draw.data.Indicator;
import com.rd.draw.drawer.type.BasicDrawer;
import com.rd.draw.drawer.type.ColorDrawer;
import com.rd.draw.drawer.type.DropDrawer;
import com.rd.draw.drawer.type.FillDrawer;
import com.rd.draw.drawer.type.ScaleDownDrawer;
import com.rd.draw.drawer.type.ScaleDrawer;
import com.rd.draw.drawer.type.SlideDrawer;
import com.rd.draw.drawer.type.SwapDrawer;
import com.rd.draw.drawer.type.ThinWormDrawer;
import com.rd.draw.drawer.type.WormDrawer;

public class Drawer {

    private BasicDrawer basicDrawer;
    private ColorDrawer colorDrawer;
    private ScaleDrawer scaleDrawer;
    private WormDrawer wormDrawer;
    private SlideDrawer slideDrawer;
    private FillDrawer fillDrawer;
    private ThinWormDrawer thinWormDrawer;
    private DropDrawer dropDrawer;
    private SwapDrawer swapDrawer;
    private ScaleDownDrawer scaleDownDrawer;

    private int position;
    private int coordinateX;
    private int coordinateY;

    public Drawer(@NonNull Indicator indicator, Context context) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        basicDrawer = new BasicDrawer(paint, indicator, context);
        colorDrawer = new ColorDrawer(paint, indicator, context);
        scaleDrawer = new ScaleDrawer(paint, indicator, context);
        wormDrawer = new WormDrawer(paint, indicator, context);
        slideDrawer = new SlideDrawer(paint, indicator, context);
        fillDrawer = new FillDrawer(paint, indicator, context);
        thinWormDrawer = new ThinWormDrawer(paint, indicator, context);
        dropDrawer = new DropDrawer(paint, indicator, context);
        swapDrawer = new SwapDrawer(paint, indicator, context);
        scaleDownDrawer = new ScaleDownDrawer(paint, indicator, context);
    }

    public void setup(int position, int coordinateX, int coordinateY) {
        this.position = position;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public void drawBasic(@NonNull Canvas canvas, boolean isSelectedItem) {
        if (colorDrawer != null) {
            basicDrawer.draw(canvas, position, isSelectedItem, coordinateX, coordinateY);
        }
    }

    public void drawColor(@NonNull Canvas canvas, @NonNull Value value) {
        if (colorDrawer != null) {
            colorDrawer.draw(canvas, value, position, coordinateX, coordinateY);
        }
    }

    public void drawScale(@NonNull Canvas canvas, @NonNull Value value) {
        if (scaleDrawer != null) {
            scaleDrawer.draw(canvas, value, position, coordinateX, coordinateY);
        }
    }

    public void drawWorm(@NonNull Canvas canvas, @NonNull Value value) {
        if (wormDrawer != null) {
            wormDrawer.draw(canvas, value, coordinateX, coordinateY);
        }
    }

    public void drawSlide(@NonNull Canvas canvas, @NonNull Value value) {
        if (slideDrawer != null) {
            slideDrawer.draw(canvas, value, coordinateX, coordinateY);
        }
    }

    public void drawFill(@NonNull Canvas canvas, @NonNull Value value) {
        if (fillDrawer != null) {
            fillDrawer.draw(canvas, value, position, coordinateX, coordinateY);
        }
    }

    public void drawThinWorm(@NonNull Canvas canvas, @NonNull Value value) {
        if (thinWormDrawer != null) {
            thinWormDrawer.draw(canvas, value, coordinateX, coordinateY);
        }
    }

    public void drawDrop(@NonNull Canvas canvas, @NonNull Value value) {
        if (dropDrawer != null) {
            dropDrawer.draw(canvas, value, coordinateX, coordinateY);
        }
    }

    public void drawSwap(@NonNull Canvas canvas, @NonNull Value value) {
        if (swapDrawer != null) {
            swapDrawer.draw(canvas, value, position, coordinateX, coordinateY);
        }
    }

    public void drawScaleDown(@NonNull Canvas canvas, @NonNull Value value) {
        if (scaleDownDrawer != null) {
            scaleDownDrawer.draw(canvas, value, position, coordinateX, coordinateY);
        }
    }
}
