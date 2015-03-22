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
import models.CheckBoxModel;
import models.Model;
import models.MultyButtonsModel;
import models.SinlgeTextModel;
import models.UploadPhotoModel;


public class MainActivity extends ActionBarActivity implements OnFragmentChanged {

    private List<Model> cardsModels;
    public Model currentCardModel;
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


<<<<<<< HEAD
    private void removeQuestionSendResult(Model answeredModel) {

=======
    private void changeFragment(){
>>>>>>> origin/master
    }

    private void getQuestions(){
        cardsModels = new ArrayList<>();
        Model multiButtonsModel = new MultyButtonsModel();
        Model checkBoxModel = new CheckBoxModel();
        Model singleTextModel = new SinlgeTextModel();
        Model uploadPhotoModel = new UploadPhotoModel();

        cardsModels.add(multiButtonsModel);
        cardsModels.add(checkBoxModel);
        cardsModels.add(singleTextModel);
        cardsModels.add(uploadPhotoModel);
    }
}
