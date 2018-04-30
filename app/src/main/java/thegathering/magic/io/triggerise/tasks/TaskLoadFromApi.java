package thegathering.magic.io.triggerise.tasks;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

import thegathering.magic.io.triggerise.callbacks.ApiResponseLoadedListener;
import thegathering.magic.io.triggerise.network.VolleySingleton;
import thegathering.magic.io.triggerise.util.LoadUtil;

/**
 * Created by clifford.owino on 25/04/2018.
 */

public class TaskLoadFromApi<T> extends VoidApiCallsAsyncTask {
    private ApiResponseLoadedListener myComponent;
    private RequestQueue requestQueue;
    private String setCode;
    private boolean loadingSet = false;

    /**
     * @param myComponent | requesting context
     */
    public TaskLoadFromApi(ApiResponseLoadedListener myComponent, String setCode, boolean loadingSet) {

        this.myComponent = myComponent;
        requestQueue = VolleySingleton.getInstance().getRequestQueue();
        this.setCode = setCode;
        this.loadingSet = loadingSet;

    }

    @Override
    protected void onPostExecute(Object responsePayload) {
        if (myComponent != null) {
            myComponent.onApiResponseLoaded((ArrayList<T>) responsePayload);
        }
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        if (loadingSet) {
            return LoadUtil.loadSets(setCode);
        } else {
            return LoadUtil.loadCards(setCode);
        }
    }
}
