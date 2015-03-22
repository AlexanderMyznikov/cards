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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setAnswer(boolean isAnswered, Model answeredModel) {


        if(isAnswered){
            removeQuestionSendResult(answeredModel);
        }
    }


    private void removeQuestionSendResult(Model answeredModel) {

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
