package models;

import java.util.List;

/**
 * Created by Alex on 3/22/2015.
 */
public class MultyButtonsModel extends Model {
    private List<MultyButtonsItem> items;

    public List<MultyButtonsItem> getItems() {
        return items;
    }

    public void setItems(List<MultyButtonsItem> items) {
        this.items = items;
    }
}
