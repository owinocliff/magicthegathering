package thegathering.magic.io.triggerise.tasks;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

import thegathering.magic.io.triggerise.callbacks.ApiResponseLoadedListener;
import thegathering.magic.io.triggerise.network.VolleySingleton;
import thegathering.magic.io.triggerise.pojo.Set;
import thegathering.magic.io.triggerise.util.LoadUtil;

/**
 * Created by clifford.owino on 25/04/2018.
 */

public class TaskLoadFromApi<T> extends AsyncTask<Void, Void, ArrayList<T>> {
    private ApiResponseLoadedListener myComponent;
    private RequestQueue requestQueue;

    /**
     * @param myComponent | requesting context
     * @param objectClass
     */
    public TaskLoadFromApi(ApiResponseLoadedListener myComponent, Class<T> objectClass) {

        this.myComponent = myComponent;
        requestQueue = VolleySingleton.getInstance().getRequestQueue();

    }


    @Override
    protected ArrayList<T> doInBackground(Void... params) {
        return (ArrayList<T>) LoadUtil.loadSets(requestQueue);
    }

    @Override
    protected void onPostExecute(ArrayList<T> responsePayload) {
        if (myComponent != null) {
            myComponent.onApiResponseLoaded(responsePayload);
        }
    }
}
