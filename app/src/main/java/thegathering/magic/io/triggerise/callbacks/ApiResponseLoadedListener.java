package thegathering.magic.io.triggerise.callbacks;

import java.util.ArrayList;


/**
 * Created by clifford.owino on 25/04/2018.
 */

public interface ApiResponseLoadedListener<T> {
    /**
     * Called once all items have been loaded
     * @param listItems
     */
    void onApiResponseLoaded(ArrayList<T> listItems);
}
