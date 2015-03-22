package models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 22.03.2015.
 */
public class Variant implements Parcelable {

    private String text;
    private String image;
    private int id;




    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.text);
        dest.writeString(this.image);
        dest.writeInt(id);
    }

    public Variant() {
    }

    private Variant(Parcel in) {
        this.text = in.readString();
        this.image = in.readString();
        this.id = in.readInt();
    }

    public static final Parcelable.Creator<Variant> CREATOR = new Parcelable.Creator<Variant>() {
        public Variant createFromParcel(Parcel source) {
            return new Variant(source);
        }

        public Variant[] newArray(int size) {
            return new Variant[size];
        }
    };
}
