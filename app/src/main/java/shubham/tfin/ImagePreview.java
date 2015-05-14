package shubham.tfin;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by shubham on 10/5/15.
 */
public class ImagePreview extends Dialog{
    public ImagePreview(Context context) {
        super(context);
        setContentView(R.layout.image_preview);
    }

}
