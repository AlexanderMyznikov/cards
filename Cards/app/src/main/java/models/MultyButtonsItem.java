package models;

/**
 * Created by Alex on 3/22/2015.
 */
public class MultyButtonsItem {
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
}
