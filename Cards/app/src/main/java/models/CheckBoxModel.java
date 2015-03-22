package models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alex on 3/22/2015.
 */
public class CheckBoxModel extends Model implements Parcelable {
    public Variant[] variants;

    public Variant[] getVariants(){
        return variants;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelableArray(this.variants, flags);
        dest.writeInt(this.id);
        dest.writeString(this.text);
        dest.writeByte(favourite ? (byte) 1 : (byte) 0);
    }

    public CheckBoxModel() {
    }

    private CheckBoxModel(Parcel in) {
        this.variants = (Variant[]) in.readParcelableArray(Variant[].class.getClassLoader());
        this.id = in.readInt();
        this.text = in.readString();
        this.favourite = in.readByte() != 0;
    }

    public static final Creator<CheckBoxModel> CREATOR = new Creator<CheckBoxModel>() {
        public CheckBoxModel createFromParcel(Parcel source) {
            return new CheckBoxModel(source);
        }

        public CheckBoxModel[] newArray(int size) {
            return new CheckBoxModel[size];
        }
    };
}
