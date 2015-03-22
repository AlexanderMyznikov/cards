package models;

import java.util.List;

/**
 * Created by Alex on 3/22/2015.
 */
public class CheckBoxModel extends Model {
    public List<CheckBoxItem> getQuestions() {
        return questions;
    }

    public void setQuestions(List<CheckBoxItem> questions) {
        this.questions = questions;
    }

    public List<CheckBoxItem> questions;

}
