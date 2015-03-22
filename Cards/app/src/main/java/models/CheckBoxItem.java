package models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 22.03.2015.
 */
public class CheckBoxItem implements Parcelable {
    private String question;
    private boolean state;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.question);
        dest.writeByte(state ? (byte) 1 : (byte) 0);
    }

    public CheckBoxItem() {
    }

    private CheckBoxItem(Parcel in) {
        this.question = in.readString();
        this.state = in.readByte() != 0;
    }

    public static final Parcelable.Creator<CheckBoxItem> CREATOR = new Parcelable.Creator<CheckBoxItem>() {
        public CheckBoxItem createFromParcel(Parcel source) {
            return new CheckBoxItem(source);
        }

        public CheckBoxItem[] newArray(int size) {
            return new CheckBoxItem[size];
        }
    };
}
