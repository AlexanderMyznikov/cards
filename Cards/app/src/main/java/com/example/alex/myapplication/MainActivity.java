package com.example.alex.myapplication;

import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import adapters.CustomPageAdapter;
import fragments.OnFragmentChanged;
import models.CheckBoxItem;
import models.CheckBoxModel;
import models.Model;
import models.MultyButtonsItem;
import models.MultyButtonsModel;
import models.SinlgeTextModel;
import models.UploadPhotoModel;


public class MainActivity extends ActionBarActivity implements OnFragmentChanged {

    private List<Model> cardsModels;

    private CustomPageAdapter cardsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getQuestions();
        setAdapter();
    }

    private void setAdapter() {
        ViewPager pager = (ViewPager)findViewById(R.id.vp_pager);

        cardsAdapter = new CustomPageAdapter(getSupportFragmentManager());
        cardsAdapter.setCardsModels(cardsModels);



        pager.setAdapter(cardsAdapter);
    }


    @Override
    public void setAnswer(boolean isAnswered, Model answeredModel) {
        if(isAnswered){
            removeQuestionSendResult(answeredModel);
        }
    }

    private void removeQuestionSendResult(Model answeredModel) {
        cardsModels.remove(answeredModel);
        cardsAdapter.notifyDataSetChanged();
    }

    public List<Model> getCardsModels(){
        return cardsModels;
    }


    private void getQuestions(){
        cardsModels = new ArrayList<>();
        MultyButtonsModel multiButtonsModel = getMultyButtonsModel();

        CheckBoxModel checkBoxModel = new CheckBoxModel();
        List<CheckBoxItem> items = new ArrayList<>();

        CheckBoxItem checkBoxItem = new CheckBoxItem();
        checkBoxItem.setQuestion("Are you happy?");
        checkBoxItem.setState(true);
        items.add(checkBoxItem);

        CheckBoxItem checkBoxItem1 = new CheckBoxItem();
        checkBoxItem.setQuestion("Do you like your life?");
        checkBoxItem.setState(true);
        items.add(checkBoxItem1);

        CheckBoxItem checkBoxItem2 = new CheckBoxItem();
        checkBoxItem.setQuestion("Are you sure?");
        checkBoxItem.setState(false);
        items.add(checkBoxItem2);

        checkBoxModel.setQuestions(items);


        Model singleTextModel = new SinlgeTextModel();
        Model uploadPhotoModel = new UploadPhotoModel();

        cardsModels.add(multiButtonsModel);
        cardsModels.add(checkBoxModel);
        cardsModels.add(singleTextModel);
        cardsModels.add(uploadPhotoModel);
    }

    private MultyButtonsModel getMultyButtonsModel() {
        MultyButtonsModel multiButtonsModel = new MultyButtonsModel();

        List<MultyButtonsItem> items = new ArrayList<>();
        MultyButtonsItem item = new MultyButtonsItem();
        item.setImgUrl("http://www.businessinsider.com/image/4f3433986bb3f7b67a00003c/cute-cat.jpg");
        item.setText("do you like this?");
        items.add(item);

        MultyButtonsItem item2 = new MultyButtonsItem();
        item.setImgUrl("http://i.ytimg.com/vi/mSFTRoBY99s/hqdefault.jpg");
        item.setText("or maybe this?");
        items.add(item2);
        multiButtonsModel.setItems(items);
        return multiButtonsModel;
    }

}
