package models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alex on 3/22/2015.
 */
public class Model implements Parcelable {
    public int id;
    public String text;
    public int points;
    public boolean favourite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.text);
        dest.writeByte(favourite ? (byte) 1 : (byte) 0);
    }

    public Model() {
    }

    private Model(Parcel in) {
        this.id = in.readInt();
        this.text = in.readString();
        this.favourite = in.readByte() != 0;
    }

}
