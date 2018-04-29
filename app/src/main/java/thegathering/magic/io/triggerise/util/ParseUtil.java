package thegathering.magic.io.triggerise.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import thegathering.magic.io.triggerise.log.L;
import thegathering.magic.io.triggerise.pojo.Set;

import static thegathering.magic.io.triggerise.pojo.Keys.keys.CARDS;
import static thegathering.magic.io.triggerise.pojo.Keys.keys.SETS;

/**
 * Created by clifford.owino on 25/04/2018.
 */

public class ParseUtil {

    public static boolean contains(JSONObject jsonObject, String key) {
        return jsonObject != null && !key.matches("false") && jsonObject.has(key) && !jsonObject.isNull(key) && !key.matches("null");
    }

    public static ArrayList<Set> parseSets(JSONObject response) {

        L.m("response " + response);
        ArrayList<Set> theList = null;
        if (contains(response, SETS)) {

            try {
                L.m("response.getString(SETS) " + response.getString(SETS));
                ObjectMapper mapper = new ObjectMapper();
                CollectionType javaType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Set.class);
                L.m("response.getString(SETS) "+response.getString(SETS));
                theList = mapper.readValue(response.getString(SETS), javaType);

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        L.m("theList " + theList);
        return theList;
    }
}
