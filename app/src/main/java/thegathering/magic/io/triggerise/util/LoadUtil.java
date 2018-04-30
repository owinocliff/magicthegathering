package thegathering.magic.io.triggerise.util;

import java.util.List;

import io.magicthegathering.javasdk.resource.Card;
import io.magicthegathering.javasdk.resource.MtgSet;

/**
 * Created by clifford.owino on 25/04/2018.
 */

public class LoadUtil {
    public static List<MtgSet> loadSets(String setCode) {
        return RequestUtil.requestSetsData(setCode);
    }

    public static List<Card> loadCards(String setCode) {
        return RequestUtil.requestCardsList(setCode);
    }
}
