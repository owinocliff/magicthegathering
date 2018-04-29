package thegathering.magic.io.triggerise.util;

import com.android.volley.RequestQueue;

import org.json.JSONObject;

import java.util.ArrayList;

import thegathering.magic.io.triggerise.pojo.Set;

/**
 * Created by clifford.owino on 25/04/2018.
 */

public class LoadUtil {
    public static ArrayList<Set> loadSets(RequestQueue requestQueue) {
        JSONObject response = RequestUtil.requestSetsData(requestQueue);
        ArrayList<Set> listCategories = ParseUtil.parseSets(response);
//        MyApplication.getWritableDatabase().insertDelivery(listDeliveries, true);
        return listCategories;
    }
}
