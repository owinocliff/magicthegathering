package thegathering.magic.io.triggerise.log;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by clifford.owino on 25/04/2018.
 */

public class L {
    public static void m(String message) {
        Log.d("Triggerise", "" + message);
    }

    public static void t(Context context, String message) {
        Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show();
    }

    public static void T(Context context, String message) {
        Toast.makeText(context, "" + message, Toast.LENGTH_LONG).show();
    }
}
