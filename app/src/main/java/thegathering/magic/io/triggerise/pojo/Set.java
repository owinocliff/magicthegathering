//package thegathering.magic.io.triggerise.pojo;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by clifford.owino on 25/04/2018.
// */
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonPropertyOrder({
//        "code",
//        "name",
//        "type",
//        "border",
//        "mkm_id",
//        "booster",
//        "mkm_name",
//        "releaseDate"
//})
//public class Set implements Parcelable {
//
//    @JsonProperty("code")
//    private String code;
//    @JsonProperty("name")
//    private String name;
//    @JsonProperty("type")
//    private String type;
//    @JsonProperty("border")
//    private String border;
//    @JsonProperty("mkm_id")
//    private Integer mkmId;
//    @JsonProperty("booster")
//    private List booster;
//    @JsonProperty("mkm_name")
//    private String mkmName;
//    @JsonProperty("releaseDate")
//    private String releaseDate;
//
//    public Set() {
//        //required empty public constructor
//    }
//
//    protected Set(Parcel in) {
//        code = in.readString();
//        name = in.readString();
//        type = in.readString();
//        border = in.readString();
//        if (in.readByte() == 0) {
//            mkmId = null;
//        } else {
//            mkmId = in.readInt();
//        }
//        booster = in.createStringArrayList();
//        mkmName = in.readString();
//        releaseDate = in.readString();
//    }
//
//    public static final Creator<Set> CREATOR = new Creator<Set>() {
//        @Override
//        public Set createFromParcel(Parcel in) {
//            return new Set(in);
//        }
//
//        @Override
//        public Set[] newArray(int size) {
//            return new Set[size];
//        }
//    };
//
//    @JsonProperty("code")
//    public String getCode() {
//        return code;
//    }
//
//    @JsonProperty("code")
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    @JsonProperty("name")
//    public String getName() {
//        return name;
//    }
//
//    @JsonProperty("name")
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @JsonProperty("type")
//    public String getType() {
//        return type;
//    }
//
//    @JsonProperty("type")
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    @JsonProperty("border")
//    public String getBorder() {
//        return border;
//    }
//
//    @JsonProperty("border")
//    public void setBorder(String border) {
//        this.border = border;
//    }
//
//    @JsonProperty("mkm_id")
//    public Integer getMkmId() {
//        return mkmId;
//    }
//
//    @JsonProperty("mkm_id")
//    public void setMkmId(Integer mkmId) {
//        this.mkmId = mkmId;
//    }
//
//    @JsonProperty("booster")
//    public List getBooster() {
//        return booster;
//    }
//
//    @JsonProperty("booster")
//    public void setBooster(List  booster) {
//        this.booster = booster;
//    }
//
//    @JsonProperty("mkm_name")
//    public String getMkmName() {
//        return mkmName;
//    }
//
//    @JsonProperty("mkm_name")
//    public void setMkmName(String mkmName) {
//        this.mkmName = mkmName;
//    }
//
//    @JsonProperty("releaseDate")
//    public String getReleaseDate() {
//        return releaseDate;
//    }
//
//    @JsonProperty("releaseDate")
//    public void setReleaseDate(String releaseDate) {
//        this.releaseDate = releaseDate;
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(code);
//        dest.writeString(name);
//        dest.writeString(type);
//        dest.writeString(border);
//        if (mkmId == null) {
//            dest.writeByte((byte) 0);
//        } else {
//            dest.writeByte((byte) 1);
//            dest.writeInt(mkmId);
//        }
//        dest.writeStringList(booster);
//        dest.writeString(mkmName);
//        dest.writeString(releaseDate);
//    }
//
//    @Override
//    public String toString() {
//        return "Set{" +
//                "code='" + code + '\'' +
//                ", name='" + name + '\'' +
//                ", type='" + type + '\'' +
//                ", border='" + border + '\'' +
//                ", mkmId=" + mkmId +
//                ", booster=" + booster +
//                ", mkmName='" + mkmName + '\'' +
//                ", releaseDate='" + releaseDate + '\'' +
//                '}';
//    }
//}
