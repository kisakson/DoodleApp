package cmsc434.doodler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class PaintView extends View {

    private int size; // Saved to redraw the circle with a given radius
    private Paint _paint = new Paint();

    public PaintView(Context context) {
        super(context);
        init(null, 0);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public PaintView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) { }

    public void updatePaint(int size, int hue, int saturation, int brightness, int opacity) {
        this.size = size;
        Color color = new Color();
        float[] hsb = new float[3];
        hsb[0] = hue;
        hsb[1] = (float) saturation/256;
        hsb[2] = (float) brightness/256;
        _paint.setColor(color.HSVToColor(hsb));
        _paint.setStrokeWidth(size);
        _paint.setAlpha(opacity);
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(PaintView.this.getWidth()/2, PaintView.this.getHeight()/2, (float) size/2, _paint);
    }

}
