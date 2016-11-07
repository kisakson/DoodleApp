package cmsc434.doodler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kara on 11/5/16.
 */

public class PaintView extends View {



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

    private void init(AttributeSet attrs, int defStyle) {
        // do stuff
    }
}
