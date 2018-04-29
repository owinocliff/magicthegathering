package thegathering.magic.io.triggerise.util;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import thegathering.magic.io.triggerise.log.L;
import thegathering.magic.io.triggerise.pojo.Keys;

/**
 * Created by clifford.owino on 25/04/2018.
 */

public class RequestUtil {

    public static JSONObject requestSetsData(RequestQueue requestQueue) {
        String url = Keys.keys.BASE_URL+"/sets";
        L.m("url "+url);
        JSONObject response = null;
        RequestFuture<JSONObject> requestFuture = RequestFuture.newFuture();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url,
                (String) null, requestFuture, requestFuture);

        requestQueue.add(request);

        try {
            response = requestFuture.get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            L.m(e + "");
        } catch (ExecutionException e) {
            L.m(e + "");
        } catch (TimeoutException e) {
            L.m(e + "");
        }
        return response;
    }
}
