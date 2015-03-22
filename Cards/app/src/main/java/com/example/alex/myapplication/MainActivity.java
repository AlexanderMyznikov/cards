package com.example.alex.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import fragments.OnFragmentChanged;
import models.CheckBoxModel;
import models.Model;
import models.MultyButtonsModel;
import models.SinlgeTextModel;
import models.UploadPhotoModel;


public class MainActivity extends ActionBarActivity implements OnFragmentChanged {

    private List<Model> cardsModels;
    public Model currentCardModel;
    private int currentCardPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getQuestions();
        setAdapter();
    }

    private void setAdapter() {
        
    }


    @Override
    public void setAnswer(boolean isAnswered, Model answeredModel) {
        if(isAnswered){
            removeQuestionSendResult(answeredModel);
        }else {
            nextQuestion(answeredModel);
        }
    }

    private void removeQuestionSendResult(Model answeredModel) {
        currentCardPosition = cardsModels.indexOf(answeredModel);
        cardsModels.remove(answeredModel);

        if(currentCardPosition > cardsModels.size()|| currentCardPosition == -1){
            currentCardPosition = 0;
        }
        currentCardModel = cardsModels.get(currentCardPosition);
    }

    private void nextQuestion(Model answeredModel){
        currentCardPosition = cardsModels.indexOf(answeredModel);
        if(currentCardPosition > cardsModels.size()){
            currentCardPosition = 0;
        }else {
            currentCardPosition++;
        }

        currentCardModel = cardsModels.get(currentCardPosition);
    }

    private void changeFragment(){
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
