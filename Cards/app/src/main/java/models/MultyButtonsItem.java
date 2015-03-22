package models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alex on 3/22/2015.
 */
public class MultyButtonsItem implements Parcelable {
    public String getImgUrl() {
        return imgUrl;
    }

    public String getText() {
        return text;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String imgUrl;
    private String text;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imgUrl);
        dest.writeString(this.text);
    }

    public MultyButtonsItem() {
    }

    private MultyButtonsItem(Parcel in) {
        this.imgUrl = in.readString();
        this.text = in.readString();
    }

    public static final Parcelable.Creator<MultyButtonsItem> CREATOR = new Parcelable.Creator<MultyButtonsItem>() {
        public MultyButtonsItem createFromParcel(Parcel source) {
            return new MultyButtonsItem(source);
        }

        public MultyButtonsItem[] newArray(int size) {
            return new MultyButtonsItem[size];
        }
    };
}
