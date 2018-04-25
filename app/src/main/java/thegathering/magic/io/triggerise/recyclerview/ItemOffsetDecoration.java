package thegathering.magic.io.triggerise.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by clifford.owino on 25/04/2018.
 */

public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

    private int mSpacing;

    public ItemOffsetDecoration(int itemOffset) {
        mSpacing = itemOffset;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mSpacing, mSpacing, mSpacing, mSpacing);
    }
}
