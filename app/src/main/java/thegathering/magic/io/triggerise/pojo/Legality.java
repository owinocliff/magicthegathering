package thegathering.magic.io.triggerise.pojo;


import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by clifford.owino on 25/04/2018.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "format",
        "legality"
})
public class Legality implements Parcelable{

    @JsonProperty("format")
    private String format;
    @JsonProperty("legality")
    private String legality;

    protected Legality(Parcel in) {
        format = in.readString();
        legality = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(format);
        dest.writeString(legality);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Legality> CREATOR = new Creator<Legality>() {
        @Override
        public Legality createFromParcel(Parcel in) {
            return new Legality(in);
        }

        @Override
        public Legality[] newArray(int size) {
            return new Legality[size];
        }
    };

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("legality")
    public String getLegality() {
        return legality;
    }

    @JsonProperty("legality")
    public void setLegality(String legality) {
        this.legality = legality;
    }
}
