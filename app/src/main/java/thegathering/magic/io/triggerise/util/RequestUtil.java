package thegathering.magic.io.triggerise.util;

import com.android.volley.RequestQueue;

import java.util.ArrayList;
import java.util.List;

import io.magicthegathering.javasdk.api.SetAPI;
import io.magicthegathering.javasdk.resource.Card;
import io.magicthegathering.javasdk.resource.MtgSet;
import thegathering.magic.io.triggerise.log.L;

/**
 * Created by clifford.owino on 25/04/2018.
 */

class RequestUtil {

    static List<MtgSet> requestSetsData(String setCode) {

        L.m("requestSetsData setCode " + setCode);

        if (setCode != null && setCode.length()>1) {
            List<MtgSet> currentList = new ArrayList<>();
            currentList.add(SetAPI.getSet(setCode));
            return currentList;
        }

        return SetAPI.getAllSets();
    }

    static List<Card> requestCardsList(String setCode) {

        L.m("requestCardsList setCode " + setCode);
        if (setCode != null && setCode.length()>1) {
            return SetAPI.getBooster(setCode);
        }
        return null;
    }

}
