package cmsc434.doodler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DoodleView extends View {

    private Paint _paintDoodle = new Paint(); // Current value
    private Path _path = new Path(); // Current value
    private ArrayList<Paint> _paints = new ArrayList<Paint>();
    private ArrayList<Path> _paths = new ArrayList<Path>();
    // TODO store int that is number of paths to draw
    // TODO works with undo and redo functionality
    // TODO add to arraylist at position i+1
    // TODO undo: set i to i--
    // TODO redo: set i to i++

    public DoodleView(Context context) {
        super(context);
        init(null, 0);
    }

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DoodleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        _paintDoodle.setAntiAlias(true);
        _paintDoodle.setStyle(Paint.Style.STROKE);
        _paintDoodle.setStrokeCap(Paint.Cap.ROUND);
        _paintDoodle.setStrokeJoin(Paint.Join.ROUND);
    }

    public void setPaint(int size, int hue, int saturation, int brightness, int opacity) {
        Color color = new Color();
        float[] hsb = new float[3];
        hsb[0] = hue;
        hsb[1] = (float) saturation/256;
        hsb[2] = (float) brightness/256;
        _paintDoodle.setColor(color.HSVToColor(hsb));
        _paintDoodle.setStrokeWidth(size);
        _paintDoodle.setAlpha(opacity);
    }

    public ArrayList<Paint> getPaints() {
        return _paints;
    }

    public ArrayList<Path> getPaths() {
        return _paths;
    }

    public void recreateDrawings(ArrayList<Paint> paints, ArrayList<Path> paths) {
        _paints = paints;
        _paths = paths;
    }

    public void clear() {
        _paints = new ArrayList<Paint>();
        _paths = new ArrayList<Path>();
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < _paths.size(); i++) {
            canvas.drawPath(_paths.get(i), _paints.get(i));
        }
        canvas.drawPath(_path, _paintDoodle);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();

        switch(motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                _path.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                _path.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                _paints.add(_paintDoodle);
                _paths.add(_path);
                _path = new Path();
        }

        invalidate();
        return true;
    }
}
