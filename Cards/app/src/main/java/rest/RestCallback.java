package rest;

/**
 * Created by Admin on 22.03.2015.
 */
public interface RestCallback {

    public void onSuccess(Object response);

    public void onFailure(String error);
}
