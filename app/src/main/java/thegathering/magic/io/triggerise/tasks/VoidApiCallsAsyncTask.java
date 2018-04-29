package thegathering.magic.io.triggerise.tasks;

import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by clifford.owino on 28/04/2018.
 */

public abstract class VoidApiCallsAsyncTask<T> extends AsyncTask<Void, Void, ArrayList<T>> {
    public void execute() {
        super.execute();
    }
}
