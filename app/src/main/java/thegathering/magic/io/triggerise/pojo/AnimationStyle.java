package thegathering.magic.io.triggerise.pojo;

/**
 * Created by clifford.owino on 25/04/2018.
 */

public class AnimationStyle {
    private final String mName;
    private final int mResourceId;

    public AnimationStyle(String name, int resourceId) {
        mName = name;
        mResourceId = resourceId;
    }

    public String getName() {
        return mName;
    }

    public int getResourceId() {
        return mResourceId;
    }
}
