package rest;

import android.graphics.Bitmap;

/**
 * Created by Admin on 22.03.2015.
 */
public interface BitmapLoadListener {
    public void onSuccess(Bitmap bitmap);
    public void onFailure(String error);
}
