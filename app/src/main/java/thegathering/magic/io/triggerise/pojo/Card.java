//package thegathering.magic.io.triggerise.pojo;
//
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//import java.util.List;
//
///**
// * Created by clifford.owino on 25/04/2018.
// */
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonPropertyOrder({
//        "name",
//        "manaCost",
//        "cmc",
//        "colors",
//        "colorIdentity",
//        "type",
//        "types",
//        "subtypes",
//        "rarity",
//        "set",
//        "setName",
//        "text",
//        "artist",
//        "number",
//        "power",
//        "toughness",
//        "layout",
//        "multiverseid",
//        "imageUrl",
//        "printings",
//        "originalText",
//        "originalType",
//        "legalities",
//        "id"
//})
//public class Card implements Parcelable{
//
//    @JsonProperty("name")
//    private String name;
//    @JsonProperty("manaCost")
//    private String manaCost;
//    @JsonProperty("cmc")
//    private Integer cmc;
//    @JsonProperty("colors")
//    private List<String> colors = null;
//    @JsonProperty("colorIdentity")
//    private List<String> colorIdentity = null;
//    @JsonProperty("type")
//    private String type;
//    @JsonProperty("types")
//    private List<String> types = null;
//    @JsonProperty("subtypes")
//    private List<String> subtypes = null;
//    @JsonProperty("rarity")
//    private String rarity;
//    @JsonProperty("set")
//    private String set;
//    @JsonProperty("setName")
//    private String setName;
//    @JsonProperty("text")
//    private String text;
//    @JsonProperty("artist")
//    private String artist;
//    @JsonProperty("number")
//    private String number;
//    @JsonProperty("power")
//    private String power;
//    @JsonProperty("toughness")
//    private String toughness;
//    @JsonProperty("layout")
//    private String layout;
//    @JsonProperty("multiverseid")
//    private Integer multiverseid;
//    @JsonProperty("imageUrl")
//    private String imageUrl;
//    @JsonProperty("printings")
//    private List<String> printings = null;
//    @JsonProperty("originalText")
//    private String originalText;
//    @JsonProperty("originalType")
//    private String originalType;
//    @JsonProperty("legalities")
//    private List<Legality> legalities = null;
//    @JsonProperty("id")
//    private String id;
//
//    public Card() {
//        //required public empty constructor
//    }
//
//    protected Card(Parcel in) {
//        name = in.readString();
//        manaCost = in.readString();
//        if (in.readByte() == 0) {
//            cmc = null;
//        } else {
//            cmc = in.readInt();
//        }
//        colors = in.createStringArrayList();
//        colorIdentity = in.createStringArrayList();
//        type = in.readString();
//        types = in.createStringArrayList();
//        subtypes = in.createStringArrayList();
//        rarity = in.readString();
//        set = in.readString();
//        setName = in.readString();
//        text = in.readString();
//        artist = in.readString();
//        number = in.readString();
//        power = in.readString();
//        toughness = in.readString();
//        layout = in.readString();
//        if (in.readByte() == 0) {
//            multiverseid = null;
//        } else {
//            multiverseid = in.readInt();
//        }
//        imageUrl = in.readString();
//        printings = in.createStringArrayList();
//        originalText = in.readString();
//        originalType = in.readString();
//        legalities = in.createTypedArrayList(Legality.CREATOR);
//        id = in.readString();
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(name);
//        dest.writeString(manaCost);
//        if (cmc == null) {
//            dest.writeByte((byte) 0);
//        } else {
//            dest.writeByte((byte) 1);
//            dest.writeInt(cmc);
//        }
//        dest.writeStringList(colors);
//        dest.writeStringList(colorIdentity);
//        dest.writeString(type);
//        dest.writeStringList(types);
//        dest.writeStringList(subtypes);
//        dest.writeString(rarity);
//        dest.writeString(set);
//        dest.writeString(setName);
//        dest.writeString(text);
//        dest.writeString(artist);
//        dest.writeString(number);
//        dest.writeString(power);
//        dest.writeString(toughness);
//        dest.writeString(layout);
//        if (multiverseid == null) {
//            dest.writeByte((byte) 0);
//        } else {
//            dest.writeByte((byte) 1);
//            dest.writeInt(multiverseid);
//        }
//        dest.writeString(imageUrl);
//        dest.writeStringList(printings);
//        dest.writeString(originalText);
//        dest.writeString(originalType);
//        dest.writeTypedList(legalities);
//        dest.writeString(id);
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    public static final Creator<Card> CREATOR = new Creator<Card>() {
//        @Override
//        public Card createFromParcel(Parcel in) {
//            return new Card(in);
//        }
//
//        @Override
//        public Card[] newArray(int size) {
//            return new Card[size];
//        }
//    };
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
//    @JsonProperty("manaCost")
//    public String getManaCost() {
//        return manaCost;
//    }
//
//    @JsonProperty("manaCost")
//    public void setManaCost(String manaCost) {
//        this.manaCost = manaCost;
//    }
//
//    @JsonProperty("cmc")
//    public Integer getCmc() {
//        return cmc;
//    }
//
//    @JsonProperty("cmc")
//    public void setCmc(Integer cmc) {
//        this.cmc = cmc;
//    }
//
//    @JsonProperty("colors")
//    public List<String> getColors() {
//        return colors;
//    }
//
//    @JsonProperty("colors")
//    public void setColors(List<String> colors) {
//        this.colors = colors;
//    }
//
//    @JsonProperty("colorIdentity")
//    public List<String> getColorIdentity() {
//        return colorIdentity;
//    }
//
//    @JsonProperty("colorIdentity")
//    public void setColorIdentity(List<String> colorIdentity) {
//        this.colorIdentity = colorIdentity;
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
//    @JsonProperty("types")
//    public List<String> getTypes() {
//        return types;
//    }
//
//    @JsonProperty("types")
//    public void setTypes(List<String> types) {
//        this.types = types;
//    }
//
//    @JsonProperty("subtypes")
//    public List<String> getSubtypes() {
//        return subtypes;
//    }
//
//    @JsonProperty("subtypes")
//    public void setSubtypes(List<String> subtypes) {
//        this.subtypes = subtypes;
//    }
//
//    @JsonProperty("rarity")
//    public String getRarity() {
//        return rarity;
//    }
//
//    @JsonProperty("rarity")
//    public void setRarity(String rarity) {
//        this.rarity = rarity;
//    }
//
//    @JsonProperty("set")
//    public String getSet() {
//        return set;
//    }
//
//    @JsonProperty("set")
//    public void setSet(String set) {
//        this.set = set;
//    }
//
//    @JsonProperty("setName")
//    public String getSetName() {
//        return setName;
//    }
//
//    @JsonProperty("setName")
//    public void setSetName(String setName) {
//        this.setName = setName;
//    }
//
//    @JsonProperty("text")
//    public String getText() {
//        return text;
//    }
//
//    @JsonProperty("text")
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    @JsonProperty("artist")
//    public String getArtist() {
//        return artist;
//    }
//
//    @JsonProperty("artist")
//    public void setArtist(String artist) {
//        this.artist = artist;
//    }
//
//    @JsonProperty("number")
//    public String getNumber() {
//        return number;
//    }
//
//    @JsonProperty("number")
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    @JsonProperty("power")
//    public String getPower() {
//        return power;
//    }
//
//    @JsonProperty("power")
//    public void setPower(String power) {
//        this.power = power;
//    }
//
//    @JsonProperty("toughness")
//    public String getToughness() {
//        return toughness;
//    }
//
//    @JsonProperty("toughness")
//    public void setToughness(String toughness) {
//        this.toughness = toughness;
//    }
//
//    @JsonProperty("layout")
//    public String getLayout() {
//        return layout;
//    }
//
//    @JsonProperty("layout")
//    public void setLayout(String layout) {
//        this.layout = layout;
//    }
//
//    @JsonProperty("multiverseid")
//    public Integer getMultiverseid() {
//        return multiverseid;
//    }
//
//    @JsonProperty("multiverseid")
//    public void setMultiverseid(Integer multiverseid) {
//        this.multiverseid = multiverseid;
//    }
//
//    @JsonProperty("imageUrl")
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    @JsonProperty("imageUrl")
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    @JsonProperty("printings")
//    public List<String> getPrintings() {
//        return printings;
//    }
//
//    @JsonProperty("printings")
//    public void setPrintings(List<String> printings) {
//        this.printings = printings;
//    }
//
//    @JsonProperty("originalText")
//    public String getOriginalText() {
//        return originalText;
//    }
//
//    @JsonProperty("originalText")
//    public void setOriginalText(String originalText) {
//        this.originalText = originalText;
//    }
//
//    @JsonProperty("originalType")
//    public String getOriginalType() {
//        return originalType;
//    }
//
//    @JsonProperty("originalType")
//    public void setOriginalType(String originalType) {
//        this.originalType = originalType;
//    }
//
//    @JsonProperty("legalities")
//    public List<Legality> getLegalities() {
//        return legalities;
//    }
//
//    @JsonProperty("legalities")
//    public void setLegalities(List<Legality> legalities) {
//        this.legalities = legalities;
//    }
//
//    @JsonProperty("id")
//    public String getId() {
//        return id;
//    }
//
//    @JsonProperty("id")
//    public void setId(String id) {
//        this.id = id;
//    }
//
//
//}
